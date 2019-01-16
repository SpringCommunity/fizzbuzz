package com.heroku.demo.fizzbuzz.service;

import org.springframework.stereotype.Repository;

import com.heroku.demo.fizzbuzz.bean.FizzBuzz;

@Repository
public class FizzBuzzServiceImpl implements FizzBuzzService {
	FizzBuzz fizzBuzz = new FizzBuzz("Fizz","Buzz","FizzBuzz");
    public FizzBuzz getFizzBuzzObj(){
    	return fizzBuzz;
    }
}
