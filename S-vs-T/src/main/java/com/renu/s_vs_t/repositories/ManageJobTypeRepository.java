package com.renu.s_vs_t.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.s_vs_t.models.ManageJobType;

public interface ManageJobTypeRepository extends JpaRepository<ManageJobType, Long>,JpaSpecificationExecutor<ManageJobType>{

}
