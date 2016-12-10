package com.cg.mycampus.Bean;

public class Transaction {
	
	private long id;
	
	private long employeeid;
	
	private long vendorid;
	
	private double amount;
	
	private String items;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(long employeeid) {
		this.employeeid = employeeid;
	}

	public long getVendorid() {
		return vendorid;
	}

	public void setVendorid(long vendorid) {
		this.vendorid = vendorid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

}
