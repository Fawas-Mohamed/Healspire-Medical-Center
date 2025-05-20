/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.dao.impl;

/**
 *
 * @author 
 */
import com.hospital.dao.MedicalHistoryDAO;
import com.hospital.model.MedicalRecord;
import com.hospital.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC implementation of MedicalHistoryDAO.
 */
public class MedicalHistoryDAOImpl implements  MedicalHistoryDAO {

   
    @Override
    public List<MedicalRecord> findByPatientId(int patientId) {
        List<MedicalRecord> list = new ArrayList<>();
        String sql = "SELECT id, patient_id, record_date, description, doctor_notes FROM medical_records WHERE patient_id = ? ORDER BY record_date DESC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, patientId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                MedicalRecord mr = new MedicalRecord();
                mr.setId(rs.getInt("id"));
                mr.setPatientId(rs.getInt("patient_id"));
                mr.setRecordDate(rs.getDate("record_date"));
                mr.setDescription(rs.getString("description"));
                mr.setDoctorNotes(rs.getString("doctor_notes"));
                list.add(mr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

   
    @Override
    public void save(MedicalRecord record) {
        String sql = "INSERT INTO medical_records (patient_id, record_date, description, doctor_notes) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, record.getPatientId());
            pst.setDate(2, new java.sql.Date(record.getRecordDate().getTime()));
            pst.setString(3, record.getDescription());
            pst.setString(4, record.getDoctorNotes());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    @Override
    public void update(MedicalRecord record) {
        String sql = "UPDATE medical_records SET record_date = ?, description = ?, doctor_notes = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setDate(1, new java.sql.Date(record.getRecordDate().getTime()));
            pst.setString(2, record.getDescription());
            pst.setString(3, record.getDoctorNotes());
            pst.setInt(4, record.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    @Override
    public void delete(int recordId) {
        String sql = "DELETE FROM medical_records WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, recordId);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

