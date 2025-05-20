/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.dao.impl;

/**
 *
 * @author 
 */
import com.hospital.dao.InvoiceDAO;
import com.hospital.model.Invoice;
import com.hospital.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAOImpl implements InvoiceDAO {
  @Override
  public Invoice create(Invoice inv) {
    String sql = "INSERT INTO invoices(appointment_id,patient_id,amount,payment_date,pdf_path) VALUES(?,?,?,?,?)";
    try (Connection c = DBConnection.getConnection();
         PreparedStatement p = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      p.setInt(1, inv.getAppointmentId());
      p.setInt(2, inv.getPatientId());
      p.setBigDecimal(3, inv.getAmount());
      p.setTimestamp(4, inv.getPaymentDate());
      p.setString(5, inv.getPdfPath());
      p.executeUpdate();
      try (ResultSet rs = p.getGeneratedKeys()) {
        if (rs.next()) inv.setId(rs.getInt(1));
      }
      return inv;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Invoice> findByPatientId(int patientId) {
    List<Invoice> list = new ArrayList<>();
    String sql = "SELECT * FROM invoices WHERE patient_id=? ORDER BY created_at DESC";
    try (Connection c = DBConnection.getConnection();
         PreparedStatement p = c.prepareStatement(sql)) {
      p.setInt(1, patientId);
      try (ResultSet rs = p.executeQuery()) {
        while (rs.next()) {
          Invoice i = new Invoice();
          i.setId(rs.getInt("id"));
          i.setAppointmentId(rs.getInt("appointment_id"));
          i.setPatientId(rs.getInt("patient_id"));
          i.setAmount(rs.getBigDecimal("amount"));
          i.setPaymentDate(rs.getTimestamp("payment_date"));
          i.setPdfPath(rs.getString("pdf_path"));
          i.setCreatedAt(rs.getTimestamp("created_at"));
          list.add(i);
        }
      }
      return list;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Invoice findById(int id) {
    String sql = "SELECT * FROM invoices WHERE id=?";
    try (Connection c = DBConnection.getConnection();
         PreparedStatement p = c.prepareStatement(sql)) {
      p.setInt(1, id);
      try (ResultSet rs = p.executeQuery()) {
        if (rs.next()) {
          Invoice i = new Invoice();
          i.setId(id);
          i.setAppointmentId(rs.getInt("appointment_id"));
          i.setPatientId(rs.getInt("patient_id"));
          i.setAmount(rs.getBigDecimal("amount"));
          i.setPaymentDate(rs.getTimestamp("payment_date"));
          i.setPdfPath(rs.getString("pdf_path"));
          i.setCreatedAt(rs.getTimestamp("created_at"));
          return i;
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return null;
  }
}