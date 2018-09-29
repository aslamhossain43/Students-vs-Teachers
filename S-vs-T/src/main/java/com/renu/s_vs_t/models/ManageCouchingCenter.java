package com.renu.s_vs_t.models;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;
@Entity
public class ManageCouchingCenter extends BaseManageCouchingCenter<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String iCode;
	@Transient
	private MultipartFile iFile;
	@NotBlank(message = "Enter your couching name")
	private String couchingName;
	@NotBlank(message = "Enter district name")
	private String districtName;
	@NotBlank(message = "Choose a job type")
	private String jobType;
	@NotBlank(message = "Enter teacher's institutionDepartment")
	private String institutionDepartment;
	@NotBlank(message = "Enter teaching classes")
	private String classes;
	@NotBlank(message = "Enter couching's address")
	private String address;

	@NotBlank(message = "Enter your contact number")
	private String contact;
	
	@NotBlank(message="Enter a word which you added during registration")
	private String word;

	
	
	public ManageCouchingCenter() {
		this.iCode = "I" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}



	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}



	public String getiCode() {
		return iCode;
	}



	public void setiCode(String iCode) {
		this.iCode = iCode;
	}



	public MultipartFile getiFile() {
		return iFile;
	}



	public void setiFile(MultipartFile iFile) {
		this.iFile = iFile;
	}



	public String getCouchingName() {
		return couchingName;
	}



	public void setCouchingName(String couchingName) {
		this.couchingName = couchingName;
	}



	public String getDistrictName() {
		return districtName;
	}



	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}



	public String getJobType() {
		return jobType;
	}



	public void setJobType(String jobType) {
		this.jobType = jobType;
	}



	public String getInstitutionDepartment() {
		return institutionDepartment;
	}



	public void setInstitutionDepartment(String institutionDepartment) {
		this.institutionDepartment = institutionDepartment;
	}



	public String getClasses() {
		return classes;
	}



	public void setClasses(String classes) {
		this.classes = classes;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	public String getWord() {
		return word;
	}



	public void setWord(String word) {
		this.word = word;
	}



	public void setId(Long id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "ManageCouchingCenter [id=" + id + ", iCode=" + iCode + ", couchingName=" + couchingName
				+ ", districtName=" + districtName + ", jobType=" + jobType + ", institutionDepartment="
				+ institutionDepartment + ", classes=" + classes + ", address=" + address + ", contact=" + contact
				+ ", word=" + word + "]";
	}
	
	
	
	

}
