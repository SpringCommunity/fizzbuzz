package com.heroku.demo.fizzbuzz.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heroku.demo.fizzbuzz.bean.FizzBuzz;
import com.heroku.demo.fizzbuzz.service.FizzBuzzService;

@Controller
public class RestController {
	@Autowired
	private FizzBuzzService FizzBuzzServiceImpl;
	
	@CrossOrigin(origins = "https://fizzbuzz-game.herokuapp.com")
	@GetMapping("/api")
	@ResponseBody
    public ResponseEntity<FizzBuzz> getFizzBuzzObj() {
		return new ResponseEntity<FizzBuzz>(FizzBuzzServiceImpl.getFizzBuzzObj(), HttpStatus.OK);
    }
	
	@CrossOrigin(origins = "https://fizzbuzz-game.herokuapp.com")
	@GetMapping("/api/number/{number}")
	@ResponseBody
    public ResponseEntity<String> getResultForANumber(@PathVariable("number") String numberStr) {
		try {
			int number = Integer.parseInt(numberStr);
			return new ResponseEntity<String>(FizzBuzzServiceImpl.getResult(number), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("The input should be a number, please try again!", HttpStatus.BAD_REQUEST);
		}
    }
	
	@CrossOrigin(origins = "https://fizzbuzz-game.herokuapp.com")
	@GetMapping("/api/numbers/{numbers}")
	@ResponseBody
    public ResponseEntity<List<String>> getResultForNumbers(@PathVariable("numbers") String[] numbersStrArr) {
		try {
			int[] numbersArr = Arrays.stream(numbersStrArr).mapToInt(Integer::parseInt).toArray();
			return (numbersArr == null || numbersArr.length == 0)? new ResponseEntity<List<String>>(new ArrayList<String>(), HttpStatus.NO_CONTENT) : new ResponseEntity<List<String>>(FizzBuzzServiceImpl.getResults(numbersArr), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<String>>(Arrays.asList("The input should be an array of numbers, please try again!"), HttpStatus.BAD_REQUEST);
		}
    }
	
	
}
