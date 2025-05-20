/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.dao.impl;

/**
 *
 * @author 
 */
import com.hospital.dao.AppointmentDAO;
import com.hospital.model.Appointment;
import com.hospital.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Time;
import java.security.Timestamp;



public class AppointmentDAOImpl implements AppointmentDAO {

    public AppointmentDAOImpl() {
    }

@Override
public void saveAppointment(Appointment appt) {
        String sql = "INSERT INTO appointmentss " +
                     "(doctor_id, schedule_id, patient_name, patient_email,patient_phone, payment_status,booked_at) " +
                     "VALUES (?,?,?,?,?,?, NOW())";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pst.setInt(1, appt.getDoctorId());
            pst.setInt(2, appt.getScheduleId());
            pst.setString(3, appt.getPatientName());
            pst.setString(4, appt.getPatientEmail());
            pst.setString(5, appt.getPatientPhone()); 
            pst.setString(6, appt.getPaymentStatus());
            pst.executeUpdate();

 
            try (ResultSet rs = pst.getGeneratedKeys()) {
                if (rs.next()) {
                    appt.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error saving appointment", e);
        }
    }

    @Override
    public List<Appointment> findByPatientEmail(String patientEmail) {
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM appointmentss WHERE patient_email=? ORDER BY booked_at DESC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, patientEmail);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Appointment a = mapRow(rs);
                    list.add(a);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching appointments", e);
        }
        return list;
    }

    @Override
    public Appointment findById(int apptId) {
        String sql =
          "SELECT a.id, a.doctor_id, a.patient_name, a.patient_email, a.payment_status, a.booked_at, " +
          "  a.patient_phone,      s.schedule_date, s.time_slot " +
          "FROM appointmentss a " +
          "JOIN schedules s ON a.schedule_id = s.id " +
          "WHERE a.id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, apptId);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding appointment", e);
        }
        return null;
    }


    @Override
    public void updatePaymentStatus(int appointmentId, String paymentStatus) {
        String sql = "UPDATE appointmentss SET payment_status=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, paymentStatus);
            pst.setInt(2, appointmentId);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating payment status", e);
        }
    }
 
    @Override
     public List<Appointment> findAll() {
        List<Appointment> list = new ArrayList<>();
        String sql =
          "SELECT a.id, a.doctor_id, a.patient_name, a.patient_email, a.payment_status, a.booked_at,  " +
          "       s.schedule_date, s.time_slot  " +
          "FROM appointmentss a  " +
          "JOIN schedules s ON a.schedule_id = s.id  " +
          "ORDER BY s.schedule_date DESC";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Appointment a = mapRow(rs);
                list.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching all appointments", e);
        }
        return list;
    }

    @Override
    public List<Appointment> findByDoctorId(int doctorId) {
        List<Appointment> list = new ArrayList<>();
        String sql =
          "SELECT a.id, a.doctor_id, a.patient_name, a.patient_email, a.patient_phone, a.payment_status, a.booked_at,  " +
          "       s.schedule_date, s.time_slot  " +
          "FROM appointmentss a  " +
          "JOIN schedules s ON a.schedule_id = s.id  " +
          "WHERE a.doctor_id = ?  " +
          "ORDER BY s.schedule_date DESC";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, doctorId);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Appointment a = mapRow(rs);
                    list.add(a);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching appointments for doctor", e);
        }
        return list;
    }

    /** Helper: map one ResultSet row to Appointment (incl. date/time). */
    private Appointment mapRow(ResultSet rs) throws SQLException {
        Appointment a = new Appointment();
        a.setId(rs.getInt("id"));
        a.setDoctorId(rs.getInt("doctor_id"));
        a.setPatientName(rs.getString("patient_name"));
        a.setPatientEmail(rs.getString("patient_email"));
         a.setPatientPhone    ( rs.getString("patient_phone") );
        a.setPaymentStatus(rs.getString("payment_status"));
        a.setBookedAt        ( rs.getTimestamp("booked_at") );
        
        a.setAppointmentDate(rs.getDate("schedule_date"));
        a.setAppointmentTime(rs.getString("time_slot"));
        return a;
    }
    
    @Override
    public List<Appointment> findAllAppointments() {
   List<Appointment> list = new ArrayList<>();
    String sql =
      "SELECT a.id, a.doctor_id, a.schedule_id, a.patient_name, a.patient_email, a.patient_phone, " +
      "       a.payment_status, a.booked_at, " +
      "       s.schedule_date, s.time_slot " +
      "FROM appointmentss a " +
      "JOIN schedules s ON a.schedule_id = s.id " +
      "ORDER BY a.booked_at DESC";
    try (Connection conn = DBConnection.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {

            Appointment a = mapRow(rs);
            list.add(a);
        }
    } catch (SQLException e) {
        throw new RuntimeException("Error fetching all appointments", e);
    }
    return list;
}}