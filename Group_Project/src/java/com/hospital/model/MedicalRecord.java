/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.model;

import java.util.Date;

/**
 *
 * @author 
 */
public class MedicalRecord {
     private int id;
    private int patientId;
    private Date recordDate;
    private String description;
    private String doctorNotes;

    public MedicalRecord() {}

    public MedicalRecord(int id, int patientId, Date recordDate, String description, String doctorNotes) {
        this.id = id;
        this.patientId = patientId;
        this.recordDate = recordDate;
        this.description = description;
        this.doctorNotes = doctorNotes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDoctorNotes() {
        return doctorNotes;
    }

    public void setDoctorNotes(String doctorNotes) {
        this.doctorNotes = doctorNotes;
    }

    
}
