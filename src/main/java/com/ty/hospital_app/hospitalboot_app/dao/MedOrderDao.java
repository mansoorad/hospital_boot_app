package com.ty.hospital_app.hospitalboot_app.dao;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.hospital_app.hospitalboot_app.dto.MedOrder;
import com.ty.hospital_app.hospitalboot_app.repository.MedOrderRepository;

@Repository
public class MedOrderDao {
	@Autowired
	private MedOrderRepository medOrderRepository;

	public MedOrder saveMedOrder(MedOrder medOrder) {
		return medOrderRepository.save(medOrder);
	}

	public MedOrder updateMedOrder(MedOrder medOrder) {
		return medOrderRepository.save(medOrder);
	}

	public MedOrder getMedOrderById(int id) {
		Optional<MedOrder> optional = medOrderRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public String deleteMedOrderById(int id) {
		medOrderRepository.deleteById(id);
		return "med order deleted for id" + id;
	}
}
