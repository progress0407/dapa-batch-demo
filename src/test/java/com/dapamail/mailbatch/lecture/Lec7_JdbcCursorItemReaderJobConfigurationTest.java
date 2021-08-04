package com.dapamail.mailbatch.lecture;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.dapamail.mailbatch.lecture.dao.MovieDao;
import com.dapamail.mailbatch.lecture.entity.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@AutoConfigureTestDatabase(replace = Replace.NONE) // DB를 따로 마련하지 않겠다
@MybatisTest
class Lec7_JdbcCursorItemReaderJobConfigurationTest {
	
	@Autowired
	private MovieDao movieDao;

	@Test
	void test() {
//		fail("Not yet implemented");
		System.out.println("hello");
		System.out.println("dao: "+ movieDao);
		for (Movie movie : movieDao.getList()) {
			log.info("____{}____", movie.getTitle());
		}
	}

}
