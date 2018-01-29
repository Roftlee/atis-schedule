package com.yd.atis.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AtisScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtisScheduleApplication.class, args);
	}
}
