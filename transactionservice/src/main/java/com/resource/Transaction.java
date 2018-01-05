package com.resource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "transaction")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transaction {

	private double amount;
	private long tranID;
	private String type;
	private long parentID;
	
	public Transaction() {
		
	}
	
	public Transaction (long tranID, double amount, String type, long parentID) {
		
		this.tranID = tranID;
		this.amount = amount;
		this.type = type;
		this.parentID = parentID;
		
	}
	
	public Transaction (long tranID, double amount, String type) {
		
		this.tranID = tranID;
		this.amount = amount;
		this.type = type;
		this.parentID = -999;
		
	}
	
	public long getTranID () {
		return tranID;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String getType() {
		return type;
	}
	
	public long getParentID () {
		return parentID;
	}
	
	public void setTranID (long tranID) {
		this.tranID = tranID;
		
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void setType(String type) {

		this.type = type;
	}
	
	public void setParentID (long parentID) {

		this.parentID = parentID;
	}
	
}
