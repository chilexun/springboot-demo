package com.github.springboot.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

//@Service
public class RedisRunner implements CommandLineRunner{
	private final StringRedisTemplate template;
	
	public RedisRunner(StringRedisTemplate template) {
		this.template = template;
	}


	@Override
	public void run(String... args) throws Exception {
		for(int i=0; i<10; i++) {
			template.opsForValue().set("key"+i, "value"+i, 300);
			System.out.println("==========Set value"+i+" to redis==========");
		}
		System.out.println("finish");
	}

}
