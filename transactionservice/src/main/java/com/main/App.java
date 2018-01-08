package com.main;


import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONObject;

import com.dao.AppDAO;
import com.dao.TransactionException;
import com.resource.Sum;
import com.resource.Transaction;

@Path("/")
public class App {

	public String RESPONSE_FAILURE = "{\"status\":\"failure\"}";
	public String RESPONSE_SUCCESS = "{\"status\":\"success\"}";

	DecimalFormat decimalFormat = new DecimalFormat(".##");

	@PUT
	@Path("/transaction/{id}")
	@Produces({ MediaType.APPLICATION_JSON})
	@Consumes({ MediaType.APPLICATION_JSON})
	public Response addTran(@PathParam("id") Long id,String requestBody) {

		JSONObject body = 	new JSONObject(requestBody);				
		double amount = body.getDouble("amount");
		String type = body.get("type").toString();
		Long parent=null;
		boolean isParent = body.has("parent_id");
		//Long parent = isParent?Long.valueOf(body.get("parent_id").toString()):null;
		if(isParent) {
			Object o = body.get("parent_id");
			if(o instanceof Long) 
				parent = body.getLong("parent_id");
			else if (o instanceof Integer) 
				parent = Long.valueOf(body.getInt("parent_id"));
		}
		//		
		//		System.out.println(id);
		//    	System.out.println(amount);
		//    	System.out.println(type);
		//    	System.out.println(parent);
		//		


		try {
			//			if(parent==null) AppDAO.addEntry(id, amount, type);
			//			else AppDAO.addEntry(id, amount, type, parent);

			AppDAO.addEntry(id, amount, type, parent);
		}
		catch(TransactionException e) {
			return Response.status(Status.FORBIDDEN).entity(RESPONSE_FAILURE).build();}

		return Response.status(Status.ACCEPTED).entity(RESPONSE_SUCCESS).build();
	}

	@GET
	@Path("/transaction/{id}")
	@Produces({ MediaType.APPLICATION_JSON})
	public Transaction getSingleTran(@PathParam("id") Long id) {
		return AppDAO.getEntry(id);		
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON})
	public List<Transaction> getAllTran() {
		return AppDAO.getAllEntries();

	}

	@GET
	@Path("/types/{type}")
	@Produces({ MediaType.APPLICATION_JSON})
	public String getIdFromType(@PathParam("type") String type) {
		return AppDAO.getTypeId(type).toString();

	}

	@GET
	@Path("/sum/{id}")
	@Produces({ MediaType.APPLICATION_JSON})
	public String getTranSum(@PathParam("id") Long id) {

		//		Sum sum = new Sum();
		//		sum.setSum(AppDAO.getSum(id));
		//		return sum;
		if(!AppDAO.isTransactionPresent(id))
			return RESPONSE_FAILURE;

		double sum = AppDAO.getSum(id);
		//		String sum_toString = String.format("%1$,.2f",sum);
		//		
		//		
		//		JSONObject response = new JSONObject();
		//		
		//	    response.put("sum", decimalFormat.format(sum));
		//		System.out.println(response.toString());
		//			return response.toString();
		return "{\"sum\":"+decimalFormat.format(sum)+"}";

	}

	@DELETE
	@Path("/transaction/{id}")
	@Produces({ MediaType.APPLICATION_JSON})
	public String deleteEntry (@PathParam("id") Long id) {

		AppDAO.deleteEntry(id);		
		return RESPONSE_SUCCESS;
	}


}
