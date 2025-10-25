package com.entity;

public class Appointment {
	private int id;
    private int userId;
    private String fullName;
    private String gender;
    private String age;
    private String appointDate;
    private String email;
    private String phNo;
    private String diseases;
    private int doctorId;
    private String address;
    private String status;

    
    public final int getId() {
		return id;
	}
	public final void setId(int id) {
		this.id = id;
	}
	// Getters and Setters
    public final int getUserId() {
		return userId;
	}
	public final void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFullName() {
        return fullName;
    }
	public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    
    public final String getAppointDate() {
		return appointDate;
	}
	public final void setAppointDate(String appointDate) {
		this.appointDate = appointDate;
	}
	public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public final String getPhNo() {
		return phNo;
	}
	public final void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	public String getDiseases() {
        return diseases;
    }
    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }
    
    public final int getDoctorId() {
		return doctorId;
	}
	public final void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
	
	public Appointment(int userId, String fullName, String gender, String age, String appointDate, String email,
			String phNo, String diseases, int doctorId, String address, String status) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.gender = gender;
		this.age = age;
		this.appointDate = appointDate;
		this.email = email;
		this.phNo = phNo;
		this.diseases = diseases;
		this.doctorId = doctorId;
		this.address = address;
		this.status = status;
	}
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
