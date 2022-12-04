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

import com.ty.hospital_app.hospitalboot_app.dto.Encounter;
import com.ty.hospital_app.hospitalboot_app.service.EncounterService;
import com.ty.hospital_app.hospitalboot_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("encounter")
public class EncounterController {
	@Autowired
	private EncounterService encounterService;
	
	@ApiOperation(value = "SaveEncounter", notes = "It is used to save Encounter")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "Not Found")})
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
	produces = {MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@RequestBody Encounter encounter){
		return encounterService.saveEncounter(encounter);
	}
	
	@ApiOperation(value = "UpdateEncounter", notes = "it is used to update Encounter")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Updated"),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "Not Found")})
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
	produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@RequestBody Encounter encounter, @RequestParam int id){
		return encounterService.updateEncounter(encounter, id);
	}
	
	@ApiOperation(value = "GetEncounter", notes = "It is used to getEncounter")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Recieved"),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "Not Found")})
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterbyId(@RequestBody int id){
		return encounterService.getEncounterById(id);
	}
	
	@ApiOperation(value = "DeleteEncounter", notes = "It is user to Delete Encounter")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Deleted"),
			@ApiResponse(code = 500, message = "Internal server error"),
			@ApiResponse(code = 404, message = "Not Found")})
	@DeleteMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<String>> deleteEncounterById(@RequestBody int id){
		return encounterService.deleteEncounterById(id);
	}
}
