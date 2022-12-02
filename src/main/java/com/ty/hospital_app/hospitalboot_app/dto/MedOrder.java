package com.ty.hospital_app.hospitalboot_app.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MedOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medOrdersId;
	private String medOrdersName;
	private String medOrdersDate;
	@OneToMany
	private List<Items> items;

	public int getMedOrdersId() {
		return medOrdersId;
	}

	public void setMedOrdersId(int medOrdersId) {
		this.medOrdersId = medOrdersId;
	}

	public String getMedOrdersName() {
		return medOrdersName;
	}

	public void setMedOrdersName(String medOrdersName) {
		this.medOrdersName = medOrdersName;
	}

	public String getMedOrdersDate() {
		return medOrdersDate;
	}

	public void setMedOrdersDate(String medOrdersDate) {
		this.medOrdersDate = medOrdersDate;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

}
