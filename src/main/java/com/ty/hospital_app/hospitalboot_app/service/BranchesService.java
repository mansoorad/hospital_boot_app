package com.ty.hospital_app.hospitalboot_app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_app.hospitalboot_app.dao.BranchesDao;
import com.ty.hospital_app.hospitalboot_app.dto.Branches;
import com.ty.hospital_app.hospitalboot_app.exception.NoSuchIdFoundException;
import com.ty.hospital_app.hospitalboot_app.util.ResponseStructure;
@Service
public class BranchesService {

	@Autowired
	private BranchesDao dao;

	public ResponseEntity<ResponseStructure<Branches>> saveBranches(Branches branches) {
		ResponseStructure<Branches> responseStructure = new ResponseStructure<Branches>();
		ResponseEntity<ResponseStructure<Branches>> responseEntity =new ResponseEntity<ResponseStructure<Branches>>(responseStructure,HttpStatus.CREATED);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveBranches(branches));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<String>> deleteBranches(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity =new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deleteBranchesById(id));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Branches>> updateBranches(Branches branches, int id) {
		Branches branches2 = dao.getBranchesById(id);
		ResponseStructure<Branches> responseStructure = new ResponseStructure<Branches>();
		ResponseEntity<ResponseStructure<Branches>> responseEntity =new ResponseEntity<ResponseStructure<Branches>>(responseStructure,HttpStatus.OK);
		if (branches2 != null) {
			branches.setBranchId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(dao.updateBranches(branches));

		} 
		else {
			throw new NoSuchIdFoundException("No Id Found To Update");
		}
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Branches>> getBranchesById(int id) {
		ResponseStructure<Branches> responseStructure = new ResponseStructure<Branches>();
		ResponseEntity<ResponseStructure<Branches>> responseEntity =new ResponseEntity<ResponseStructure<Branches>>(responseStructure,HttpStatus.OK);
		Branches user2 = dao.getBranchesById(id);
		if (user2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Received");
			responseStructure.setData(dao.getBranchesById(id));
		} else {
			throw new NoSuchIdFoundException("No Id Found In Data Base For Branches");
		}
		return responseEntity;
	}
}
