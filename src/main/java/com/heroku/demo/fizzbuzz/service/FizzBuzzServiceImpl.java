package com.heroku.demo.fizzbuzz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.heroku.demo.fizzbuzz.bean.FizzBuzz;

@Repository
public class FizzBuzzServiceImpl implements FizzBuzzService {
	FizzBuzz fizzBuzz = new FizzBuzz("Fizz","Buzz","FizzBuzz");
    public FizzBuzz getFizzBuzzObj(){
    	return fizzBuzz;
    }
	@Override
	public String getResult(int number) {
		return (number%15 == 0)? fizzBuzz.getFizzbuzz() : ((number%5 == 0)? fizzBuzz.getBuzz() : ((number%3 == 0)? fizzBuzz.getFizz() : number+""));
	}
	@Override
	public List<String> getResults(int[] numbers) {
		if(numbers == null || numbers.length == 0){
			return new ArrayList<String>();
		}
		List<String> resultList = new ArrayList<String>();
		for(Integer number : numbers){
			resultList.add(getResult(number));
		}
		return resultList;
	}
}
