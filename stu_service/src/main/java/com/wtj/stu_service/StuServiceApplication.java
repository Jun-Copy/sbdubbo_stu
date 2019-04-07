package com.wtj.stu_service;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.wtj")
@MapperScan("com.wtj.mapper")
@DubboComponentScan("com.wtj.service.impl")
public class StuServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StuServiceApplication.class, args);
	}

}
