package com.ty.hospital_app.hospitalboot_app.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital_app.hospitalboot_app.dto.Encounter;
import com.ty.hospital_app.hospitalboot_app.repository.EncounterRepository;

@Repository
public class EncounterDao {
	@Autowired
	private EncounterRepository repository;
	
	public Encounter saveEncounter(Encounter encounter) {
		return repository.save(encounter);
	}
	
	public Encounter updateEncounter(Encounter encounter) {
		return repository.save(encounter);
	}
	
	public Encounter getEncounterById(int id) {
		Optional<Encounter> optional = repository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}else {
			return optional.get();
		}
	}
	
	public String deleteEncounterById(int id) {
		repository.deleteById(id);
		return "Deleted";
	}
}
