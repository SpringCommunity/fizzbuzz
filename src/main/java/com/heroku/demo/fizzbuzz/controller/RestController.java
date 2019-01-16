package com.heroku.demo.fizzbuzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heroku.demo.fizzbuzz.bean.FizzBuzz;
import com.heroku.demo.fizzbuzz.service.FizzBuzzService;

@Controller
public class RestController {
	@Autowired
	private FizzBuzzService FizzBuzzServiceImpl;
	
	@CrossOrigin(origins = "http://localhost:8080/")
	@GetMapping("/api")
	@ResponseBody
    public ResponseEntity<FizzBuzz> getFizzBuzzObj() {
		return new ResponseEntity<FizzBuzz>(FizzBuzzServiceImpl.getFizzBuzzObj(), HttpStatus.OK);
    }
}
