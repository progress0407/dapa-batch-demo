package com.dapamail.mailbatch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dapamail.mailbatch.lecture.dao.mybatis.MybatisMovieDaoImpl;
import com.dapamail.mailbatch.lecture.entity.Movie;

@RestController
public class SampleTestController {
	
	@Autowired
	MybatisMovieDaoImpl dao;
	
	@GetMapping("/foo")
	public List<Movie> foo() {
		return dao.getList();
	}

}
