package com.yxr.tools;

public class Goods {
	private int number;
	private String name;
	private float price;
	private String putaway;
	private String reason;
	private String comebackornot;
	
	public String getComebackornot()
	{
		return this.comebackornot;
	}
	
	public void setComebackornot(String c)
	{
		this.comebackornot=c;
	}
	
	public String getReason()
	{
		return this.reason;
	}

	public void setReason(String r)
	{
		this.reason=r;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setPutaway(String putaway) {
		this.putaway = putaway;
	}

	public String getPutaway() {
		return putaway;
	}

}
