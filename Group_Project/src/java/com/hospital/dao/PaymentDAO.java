package com.hospital.dao;
import com.hospital.model.Payment;
import java.util.List;
public interface PaymentDAO {
     void savePayment(Payment payment);
    List<Payment> getPatientPayments(int patientId);
    Payment getPaymentById(int paymentId);

    public void makePayment(int patientId, int appointmentId, double amount);

}
