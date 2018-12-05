package com.petshop.pojo;

public class User {
	private String name;
	private String account;
	private String password;
	private Integer id;
	
	public User() {}
	
	public User(String name, String account, String password) {
		this.name = name;
		this.account = account;
		this.password = password;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
