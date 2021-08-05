package com.dapamail.mailbatch.lecture.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dapamail.mailbatch.lecture.dao.MovieDao;
import com.dapamail.mailbatch.lecture.entity.Movie;

@Repository
public class MybatisMovieDaoImpl implements MovieDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public List<Movie> getList() {
		
		MovieDao movieDao = sqlSession.getMapper(MovieDao.class); // 이것에 해당하는 namespace를 가진 mapper 세션 요청
		
		return movieDao.getList();
	}
	
	
}
