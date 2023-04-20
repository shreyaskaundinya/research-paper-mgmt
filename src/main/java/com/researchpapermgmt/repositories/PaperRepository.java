package com.researchpapermgmt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.researchpapermgmt.models.Paper;

public interface PaperRepository extends JpaRepository<Paper, Long> {
    List<Paper> findByKeywordsContaining(String keywords);
}
