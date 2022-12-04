package com.ty.hospital_app.hospitalboot_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_app.hospitalboot_app.dao.PersonDao;
import com.ty.hospital_app.hospitalboot_app.dto.Person;
import com.ty.hospital_app.hospitalboot_app.exception.NoSuchIdFoundException;
import com.ty.hospital_app.hospitalboot_app.util.ResponseStructure;

@Service
public class PersonService {
	@Autowired
	private PersonDao personDao;
	
	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person){
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		ResponseEntity<ResponseStructure<Person>> responseEntity = new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(personDao.savePerson(person));
		return responseEntity;
	}
	
	public ResponseEntity<ResponseStructure<Person>> updatePerson(Person person, int id){
		Person person2 = personDao.getPersonById(id);
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		ResponseEntity<ResponseStructure<Person>> responseEntity = new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.OK);
		if(person2!=null) {
			person.setPersonId(id);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Updated");
		responseStructure.setData(personDao.updatePerson(person));
		}else {
			throw new NoSuchIdFoundException();
		}
		return responseEntity;
	}
	
	public ResponseEntity<ResponseStructure<Person>> getPersonById(int id){
		Person person2 = personDao.getPersonById(id);
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		ResponseEntity<ResponseStructure<Person>> responseEntity = new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.OK);
		if(person2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Recived");
			responseStructure.setData(personDao.getPersonById(id));
		}else {
			throw new NoSuchIdFoundException();
		}
		return responseEntity;
	}
	
	public ResponseEntity<ResponseStructure<String>> deletePersonById(int id){
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(personDao.deletePersonById(id));
		return responseEntity;
	}
}
