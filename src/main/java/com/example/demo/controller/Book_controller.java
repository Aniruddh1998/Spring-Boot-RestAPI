package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.repo.Bookrepo;

@RestController
public class Book_controller {
	
	@Autowired
	Bookrepo repo;
	
	//=============Inserting Single data================//
	@PostMapping("/savebook")
	public String savebook(@RequestBody Book b) {
		repo.save(b);
		return "Book inserted successfully";
	}
	
	//=============Inserting Multiple data================//
	@PostMapping("/savemultiplebook")
	public String savebook(@RequestBody List<Book> b) {
		repo.saveAll(b);
		return "Multiple Book inserted successfully";
	}
	
	//================Get List of all Data================//
	@GetMapping("/getallbooks")
	public List<Book> getallbooks(){
		return (List<Book>) repo.findAll();
	}
	
	//============Get List of single data by id===========//
	@GetMapping("/getBookbyid/{id}")
	public Optional<Book> getbookbyid(@PathVariable("id") long bid){
		return repo.findById(bid);
	}
	
	//============Get List of single data by name===========//
	@GetMapping("/getBookbybname/{name}")
	public List<Book> getbookbybname(@PathVariable("name") String bname){
		return (List<Book>) repo.findBybname(bname);
	}

}
