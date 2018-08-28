package com.github.demo.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 用户对象
 */
public class UserDto implements Serializable {
    private static final long serialVersionUID = -9077975168976887742L;

    private String username;
    private char[] password;
    private String encryptPwd;
    private Long userId;
    private String salt;
    private List<String> roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getEncryptPwd() {
		return encryptPwd;
	}

	public void setEncryptPwd(String encryptPwd) {
		this.encryptPwd = encryptPwd;
	}

}
