package com.ty.hospital_app.hospitalboot_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital_app.hospitalboot_app.dto.Encounter;

public interface EncounterRepository extends JpaRepository<Encounter, Integer> {

}
