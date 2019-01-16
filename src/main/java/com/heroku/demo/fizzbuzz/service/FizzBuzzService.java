package com.heroku.demo.fizzbuzz.service;

import org.springframework.stereotype.Service;

import com.heroku.demo.fizzbuzz.bean.FizzBuzz;

@Service
public interface FizzBuzzService {
    public FizzBuzz getFizzBuzzObj();
}
