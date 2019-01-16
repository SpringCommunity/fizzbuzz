package com.heroku.demo.fizzbuzz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.heroku.demo.fizzbuzz.bean.FizzBuzz;

@Service
public interface FizzBuzzService {
    public FizzBuzz getFizzBuzzObj();
    public String getResult(int number);
    public List<String> getResults(int[] numbers);
}
