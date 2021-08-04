package com.dapamail.mailbatch.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestJobMethode {
	
	public void justPrintLog() {
		log.info("____________MyTestJobMethod_________");
	}
}
