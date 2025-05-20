/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.dao;

/**
 *
 * @author 
 */
import com.hospital.model.Payment;

import java.util.List;
public interface PaymentDAO {
     void savePayment(Payment payment);
    List<Payment> getPatientPayments(int patientId);
    Payment getPaymentById(int paymentId);

    public void makePayment(int patientId, int appointmentId, double amount);

}
