package com.renu.s_vs_t.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class ManageInstitutionType extends BaseManageInstitutionType<Long> {

	 @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	 @NotBlank(message="Enter an institution type")
	 private String institutionType;
	 public ManageInstitutionType() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getInstitutionType() {
		return institutionType;
	}
	public void setInstitutionType(String institutionType) {
		this.institutionType = institutionType;
	}
	
	 
	 
	 
}
