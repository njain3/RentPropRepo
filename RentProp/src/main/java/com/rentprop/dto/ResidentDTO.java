package com.rentprop.dto;

import java.io.Serializable; 

public class ResidentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int resident_id;
	private String first_name;
	private String last_name;
	private String email_id;
	private Long phone_no;
	private String address;
	private String user_id;
	private String password;
	private String user_type;
	private LoginDTO loginDto;
	private ApartmentDTO apartmentDTO;
	
	/**
	 * 
	 */
	public ResidentDTO() {
		super();
	}
	
	/**
	 * @param resident_id
	 * @param first_name
	 * @param user_type
	 */
	public ResidentDTO(int resident_id, String first_name, String user_type) {
		super();
		this.resident_id = resident_id;
		this.first_name = first_name;
		this.user_type = user_type;
	}



	/**
	 * @return the apartmentDTO
	 */
	public ApartmentDTO getApartmentDTO() {
		return apartmentDTO;
	}


	/**
	 * @param apartmentDTO the apartmentDTO to set
	 */
	public void setApartmentDTO(ApartmentDTO apartmentDTO) {
		this.apartmentDTO = apartmentDTO;
	}


	/**
	 * @return the resident_id
	 */
	public int getResident_id() {
		return resident_id;
	}
	/**
	 * @param resident_id the resident_id to set
	 */
	public void setResident_id(int resident_id) {
		this.resident_id = resident_id;
	}
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * @return the email_id
	 */
	public String getEmail_id() {
		return email_id;
	}
	/**
	 * @param email_id the email_id to set
	 */
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	/**
	 * @return the phone_no
	 */
	public Long getPhone_no() {
		return phone_no;
	}
	/**
	 * @param phone_no the phone_no to set
	 */
	public void setPhone_no(Long phone_no) {
		this.phone_no = phone_no;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	/**
	 * @return the loginDto
	 */
	public LoginDTO getLoginDto() {
		return loginDto;
	}
	/**
	 * @param loginDto the loginDto to set
	 */
	public void setLoginDto(LoginDTO loginDto) {
		this.loginDto = loginDto;
	}
}
