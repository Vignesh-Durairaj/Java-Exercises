package com.vikhi.pojo;

public class NumberModel {

	private int a;
	
	private int b;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	@Override
	public String toString() {
		return "The values are a : " + this.a + " and b : " + this.b;
	}
}
