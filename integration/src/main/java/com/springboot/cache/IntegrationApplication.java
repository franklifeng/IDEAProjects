package com.springboot.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@MapperScan("com.springboot.cache.mapper")
@EnableCaching
@SpringBootApplication
public class IntegrationApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(IntegrationApplication.class, args);
	}

}
