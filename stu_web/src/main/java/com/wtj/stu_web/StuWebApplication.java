package com.wtj.stu_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.wtj")
public class StuWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(StuWebApplication.class, args);
	}

}
