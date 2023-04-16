package com.researchpapermgmt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.researchpapermgmt.models.Confadmin;


public interface ConfAdminRepository extends JpaRepository<Confadmin, Long>{
	List<Confadmin> findByName(String name);
}
