package com.researchpapermgmt.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.researchpapermgmt.models.Panelmember;


public interface PanelMemberRepository extends JpaRepository<Panelmember, Long>{
	List<Panelmember> findByName(String name);
}