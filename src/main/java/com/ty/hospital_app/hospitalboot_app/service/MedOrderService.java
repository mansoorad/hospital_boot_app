package com.ty.hospital_app.hospitalboot_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_app.hospitalboot_app.dao.MedOrderDao;
import com.ty.hospital_app.hospitalboot_app.dto.Items;
import com.ty.hospital_app.hospitalboot_app.dto.MedOrder;
import com.ty.hospital_app.hospitalboot_app.exception.NoSuchIdFoundException;
import com.ty.hospital_app.hospitalboot_app.util.ResponseStructure;

@Service
public class MedOrderService {
	@Autowired
	private MedOrderDao dao;

	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medOrder) {
		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<MedOrder>();
		List<Items> items = medOrder.getItems();
		double totalcost = 0;
		for (Items items2 : items) {
			totalcost = totalcost + (items2.getItemPrice() * items2.getItemQuantity());
		}
		totalcost = (totalcost * 0.18) + totalcost;
		medOrder.setTotalCost(totalcost);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("medorder saved");
		responseStructure.setData(dao.saveMedOrder(medOrder));
		ResponseEntity<ResponseStructure<MedOrder>> responseEntity = new ResponseEntity<ResponseStructure<MedOrder>>(
				responseStructure, HttpStatus.CREATED);
		return responseEntity;

	}

	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(MedOrder medOrder, int id) {
		MedOrder medOrder2 = dao.getMedOrderById(id);
		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<MedOrder>();

		if (medOrder2 != null) {
			List<Items> items = medOrder.getItems();
			double totalcost = 0;
			for (Items items2 : items) {
				totalcost = totalcost + (items2.getItemPrice() * items2.getItemQuantity());
			}
			totalcost = (totalcost * 0.18) + totalcost;
			medOrder.setTotalCost(totalcost);
			medOrder.setMedOrdersId(id);
			medOrder.setItems(items);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("MedOrder updated");
			responseStructure.setData(dao.updateMedOrder(medOrder));
			ResponseEntity<ResponseStructure<MedOrder>> responseEntity = new ResponseEntity<ResponseStructure<MedOrder>>(
					responseStructure, HttpStatus.OK);

			return responseEntity;
		} else {
			throw new NoSuchIdFoundException("entered medorderid is not found in Db to update");
		}

	}

	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(int id) {
		MedOrder medOrder2 = dao.getMedOrderById(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();

		if (medOrder2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("MedOrder deleted");
			responseStructure.setData(dao.deleteMedOrderById(id));
			ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
					responseStructure, HttpStatus.OK);

			return responseEntity;
		} else {
			throw new NoSuchIdFoundException("entered medorderid is not found in Db to delete");
		}
	}

	public ResponseEntity<ResponseStructure<MedOrder>> getMedorderbyId(int id) {
		MedOrder medOrder2 = dao.getMedOrderById(id);
		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<MedOrder>();

		if (medOrder2 != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("MedOrder featched");
			responseStructure.setData(dao.getMedOrderById(id));
			ResponseEntity<ResponseStructure<MedOrder>> responseEntity = new ResponseEntity<ResponseStructure<MedOrder>>(
					responseStructure, HttpStatus.FOUND);

			return responseEntity;
		} else {
			throw new NoSuchIdFoundException("entered medorderid is not found in Db to update");
		}
	}

}
