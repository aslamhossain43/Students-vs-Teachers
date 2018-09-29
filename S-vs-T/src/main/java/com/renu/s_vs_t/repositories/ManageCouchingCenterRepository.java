package com.renu.s_vs_t.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.renu.s_vs_t.models.ManageCouchingCenter;

public interface ManageCouchingCenterRepository extends JpaRepository<ManageCouchingCenter, Long>,JpaSpecificationExecutor<ManageCouchingCenter> {
	
	//find by id
	public ManageCouchingCenter getById(Long id);
	
	//find by jobType
		public static final String category="FROM ManageCouchingCenter where jobType=:jobType";
	        	@Query(category)
	        List<ManageCouchingCenter> findByJobType(@Param("jobType")String jobType);
}
