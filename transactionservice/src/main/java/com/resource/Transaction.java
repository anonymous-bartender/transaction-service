package com.resource;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;

@XmlRootElement(name = "transaction")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transaction implements Serializable{

	private static final long serialVersionUID = 1L;
    
	@XmlElement(name = "amount")
	private double amount;
	private Long tranID;
	private String type;
	private Long parentID;
	
	public Transaction() {
		
	}
	
	public Transaction (Long tranID, double amount, String type, Long parentID) {
		
		this.tranID = tranID;
		this.amount = amount;
		this.type = type;
		this.parentID = parentID;
		
	}
	
//	public Transaction (Long tranID, double amount, String type) {
//		
//		this.tranID = tranID;
//		this.amount = amount;
//		this.type = type;
//		this.parentID = -999.99;
//		
//	}
	
	public Long getTranID () {
		return tranID;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String getType() {
		return type;
	}
	
	public Long getParentID () {
		return parentID;
	}
	
	public void setTranID (Long tranID) {
		this.tranID = tranID;
		
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void setType(String type) {

		this.type = type;
	}
	
	public void setParentID (Long parentID) {

		this.parentID = parentID;
	}
	
}
