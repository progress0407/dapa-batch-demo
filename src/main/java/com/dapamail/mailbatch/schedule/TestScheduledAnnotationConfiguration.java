package com.dapamail.mailbatch.schedule;

import javax.annotation.PostConstruct;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.dapamail.mailbatch.lecture.Lec2_SimpleJobConfiguration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
/*
private final Job job;  // tutorialJob
private final JobLauncher jobLauncher;

// 5초마다 실행
@Scheduled(fixedDelay = 5 * 1000L)
public void executeJob () {
    try {
        jobLauncher.run(
                job,
                new JobParametersBuilder()
                        .addString("datetime", LocalDateTime.now().toString())
                .toJobParameters()  // job parameter 설정
        );
    } catch (JobExecutionException ex) {
        System.out.println(ex.getMessage());
        ex.printStackTrace();
    }
}
*/

@RequiredArgsConstructor
@Slf4j
//@EnableScheduling
//@Configuration
public class TestScheduledAnnotationConfiguration {
	
	@Autowired
	private final TestJobMethode testJobMethode;
	
	@Autowired
	private final JobLauncher jobLauncher;
	
	@Autowired
	private final Lec2_SimpleJobConfiguration lec2_SimpleJobConfiguration;
	
	private Job job;
	
	@PostConstruct
	public void init() { // 해당 객체 생성 후 초기화됨, DI 이후 job에 할당하기 위해서임
		log.info("TestScheduledAnnotationConfiguration()");
		log.info("lec2_SimpleJobConfiguration: " + lec2_SimpleJobConfiguration);
		
		job = lec2_SimpleJobConfiguration.simpleJob();
	}

	@Scheduled(fixedRateString = "1000", initialDelayString = "2000")
	public void invokeMethodScheduled() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		log.info("___________ TestScheduledAnnotationConfiguration > invokeMethodScheduled");
//		testJobMethode.justPrintLog();
//		lec2_SimpleJobConfiguration.simpleJob();
		
		// jobParameters는 null이 될 수 없다 !  비어있는 인자라도 넣자 !
		jobLauncher.run(job, new JobParametersBuilder().toJobParameters());
	}
}
