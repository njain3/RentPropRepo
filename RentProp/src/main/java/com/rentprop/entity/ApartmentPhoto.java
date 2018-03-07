package com.rentprop.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the apartment_photo database table.
 * 
 */
@Entity
@Table(name="apartment_photo")
@NamedQuery(name="ApartmentPhoto.findAll", query="SELECT a FROM ApartmentPhoto a")
public class ApartmentPhoto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PHOTO_ID")
	private int photoId;

	@Column(name="APARTMENT_ID")
	private int apartmentId;

	@Column(name="ENCRYPTED_NAME")
	private String encryptedName;

	@Column(name="FILE_NAME")
	private String fileName;

	public ApartmentPhoto() {
	}

	public int getPhotoId() {
		return this.photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public int getApartmentId() {
		return this.apartmentId;
	}

	public void setApartmentId(int apartmentId) {
		this.apartmentId = apartmentId;
	}

	public String getEncryptedName() {
		return this.encryptedName;
	}

	public void setEncryptedName(String encryptedName) {
		this.encryptedName = encryptedName;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}