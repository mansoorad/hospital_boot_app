package com.ty.hospital_app.hospitalboot_app.dao;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital_app.hospitalboot_app.dto.Address;
import com.ty.hospital_app.hospitalboot_app.repository.AddressRepository;


@Repository
public class AddressDao {

	
	@Autowired
	private AddressRepository repository ;
	
	public Address saveAddress(Address address ) {
		return repository.save(address);
	}
	
	public Address updateAddress(Address address ) {
		return repository.save(address);
	}
	
	public Address getAddressById(int id) {
		Optional<Address> optional =repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public String deleteAddressById(int id) {
		repository.deleteById(id);
		return "Deleted";
	}
}

