package com.renu.s_vs_t.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class ManageJobType extends BaseManageJobType<Long> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "Enter a job type")
	private String jobType;
     @NotBlank(message="Enter a common name")
     private String commonName;
	public ManageJobType() {
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

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	
	
	
	
	

}
