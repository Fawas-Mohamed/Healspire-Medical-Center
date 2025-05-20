/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.model;

/**
 *
 * @author 
 */

import java.math.BigDecimal;
import java.sql.Timestamp;
public class Invoice {
public String getPatientName() {
        return patientName;
    }

    // (optional) setter
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

public String getdoctorName() {
        return doctorName;
    }

    /**
     * @param doctorName
     */
    public void setdoctorName(String doctorName) {
        this.doctorName = doctorName;}
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the appointmentId
     */
    public int getAppointmentId() {
        return appointmentId;
    }

    /**
     * @param appointmentId the appointmentId to set
     */
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    /**
     * @return the patientId
     */
    public int getPatientId() {
        return patientId;
    }

    /**
     * @param patientId the patientId to set
     */
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * @return the paymentDate
     */
    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    /**
     * @param paymentDate the paymentDate to set
     */
    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * @return the pdfPath
     */
    public String getPdfPath() {
        return pdfPath;
    }

    /**
     * @param pdfPath the pdfPath to set
     */
    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }

    /**
     * @return the createdAt
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    private int id;
  private int appointmentId;
  private int patientId;
  private BigDecimal amount;
  private Timestamp paymentDate;
  private String pdfPath;
  private Timestamp createdAt;
  private String doctorName;
  private String patientName;
    
    
}
