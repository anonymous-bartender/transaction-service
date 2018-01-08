package com.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.resource.Transaction;

public class AppDAO {

	private static final Map<Long, Transaction> transactionMap = new HashMap<Long, Transaction>();
	private static final Map<Long, Long> parentMap = new HashMap<Long, Long>();


	public static void addEntry(Long id, double money, String type, Long parent) throws TransactionException {


		if(id<1L) throw new TransactionException("Invalid datatype");
		if(type.isEmpty()) throw new TransactionException("Invalid datatype");
		if(money<=0.0)  throw new TransactionException("Invalid datatype");
		if(parent!=null && parent<1L)  throw new TransactionException("Invalid datatype");

		if(parent==null) parent = -999L;
		
		if(transactionMap.containsKey(id)) updateEntry(id, money, type, parent);
		else {
			Transaction t = new Transaction(id, money, type, parent);
			transactionMap.put(id, t);
			parentMap.put(id, parent);
		}

	}

	//   public static void addEntry(Long id, double money, String type) throws TransactionException {
	//	   
	//   	if(id<1L) throw new TransactionException("Invalid datatype");
	//   	//if(type.isEmpty()) throw new TransactionException("Invalid datatype");
	//   	if(money<=0.0d)  throw new TransactionException("Invalid datatype");
	//   	
	//    	Transaction t = new Transaction(id, money, type, -999L);
	//    	transactionMap.put(t.getTranID(), t);
	//    	
	//    }

	public static double getSum(Long id) {

		double sum = 0.0;
		
		Long parent = transactionMap.get(id).getParentID();
			
		if(parent != -999) {
			Collection<Transaction> c = transactionMap.values();
			for(Transaction t:c) {
				if(t.getParentID().equals(parent) || t.getTranID().equals(parent)
				|| (t.getParentID().equals(parent) && !t.getTranID().equals(parent)) )
				sum += t.getAmount();
			}
		}
		else 
			sum = transactionMap.get(id).getAmount();

		return sum;

	}

	public static List<Long> getTypeId(String type) {
		Collection<Transaction> c = transactionMap.values();
		List<Long> tid = new ArrayList<Long>();
		for(Transaction x:c) {
			if(x.getType().equals(type)) tid.add(x.getTranID());
		}
		return tid;       
	}

	public static void deleteEntry(Long id) {

		transactionMap.remove(id);

	}

	public static void updateEntry(Long id, double money, String type, Long parent) throws TransactionException {


		Transaction t = transactionMap.get(id);
		t.setType(type);
		t.setAmount(money);
		t.setParentID(parent);

	}

	public static boolean isTransactionPresent(Long id) {
		if(transactionMap.containsKey(id))
			return true;
		return false;
	}

	public static Transaction getEntry(Long id) {
		return transactionMap.get(id);
	
	}

	public static List<Transaction> getAllEntries() {
		Collection<Transaction> c = transactionMap.values();
		List<Transaction> list = new ArrayList<Transaction>();
		list.addAll(c);
		return list;
	}



}

