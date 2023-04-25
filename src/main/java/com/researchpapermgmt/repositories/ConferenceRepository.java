package com.researchpapermgmt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.researchpapermgmt.models.Conference;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {

}