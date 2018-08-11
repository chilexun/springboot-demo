package com.github.springboot.demo;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RedisService {
	
	private StringRedisTemplate template;
	
	public RedisService(StringRedisTemplate template) {
		this.template = template;
	}

	@Transactional
	public String put() {
		int i = (int)(Math.random() * 100);
		template.opsForValue().set("key"+i, "value"+i, 300, TimeUnit.SECONDS);
		return "success "+"key"+i;
	}
}
