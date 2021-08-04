package com.dapamail.mailbatch.lecture.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.dapamail.mailbatch.lecture.entity.Movie;

@Mapper
public interface MovieDao {
	
	@Select("select * from movie")
	List<Movie> getList();
	
}
