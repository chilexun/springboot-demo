package com.github.demo.controller;

import java.util.concurrent.Callable;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.demo.dto.UserDto;

@RestController
public class AsyncRequestController {

	@GetMapping("/async")
	public Callable<UserDto> doAsync(){
		return ()->{
			Thread.sleep(5000);
			return (UserDto)SecurityUtils.getSubject().getPrincipal();
		};
	}
}
