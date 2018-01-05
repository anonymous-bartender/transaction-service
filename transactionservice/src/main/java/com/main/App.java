package com.main;


import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
public class App {
	
	@GET 									// localhost:8080/transactionservice/
	//@Consumes({ MediaType.APPLICATION_JSON})
	@Produces({ MediaType.APPLICATION_JSON})
	public String temp1() {
		return "{ \"MSG\" : \"OK\" }";
	}
	
	@GET									// localhost:8080/transactionservice/sublevel
	@Path("/sublevel")
	//@Consumes({ MediaType.APPLICATION_JSON})
	public String temp2() {
		return "temp2";
	}

}
