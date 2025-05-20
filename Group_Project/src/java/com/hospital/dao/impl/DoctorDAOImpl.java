/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.dao.impl;

/**
 *
 * @author 
 */
import com.hospital.dao.DoctorDAO;
import com.hospital.model.Doctor;
import com.hospital.model.LogEntry;
import com.hospital.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/hospital_db";
    private static final String USER = "root";
    private static final String PASS = "";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
    }
    @Override
    public List<Doctor> findAll() {
        List<Doctor> list = new ArrayList<>();
         String sql = "SELECT DoctorId AS id, name, specialization, fee FROM doctors";
        try (Connection conn = DBConnection.getConnection();
             Statement st    = conn.createStatement();
             ResultSet rs    = st.executeQuery(sql)) {
            while (rs.next()) {
                Doctor d = new Doctor();
                d.setId(rs.getInt("id"));                     
                d.setName(rs.getString("name"));
                d.setSpecialization(rs.getString("specialization"));
                d.setFee(rs.getDouble("fee"));
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public void save(Doctor doctor) {
        String sql = "INSERT INTO doctors(name,specialization,fee,password) VALUES (?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, doctor.getName());
            pst.setString(2, doctor.getSpecialization());
            pst.setDouble(3, doctor.getFee());
              pst.setString(4, doctor.getPassword());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int doctorId) {
        String sql = "DELETE FROM doctors WHERE DoctorId=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, doctorId);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Doctor findById(int id) {
        String sql = "SELECT DoctorId AS id, name, specialization, fee FROM doctors WHERE DoctorId=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Doctor d = new Doctor();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setSpecialization(rs.getString("specialization"));
                d.setFee(rs.getDouble("fee"));
                return d;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Doctor doctor) {
        String sql = "UPDATE doctors SET name=?, specialization=?, fee=? WHERE DoctorId=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, doctor.getName());
            pst.setString(2, doctor.getSpecialization());
            pst.setDouble(3, doctor.getFee());
             pst.setString(4, doctor.getPassword());
            pst.setInt(5, doctor.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSpecialization(int id, String specialization) {
        String sql = "UPDATE doctors SET specialization=? WHERE DoctorId=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, specialization);
            pst.setInt(2, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isAvailable(int doctorId, String date) {
        String sql = "SELECT COUNT(*) FROM appointments WHERE doctor_id=? AND date=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, doctorId);
            pst.setString(2, date);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
  
   
    
    @Override
public Doctor validateUser(String id, String password, String name) {
    Doctor user = null;
    try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
        PreparedStatement ps = conn.prepareStatement(
            "SELECT DoctorId, name, specialization, fee, password FROM doctors WHERE DoctorId=? AND password=?"
        );
        ps.setString(1, id);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            user = new Doctor();
            user.setId(rs.getInt("DoctorId")); // <--- fix here!
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            user.setSpecialization(rs.getString("specialization"));
            user.setFee(rs.getDouble("fee"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return user;
}


    @Override
    public List<LogEntry> findAllDoctorLogs() {
        List<LogEntry> list = new ArrayList<>();
        String sql = "DoctorId AS id, user_id AS username, action, timestamp FROM doctorslog ORDER BY timestamp DESC";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                LogEntry e = new LogEntry();
                e.setId(rs.getInt("id"));
                e.setEntityId(rs.getInt("username"));
                e.setAction(rs.getString("action"));
                e.setTimestamp(rs.getTimestamp("timestamp"));
                list.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
}}

   
   
    
    

    

