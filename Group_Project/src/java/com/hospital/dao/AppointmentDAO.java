package com.hospital.dao;

import com.hospital.model.Appointment;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface AppointmentDAO {
    /** Insert a new appointment (paymentStatus can be “Pending” or “Paid”).
     * @param appt */
    void saveAppointment(Appointment appt);

    /** Fetch all appointments for a given patient email (or you could overload by patientName/ID).
     * @param patientEmail
     * @return  */
    List<Appointment> findByPatientEmail(String patientEmail);

    /** Fetch one appointment by its primary key ID.
     * @param appointmentId
     * @return  */
    Appointment findById(int appointmentId);

    /** Update the payment status (e.g.from “Pending” to “Paid”).
     * @param appointmentId
     * @param paymentStatus */
    void updatePaymentStatus(int appointmentId, String paymentStatus);
    List<Appointment> findAll();  // For Admin
    List<Appointment> findByDoctorId(int doctorId);

    public List<Appointment> findAllAppointments();
}
