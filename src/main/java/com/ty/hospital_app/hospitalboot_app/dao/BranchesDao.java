package com.ty.hospital_app.hospitalboot_app.dao;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital_app.hospitalboot_app.dto.Branches;
import com.ty.hospital_app.hospitalboot_app.repository.BranchesRepository;
@Repository
public class BranchesDao {

	@Autowired
	private BranchesRepository repository ;
	
	public Branches saveBranches(Branches branches ) {
		return repository.save(branches);
	}
	
	public Branches updateBranches(Branches branches ) {
		return repository.save(branches);
	}
	
	public Branches getBranchesById(int id) {
		Optional<Branches> optional =repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public String deleteBranchesById(int id) {
		repository.deleteById(id);
		return "Deleted";
	}
}

