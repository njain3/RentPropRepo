package com.rentprop.dto;

import java.io.Serializable;

public class LoginDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int login_id;
	private String user_name;
	private String password;
	private String user_type;
	
	/**
	 * 
	 */
	public LoginDTO() {
		super();
	}

	/**
	 * @param login_id
	 * @param user_name
	 * @param password
	 * @param user_type
	 */
	public LoginDTO(int login_id, String user_name, String password, String user_type) {
		super();
		this.login_id = login_id;
		this.user_name = user_name;
		this.password = password;
		this.user_type = user_type;
	}

	/**
	 * @return the login_id
	 */
	public int getLogin_id() {
		return login_id;
	}

	/**
	 * @param login_id the login_id to set
	 */
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}

	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the user_type
	 */
	public String getUser_type() {
		return user_type;
	}

	/**
	 * @param user_type the user_type to set
	 */
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
}
