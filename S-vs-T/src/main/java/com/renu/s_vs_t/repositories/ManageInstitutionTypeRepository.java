package com.renu.s_vs_t.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.renu.s_vs_t.models.ManageInstitutionType;

public interface ManageInstitutionTypeRepository extends JpaRepository<ManageInstitutionType, Long>,JpaSpecificationExecutor<ManageInstitutionType>{

}
