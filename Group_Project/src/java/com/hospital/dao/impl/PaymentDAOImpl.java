/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.dao.impl;

/**
 *
 * @author 
 */
import com.hospital.dao.PaymentDAO;
import com.hospital.model.Payment;
import com.hospital.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public void savePayment(Payment payment) {
        String sql = "INSERT INTO payments (patient_id, amount, payment_date, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, payment.getPatientId());
            pst.setDouble(2, payment.getAmount());
            pst.setDate(3, new java.sql.Date(payment.getPaymentDate().getTime()));
            pst.setString(4, payment.getStatus());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Payment> getPatientPayments(int patientId) {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM payments WHERE patient_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, patientId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Payment payment = new Payment();
                payment.setId(rs.getInt("id"));
                payment.setPatientId(rs.getInt("patient_id"));
                payment.setAmount(rs.getDouble("amount"));
                payment.setPaymentDate(rs.getDate("payment_date"));
                payment.setStatus(rs.getString("status"));
                payments.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }

    @Override
    public Payment getPaymentById(int paymentId) {
        Payment payment = null;
        String sql = "SELECT * FROM payments WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, paymentId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                payment = new Payment();
                payment.setId(rs.getInt("id"));
                payment.setPatientId(rs.getInt("patient_id"));
                payment.setAmount(rs.getDouble("amount"));
                payment.setPaymentDate(rs.getDate("payment_date"));
                payment.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }

    @Override
    public void makePayment(int patientId, int appointmentId, double amount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}
