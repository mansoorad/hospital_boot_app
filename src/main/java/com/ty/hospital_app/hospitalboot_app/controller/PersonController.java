package com.ty.hospital_app.hospitalboot_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital_app.hospitalboot_app.dto.Person;
import com.ty.hospital_app.hospitalboot_app.service.PersonService;
import com.ty.hospital_app.hospitalboot_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("person")
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@ApiOperation(value = "SavePerson", notes = "It is used to save person")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found")})
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person){
		return personService.savePerson(person);
	}
	
	@ApiOperation(value = "UpdatePerson", notes = "It is to update Person")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Updated"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found")}) 
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	produces = {MediaType.APPLICATION_JSON_VALUE})
	public  ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestBody Person person,@RequestParam int id){
		return personService.updatePerson(person, id);
	}
	
	@ApiOperation(value  = "GetPerson", notes = "It is user to get Person")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Recieved"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not Found")})
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<Person>> getPersonById(@RequestParam int id){
		return personService.getPersonById(id);
	}
	
	@ApiOperation(value = "DeletePerson", notes = "It is used to delete Person")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Deleted"),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "Not Found")})
	@DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<String>> deletePersonById(@RequestParam int id){
		return personService.deletePersonById(id);
	}
	
	
}
