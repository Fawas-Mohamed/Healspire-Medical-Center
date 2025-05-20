/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.dao;

/**
 *
 * @author 
 */
import com.hospital.model.Appointment;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface AppointmentDAO {
    /** Insert a new appointment (paymentStatus can be “Pending” or “Paid”). */
    void saveAppointment(Appointment appt);

    /** Fetch all appointments for a given patient email (or you could overload by patientName/ID). */
    List<Appointment> findByPatientEmail(String patientEmail);

    /** Fetch one appointment by its primary key ID. */
    Appointment findById(int appointmentId);

    /** Update the payment status (e.g. from “Pending” to “Paid”). */
    void updatePaymentStatus(int appointmentId, String paymentStatus);
    List<Appointment> findAll();  // For Admin
    List<Appointment> findByDoctorId(int doctorId);

    public List<Appointment> findAllAppointments();
}