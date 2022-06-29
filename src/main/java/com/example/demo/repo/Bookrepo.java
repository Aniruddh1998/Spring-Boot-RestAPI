package com.example.demo.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Book;

public interface Bookrepo extends JpaRepository<Book,Long>{
	
	//If method is not avalable in repo then you can crerate like this
	public List<Book> findBybname(String bname);
	
}