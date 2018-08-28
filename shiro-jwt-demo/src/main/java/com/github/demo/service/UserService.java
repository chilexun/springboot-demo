package com.github.demo.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.github.demo.configuration.JwtUtils;
import com.github.demo.dto.UserDto;

/**
 * 用户信息接口
 */
@Service
public class UserService {

	@Autowired
	private StringRedisTemplate redisTemplate;
   
    /**
     * 保存user登录信息，返回token
     * @param userDto
     */
    public String generateJwtToken(String username) {
    	String salt = JwtUtils.generateSalt();
    	/**
    	 * @todo 将salt保存到数据库或者缓存中
    	 * redisTemplate.opsForValue().set("token:"+username, salt, 3600, TimeUnit.SECONDS);
    	 */   	
    	return JwtUtils.sign(username, salt, 3600); //生成jwt token，设置过期时间为1小时
    }
    
    /**
     * 获取上次token生成时的salt值和登录用户信息
     * @param username
     * @return
     */
    public UserDto getJwtTokenInfo(String username) {
    	String salt = null;
    	/**
    	 * @todo 从数据库或者缓存中取出jwt token生成时用的salt
    	 * salt = redisTemplate.opsForValue().get("token:"+username);
    	 */   	
    	UserDto user = getUserInfo(username);
    	user.setSalt(salt);
    	return user;
    }

    /**
     * 清除token信息
     * @param userName 登录用户名
     * @param terminal 登录终端
     */
    public void deleteLoginInfo(String username) {
    	/**
    	 * @todo 删除数据库或者缓存中保存的salt
    	 * redisTemplate.delete("token:"+username);
    	 */
    	
    }
    
    /**
     * 获取数据库中保存的用户信息，主要是加密后的密码
     * @param userName
     * @return
     */
    public UserDto getUserInfo(String userName) {
    	return null;
    }
    
    /**
     * 获取用户角色列表，强烈建议从缓存中获取
     * @param userId
     * @return
     */
    public List<String> getUserRoles(Long userId){
    	return null;
    }

}
