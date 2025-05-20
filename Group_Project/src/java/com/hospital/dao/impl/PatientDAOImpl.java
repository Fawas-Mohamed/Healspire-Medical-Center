/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.dao.impl;

/**
 *
 * @author 
 */
import com.hospital.dao.PatientDAO;
import com.hospital.model.Patient;
import com.hospital.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class PatientDAOImpl implements PatientDAO  {
    @Override
    public void save(Patient p) {
     String sql = "INSERT INTO patient(fullName, email, password, contact_no, gender, dob, created_at) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setString(1, p.getFullName());
        pst.setString(2, p.getEmail());
        pst.setString(3, p.getPassword());
        pst.setString(4, p.getContact_no());
        pst.setString(5, p.getGender());
        pst.setDate(6, new java.sql.Date(p.getDob().getTime()));
        pst.setTimestamp(7, new Timestamp(System.currentTimeMillis()));

        pst.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
  }

 
    @Override
  public Optional<Patient> findByEmailAndPassword(String email, String password) {
    String sql = "SELECT * FROM patient WHERE email=? AND password=?";
    try (Connection c = DBConnection.getConnection();
         PreparedStatement ps = c.prepareStatement(sql)) {
      ps.setString(1,email);
      ps.setString(2,password);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        Patient p = new Patient();
        p.setId(rs.getInt("id"));
        p.setFullName(rs.getString("fullname"));
        p.setEmail(rs.getString("email"));
        p.setContact_no(rs.getString("contact_no"));
        p.setGender(rs.getString("gender"));
        p.setDob(rs.getDate("dob"));
        return Optional.of(p);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return Optional.empty();
  }

  
private static final String URL = "jdbc:mysql://localhost:3306/hospital_db";
    private static final String USER = "root";
    private static final String PASS = "";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
    }
    @Override
    public Patient validateUser(String email, String password) {
         Patient user = null;
        try (Connection conn = DriverManager.getConnection(URL, USER,PASS)) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM patient WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new Patient();
                user.setPassword(rs.getString("password"));
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public List<Patient> findAll() {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT id, fullName, email FROM patient ORDER BY fullName";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Patient p = new Patient();
                p.setId(rs.getInt("id"));
                p.setFullName(rs.getString("fullName"));
                p.setEmail(rs.getString("email"));
                list.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
    

    

    

