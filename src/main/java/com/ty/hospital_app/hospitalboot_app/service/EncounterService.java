package com.ty.hospital_app.hospitalboot_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_app.hospitalboot_app.dao.EncounterDao;
import com.ty.hospital_app.hospitalboot_app.dto.Encounter;
import com.ty.hospital_app.hospitalboot_app.exception.NoSuchIdFoundException;
import com.ty.hospital_app.hospitalboot_app.util.ResponseStructure;

@Service
public class EncounterService {
	@Autowired
	private EncounterDao encounterDao;
	
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter){
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
		ResponseEntity<ResponseStructure<Encounter>> responseEntity = new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(encounterDao.saveEncounter(encounter));
		return responseEntity;
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(Encounter encounter, int id){
		Encounter encounter2 =  encounterDao.getEncounterById(id);
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
		ResponseEntity<ResponseStructure<Encounter>> responseEntity = new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		if(encounter2!=null) {
			encounter.setEncounterId(id);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Updated");
		responseStructure.setData(encounterDao.updateEncounter(encounter));
		}else {
			throw new NoSuchIdFoundException();
		}
		return responseEntity;
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(int id){
		Encounter encounter =  encounterDao.getEncounterById(id);
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
		ResponseEntity<ResponseStructure<Encounter>> responseEntity = new ResponseEntity<ResponseStructure<Encounter>>(responseStructure, HttpStatus.OK);
		if(encounter!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Recieved");
			responseStructure.setData(encounterDao.getEncounterById(id));
		}else {
			throw new NoSuchIdFoundException();
		}
		return responseEntity;
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteEncounterById(int id){
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(encounterDao.deleteEncounterById(id));
		return responseEntity;
	}
	
}
