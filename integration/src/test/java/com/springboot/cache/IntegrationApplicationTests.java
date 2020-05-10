package com.springboot.cache;

import com.springboot.cache.bean.Employee;
import com.springboot.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisTemplate redisTemplate;

	@Autowired
	RedisTemplate<Object, Employee> empRedisTemplate;


	@Test
	public void test(){
		stringRedisTemplate.opsForValue().append("frank","fddsf");
		System.out.println(stringRedisTemplate.opsForValue().get("frank"));

	}

	@Test
	public void test01(){
		Employee emp = employeeMapper.getEmployee(1);
		redisTemplate.opsForValue().set("emp-01",emp);
	}

	@Test
	public void test02(){
		Employee emp = employeeMapper.getEmployee(1);
		empRedisTemplate.opsForValue().set("emp-02",emp);
	}

	@Test
	public void contextLoads() {
		Employee emp = employeeMapper.getEmployee(1);
		System.out.println(emp);
	}

}
