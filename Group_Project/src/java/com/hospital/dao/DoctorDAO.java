package com.hospital.dao;
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
