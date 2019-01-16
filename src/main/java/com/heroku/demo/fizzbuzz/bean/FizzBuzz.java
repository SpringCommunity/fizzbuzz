package com.heroku.demo.fizzbuzz.bean;

public class FizzBuzz {
    private String fizz, buzz;

	public FizzBuzz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FizzBuzz(String fizz, String buzz) {
		super();
		this.fizz = fizz;
		this.buzz = buzz;
	}

	public String getFizz() {
		return fizz;
	}

	public void setFizz(String fizz) {
		this.fizz = fizz;
	}

	public String getBuzz() {
		return buzz;
	}

	public void setBuzz(String buzz) {
		this.buzz = buzz;
	}
    
}
