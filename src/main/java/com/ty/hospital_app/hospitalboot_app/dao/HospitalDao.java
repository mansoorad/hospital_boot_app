package com.ty.hospital_app.hospitalboot_app.dao;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.hospital_app.hospitalboot_app.dto.Hospital;
import com.ty.hospital_app.hospitalboot_app.repository.HospitalRepository;
@Repository
public class HospitalDao {

	@Autowired
	private HospitalRepository repository ;
	
	public Hospital saveHospital(Hospital hospital ) {
		return repository.save(hospital);
	}
	
	public Hospital updateHospital(Hospital hospital ) {
		return repository.save(hospital);
	}
	
	public Hospital getHospitalById(int id) {
		Optional<Hospital> optional =repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public String deleteHospitalById(int id) {
		repository.deleteById(id);
		return "Deleted";
	}
}

