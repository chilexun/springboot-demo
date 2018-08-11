package com.github.springboot.demo;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	private StringRedisTemplate template;
	private RedisService redisService;
	
	public DemoController(StringRedisTemplate template,RedisService redisService) {
		this.template = template;
		this.redisService = redisService;
	}
	
	@GetMapping("/put")
	public String redisSet() {
		int i = (int)(Math.random() * 100);
		template.opsForValue().set("key"+i, "value"+i, 300, TimeUnit.SECONDS);
		return "success "+"key"+i;
	}
	
	@GetMapping("/puttx")
	public String redisTxSet() {
		return redisService.put();
	}

}
