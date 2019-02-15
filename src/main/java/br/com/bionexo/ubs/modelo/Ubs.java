package br.com.bionexo.ubs.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ubs {
	
	@Id
	private Integer id;
	private String name;
	private String address;
	private String city;
	private String phone;
	private Float lat;
	private Float lng;
	private Integer size;
	private Integer adptSeniors;
	private Integer medicalEquipaments;
	private Integer medicine;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Float getLat() {
		return lat;
	}
	public void setLat(Float lat) {
		this.lat = lat;
	}
	public Float getLng() {
		return lng;
	}
	public void setLng(Float lng) {
		this.lng = lng;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getAdptSeniors() {
		return adptSeniors;
	}
	public void setAdptSeniors(Integer adptSeniors) {
		this.adptSeniors = adptSeniors;
	}
	public Integer getMedicalEquipaments() {
		return medicalEquipaments;
	}
	public void setMedicalEquipaments(Integer medicalEquipaments) {
		this.medicalEquipaments = medicalEquipaments;
	}
	public Integer getMedicine() {
		return medicine;
	}
	public void setMedicine(Integer medicine) {
		this.medicine = medicine;
	}
}
