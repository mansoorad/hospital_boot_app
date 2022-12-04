package com.ty.hospital_app.hospitalboot_app.controller;

import javax.validation.Valid;

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

import com.ty.hospital_app.hospitalboot_app.dto.Hospital;
import com.ty.hospital_app.hospitalboot_app.service.HospitalService;
import com.ty.hospital_app.hospitalboot_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("hospital")
public class HospitalController {

	@Autowired
	private HospitalService service;
	
	@ApiOperation(value = "Save Hospital", notes = "It is used to save Hospital")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},produces = 
	MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody @Valid Hospital hospital) {
		return service.saveHospital(hospital);
	}

	@ApiOperation(value = "Get Hospital", notes = "It is used to get the Hospital")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},produces = 
			MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(@RequestParam int id) {
		return service.getHospitalById(id);
	}

	@ApiOperation(value = "Update Hospital", notes = "It is used to Update the Hospital")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},produces = 
			MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Hospital>> updateHospitalById(@RequestBody Hospital hospital, @RequestParam int id) {
		return service.updateHospital(hospital, id);
	}

	@ApiOperation(value = "Delete Hospital", notes = "It is used to delete Hospital")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},produces = 
			MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<String>> deleteHospitalById(@RequestParam int id) {
		return service.deleteHospital(id);
	}
}
