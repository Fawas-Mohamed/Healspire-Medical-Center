/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.dao.impl;

import com.hospital.dao.TestReportDAO;
import com.hospital.model.Patient;
import com.hospital.model.TestReport;
import com.hospital.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 */
public class TestReportDAOImpl implements TestReportDAO {
    @Override
    public void save(TestReport r) {
    String sql = "INSERT INTO test_reports(patient_id, report_name, file_path, created_at) VALUES (?,?,?,CURRENT_TIMESTAMP)";
    try (Connection c = DBConnection.getConnection();
         PreparedStatement p = c.prepareStatement(sql)) {
      p.setInt(1, r.getPatientId());
      p.setString(2, r.getReportName());
      p.setString(3, r.getFilePath());
      p.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

    @Override
 public List<TestReport> findByPatientId(int patientId) {
    List<TestReport> list = new ArrayList<>();
    String sql = "SELECT * FROM test_reports WHERE patient_id=? ORDER BY created_at DESC";
    try (Connection c = DBConnection.getConnection();
         PreparedStatement p = c.prepareStatement(sql)) {
      p.setInt(1, patientId);
      try (ResultSet rs = p.executeQuery()) {
        while (rs.next()) {
          list.add(mapRow(rs));
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return list;
  }

  @Override
  public TestReport findById(int id) {
    String sql = "SELECT * FROM test_reports WHERE id=?";
    try (Connection c = DBConnection.getConnection();
         PreparedStatement p = c.prepareStatement(sql)) {
      p.setInt(1, id);
      try (ResultSet rs = p.executeQuery()) {
        if (rs.next()) {
          return mapRow(rs);
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return null;
  }

  @Override
  public List<TestReport> findAll() {
    List<TestReport> list = new ArrayList<>();
    String sql = "SELECT * FROM test_reports ORDER BY created_at DESC";
    try (Connection c = DBConnection.getConnection();
         Statement st = c.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
      while (rs.next()) {
        list.add(mapRow(rs));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return list;
  }

  /** Helper to map a ResultSet row into TestReport */
  private TestReport mapRow(ResultSet rs) throws SQLException {
    TestReport r = new TestReport();
    r.setId(rs.getInt("id"));
    r.setPatientId(rs.getInt("patient_id"));
    r.setReportName(rs.getString("report_name"));
    r.setFilePath(rs.getString("file_path"));
    r.setCreatedAt(rs.getTimestamp("created_at"));
    return r;
  }
}