package com.dapamail.mailbatch.lecture.dao.mybatis;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dapamail.mailbatch.lecture.dao.MovieDao;
import com.dapamail.mailbatch.lecture.entity.Movie;

@SpringBootTest
class MybatisMovieDaoImplTest {
	
	@Autowired
	private MovieDao movieDao;

	@Test
	void test() {
//		fail("Not yet implemented");
		List<Movie> list = movieDao.getList();
		
		for (Movie movie : list) {
			System.out.println("moive " + movie);
		}
	}

}
