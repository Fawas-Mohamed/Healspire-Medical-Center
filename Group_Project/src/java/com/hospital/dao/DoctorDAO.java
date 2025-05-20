/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.dao;

/**
 *
 * @author 
 */
import com.hospital.model.Doctor;
import com.hospital.model.LogEntry;
import java.util.List;

public interface DoctorDAO {
    List<Doctor> findAll();
    void save(Doctor doctor);
    void deleteById(int doctorId);
    Doctor findById(int id);
    void update(Doctor doctor);
    void updateSpecialization(int id, String specialization);

    public List<LogEntry> findAllDoctorLogs();

    public Doctor validateUser(String id, String password, String name);
    

    
}
