package com.dao;
import java.sql.*;
import java.util.*;
import com.entity.Patient;

public class PatientDao {
    private Connection conn;

    public PatientDao(Connection conn) {
        this.conn = conn;
    }

    public boolean addPatient(Patient p) {
        boolean f = false;
        try {
            String sql = "INSERT INTO patient(doctor_id, name, gender, age, address, phone, disease, admit_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getDoctorId());
            ps.setString(2, p.getName());
            ps.setString(3, p.getGender());
            ps.setInt(4, p.getAge());
            ps.setString(5, p.getAddress());
            ps.setString(6, p.getPhone());
            ps.setString(7, p.getDisease());
            ps.setString(8, p.getAdmitDate());
            int i = ps.executeUpdate();
            if (i == 1) f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public List<Patient> getPatientsByDoctor(int doctorId) {
        List<Patient> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM patient WHERE doctor_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Patient p = new Patient();
                p.setId(rs.getInt("id"));
                p.setDoctorId(rs.getInt("doctor_id"));
                p.setName(rs.getString("name"));
                p.setGender(rs.getString("gender"));
                p.setAge(rs.getInt("age"));
                p.setAddress(rs.getString("address"));
                p.setPhone(rs.getString("phone"));
                p.setDisease(rs.getString("disease"));
                p.setAdmitDate(rs.getString("admit_date"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
