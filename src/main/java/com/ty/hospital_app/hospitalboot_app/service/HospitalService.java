package com.ty.hospital_app.hospitalboot_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_app.hospitalboot_app.dao.HospitalDao;
import com.ty.hospital_app.hospitalboot_app.dto.Hospital;
import com.ty.hospital_app.hospitalboot_app.exception.NoSuchIdFoundException;
import com.ty.hospital_app.hospitalboot_app.util.ResponseStructure;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao dao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
		ResponseEntity<ResponseStructure<Hospital>> responseEntity =new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveHospital(hospital));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<String>> deleteHospital(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity =new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deleteHospitalById(id));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(Hospital hospital, int id) {
		Hospital hospital2 = dao.getHospitalById(id);
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
		ResponseEntity<ResponseStructure<Hospital>> responseEntity =new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		if (hospital2 != null) {
			hospital.setHospitalId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(dao.updateHospital(hospital));

		} 
		else {
			throw new NoSuchIdFoundException("No Id Found To Update");
		}
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id) {
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
		ResponseEntity<ResponseStructure<Hospital>> responseEntity =new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		Hospital user2 = dao.getHospitalById(id);
		if (user2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Received");
			responseStructure.setData(dao.getHospitalById(id));
		} else {
			throw new NoSuchIdFoundException("No Id Found In Data Base For hospital");
		}
		return responseEntity;
	}
}
