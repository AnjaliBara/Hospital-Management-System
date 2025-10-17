package com.entity;

public class Patient {

	private int id ;
	private int doctorId;
	private int age;
    private String name, gender, address, phone;
    private String disease, admitDate;
	public final int getId() {
		return id;
	}
	public final void setId(int id) {
		this.id = id;
	}
	public final int getDoctorId() {
		return doctorId;
	}
	public final void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public final int getAge() {
		return age;
	}
	public final void setAge(int age) {
		this.age = age;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getGender() {
		return gender;
	}
	public final void setGender(String gender) {
		this.gender = gender;
	}
	public final String getAddress() {
		return address;
	}
	public final void setAddress(String address) {
		this.address = address;
	}
	public final String getPhone() {
		return phone;
	}
	public final void setPhone(String phone) {
		this.phone = phone;
	}
	public final String getDisease() {
		return disease;
	}
	public final void setDisease(String disease) {
		this.disease = disease;
	}
	public final String getAdmitDate() {
		return admitDate;
	}
	public final void setAdmitDate(String admitDate) {
		this.admitDate = admitDate;
	}
    
    
}
