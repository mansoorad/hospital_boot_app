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

import com.ty.hospital_app.hospitalboot_app.dto.Branches;
import com.ty.hospital_app.hospitalboot_app.service.BranchesService;
import com.ty.hospital_app.hospitalboot_app.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("branches")
public class BranchesController {
	@Autowired
	private BranchesService service;
	
	@ApiOperation(value = "Save Branches", notes = "It is used to save Branches")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},produces = 
	MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Branches>> saveBranches(@RequestBody @Valid Branches branches) {
		return service.saveBranches(branches);
	}

	@ApiOperation(value = "Get Branches", notes = "It is used to get the Branches")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},produces = 
			MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Branches>> getBranchesById(@RequestParam int id) {
		return service.getBranchesById(id);
	}

	@ApiOperation(value = "Update Branches", notes = "It is used to Update the Branches")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},produces = 
			MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Branches>> updateBranchesById(@RequestBody Branches branches, @RequestParam int id) {
		return service.updateBranches(branches, id);
	}

	@ApiOperation(value = "Delete Branches", notes = "It is used to delete Branches")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Created"),
			@ApiResponse(code = 500,message = "Internal server Error"),
			@ApiResponse(code = 404,message = "Not found")})
	@DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE},produces = 
			MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<String>> deleteBranchesById(@RequestParam int id) {
		return service.deleteBranches(id);
	}
}
