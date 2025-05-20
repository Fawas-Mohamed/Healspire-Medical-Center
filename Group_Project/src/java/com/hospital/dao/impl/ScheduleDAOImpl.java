/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.dao.impl;

import com.hospital.dao.ScheduleDAO;
import com.hospital.model.Schedule;
import com.hospital.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author 
 */
public class ScheduleDAOImpl implements ScheduleDAO {
  @Override
   public void save(Schedule s) {
    String sql = "INSERT INTO schedules (doctor_id, schedule_date, time_slot) VALUES (?,?,?)";
    try (Connection c = DBConnection.getConnection();
         PreparedStatement p = c.prepareStatement(sql)) {
      p.setInt(1, s.getDoctorId());
      p.setDate(2, new java.sql.Date(s.getScheduleDate().getTime()));
      p.setString(3, s.getTimeSlot());
      p.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Schedule> findByDoctorId(int doctorId) {
    List<Schedule> list = new ArrayList<>();
    String sql = "SELECT id, doctor_id, schedule_date, time_slot FROM schedules WHERE doctor_id=?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setInt(1, doctorId);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Schedule s = new Schedule();
            s.setId(rs.getInt("id"));
            s.setDoctorId(rs.getInt("doctor_id"));
            s.setScheduleDate(rs.getDate("schedule_date"));
            s.setTimeSlot(rs.getString("time_slot"));
            list.add(s);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}

  @Override
  public List<Schedule> findAll() {
    List<Schedule> L = new ArrayList<>();
    String sql =
      "SELECT sc.id, sc.doctor_id, d.name AS doctor_name, sc.schedule_date, sc.time_slot " +
      "FROM schedules sc " +
      "JOIN doctors d ON sc.doctor_id=d.DoctorId " +
      "ORDER BY sc.schedule_date";
    try (Connection c = DBConnection.getConnection();
         Statement st = c.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
      while (rs.next()) {
        Schedule s = new Schedule();
        s.setId(rs.getInt("id"));
        s.setDoctorId(rs.getInt("doctor_id"));
        s.setDoctorName(rs.getString("doctor_name"));       // ← set name
        s.setScheduleDate(rs.getDate("schedule_date"));
        s.setTimeSlot(rs.getString("time_slot"));
        L.add(s);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return L;
  }
}