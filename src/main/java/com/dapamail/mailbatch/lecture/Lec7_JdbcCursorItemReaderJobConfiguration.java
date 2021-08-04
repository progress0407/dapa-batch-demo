package com.dapamail.mailbatch.lecture;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.dapamail.mailbatch.lecture.dao.MovieDao;
import com.dapamail.mailbatch.lecture.entity.Movie;
import com.dapamail.mailbatch.lecture.entity.Pay;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class Lec7_JdbcCursorItemReaderJobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final DataSource dataSource; // DataSource DI

    private final MovieDao movieDao;
    
    private static final int chunkSize = 10;

    @Bean
    public Job jdbcCursorItemReaderJob() {
    	log.info("!!!!!!!!! dataSource {}", dataSource);
    	log.info("________________ Lec7_JdbcCursorItemReaderJobConfiguration > jdbcCursorItemReaderJob ___________________");
        return jobBuilderFactory.get("jdbcCursorItemReaderJob")
                .start(jdbcCursorItemReaderStep())
                .build();
    }

    @Bean
    public Step jdbcCursorItemReaderStep() {
    	log.info("________________ Lec7 jdbcCursorItemReaderStep ___________________");
        return stepBuilderFactory.get("jdbcCursorItemReaderStep")
                .<Pay, Pay>chunk(chunkSize)
                .reader(jdbcCursorItemReader())
                .writer(jdbcCursorItemWriter())
                .build();
    }

    @Bean
    public JdbcCursorItemReader<Pay> jdbcCursorItemReader() {
    	log.info("________________ Lec7 jdbcCursorItemReader ___________________");
        return new JdbcCursorItemReaderBuilder<Pay>()
                .fetchSize(chunkSize)
                .dataSource(dataSource)
                .rowMapper(new BeanPropertyRowMapper<>(Pay.class))
                .sql("SELECT id, amount, tx_name, tx_date_time FROM pay")
                .name("jdbcCursorItemReader")
                .build();
    }

    private ItemWriter<Pay> jdbcCursorItemWriter() {
    	log.info("________________ Lec7 jdbcCursorItemWriter ___________________");
    	
    	log.info("movieDao = {}", movieDao.getList());
    	
    	for (Movie movie : movieDao.getList()) {
			System.out.println(movie);
		}
    	
        return list -> {
        	log.info("________________ Lec7 in return statement ___________________");
            for (Pay pay: list) {
                log.info("Current Pay={}", pay);
            }
        };
    }
}