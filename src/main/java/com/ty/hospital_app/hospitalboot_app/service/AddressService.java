package com.ty.hospital_app.hospitalboot_app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_app.hospitalboot_app.dao.AddressDao;
import com.ty.hospital_app.hospitalboot_app.dto.Address;

import com.ty.hospital_app.hospitalboot_app.exception.NoSuchIdFoundException;
import com.ty.hospital_app.hospitalboot_app.util.ResponseStructure;
@Service
public class AddressService {

	@Autowired
	private AddressDao dao;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
		ResponseEntity<ResponseStructure<Address>> responseEntity = new ResponseEntity<ResponseStructure<Address>>(
				responseStructure, HttpStatus.CREATED);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveAddress(address));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<String>> deleteAddress(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
				responseStructure, HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deleteAddressById(id));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address, int id) {
		Address address2 = dao.getAddressById(id);
		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
		ResponseEntity<ResponseStructure<Address>> responseEntity = new ResponseEntity<ResponseStructure<Address>>(
				responseStructure, HttpStatus.OK);
		if (address2 != null) {
			address.setAddressId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(dao.updateAddress(address));

		} else {
			throw new NoSuchIdFoundException("No Id Found To Update");
		}
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Address>> getAddressById(int id) {
		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
		ResponseEntity<ResponseStructure<Address>> responseEntity = new ResponseEntity<ResponseStructure<Address>>(
				responseStructure, HttpStatus.OK);
		Address user2 = dao.getAddressById(id);
		if (user2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Received");
			responseStructure.setData(dao.getAddressById(id));
		} else {
			throw new NoSuchIdFoundException("No Id Found In Data Base For address");
		}
		return responseEntity;
	}
}
