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
public class ManageTutor extends BaseManageTutor<Long> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String iCode;
	@Transient
	private MultipartFile iFile;
	@NotBlank(message = "Choose your institution type")
	private String institutionType;
	@NotBlank(message = "Choose your institution")
	private String institution;
	@NotBlank(message = "Enter your department")
	private String department;
	@NotBlank(message = "Enter your recent year")
	private String year;
	@NotBlank(message = "Enter your provided courses")
	private String courses;
	@NotBlank(message = "Enter your contact/email")
	private String contact;
	@NotBlank(message = "Enter yes or no")
	private String experience;
	@NotBlank(message = "Enter your home district")
	private String homeDistrict;
	@NotBlank(message = "Enter your full name")
	private String fullName;
	@NotBlank(message="Enter a word which you added during registration")
	private String word;

	public ManageTutor() {
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

	public String getInstitutionType() {
		return institutionType;
	}

	public void setInstitutionType(String institutionType) {
		this.institutionType = institutionType;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getHomeDistrict() {
		return homeDistrict;
	}

	public void setHomeDistrict(String homeDistrict) {
		this.homeDistrict = homeDistrict;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return "ManageTutor [id=" + id + ", iCode=" + iCode + ", institutionType=" + institutionType + ", institution="
				+ institution + ", department=" + department + ", year=" + year + ", courses=" + courses + ", contact="
				+ contact + ", experience=" + experience + ", homeDistrict=" + homeDistrict + ", fullName=" + fullName
				+ ", word=" + word + "]";
	}
	
	
	
	
	

}
