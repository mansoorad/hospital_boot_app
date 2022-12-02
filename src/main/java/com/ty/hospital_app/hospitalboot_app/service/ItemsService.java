package com.ty.hospital_app.hospitalboot_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ty.hospital_app.hospitalboot_app.dao.ItemsDao;
import com.ty.hospital_app.hospitalboot_app.dto.Items;
import com.ty.hospital_app.hospitalboot_app.exception.NoSuchIdFoundException;
import com.ty.hospital_app.hospitalboot_app.util.ResponseStructure;

@Service
public class ItemsService {
	@Autowired
	ItemsDao itemsdao;

	public ResponseEntity<ResponseStructure<Items>> saveItems(Items items) {
		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("item saved");
		responseStructure.setData(itemsdao.saveItems(items));
		ResponseEntity<ResponseStructure<Items>> responseEntity = new ResponseEntity<ResponseStructure<Items>>(
				responseStructure, HttpStatus.CREATED);
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Items>> updateItemsById(Items items, int id) {
		Items items1 = itemsdao.finditemsById(id);

		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		if (items1 != null) {
			items.setItemId(id);
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("item updated");
			responseStructure.setData(itemsdao.saveItems(items));
			ResponseEntity<ResponseStructure<Items>> responseEntity = new ResponseEntity<ResponseStructure<Items>>(
					responseStructure, HttpStatus.FOUND);
			return responseEntity;
		} else {
			throw new NoSuchIdFoundException("entered id is not found in Db");
		}

	}

	public ResponseEntity<ResponseStructure<String>> deleteItemById(int id) {
		Items items1 = itemsdao.finditemsById(id);

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (items1 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("item deleted");
			responseStructure.setData(itemsdao.deleteItemsById(id));
			ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
					responseStructure, HttpStatus.OK);
			return responseEntity;
		} else {
			throw new NoSuchIdFoundException("entered id is not found in Db");
		}

	}

	public ResponseEntity<ResponseStructure<Items>> getitemByid(int id) {
		Items items1 = itemsdao.finditemsById(id);

		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		if (items1 != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("item featched");
			responseStructure.setData(itemsdao.finditemsById(id));
			ResponseEntity<ResponseStructure<Items>> responseEntity = new ResponseEntity<ResponseStructure<Items>>(
					responseStructure, HttpStatus.FOUND);
			return responseEntity;
		} else {
			throw new NoSuchIdFoundException("entered item id is not found in Db");
		}
	}
}
