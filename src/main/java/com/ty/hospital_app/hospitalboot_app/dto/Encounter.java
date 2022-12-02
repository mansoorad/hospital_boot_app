package com.ty.hospital_app.hospitalboot_app.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int encounterId;
	private String encounterName;
	private String encounterReason;
	@OneToMany
	private List<Branches> branches;
	@OneToMany
	private List<MedOrder> medOrders;

	public int getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(int encounterId) {
		this.encounterId = encounterId;
	}

	public String getEncounterName() {
		return encounterName;
	}

	public void setEncounterName(String encounterName) {
		this.encounterName = encounterName;
	}

	public String getEncounterReason() {
		return encounterReason;
	}

	public void setEncounterReason(String encounterReason) {
		this.encounterReason = encounterReason;
	}

	public List<Branches> getBranches() {
		return branches;
	}

	public void setBranches(List<Branches> branches) {
		this.branches = branches;
	}

	public List<MedOrder> getMedOrders() {
		return medOrders;
	}

	public void setMedOrders(List<MedOrder> medOrders) {
		this.medOrders = medOrders;
	}

}
