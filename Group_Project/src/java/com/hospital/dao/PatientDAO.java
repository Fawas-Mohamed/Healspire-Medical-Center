package com.hospital.dao;
import com.hospital.model.Patient;
import java.util.List;
import java.util.Optional;
public interface PatientDAO {
  void save(Patient p);
  Optional<Patient> findByEmailAndPassword(String email, String password);

    List<Patient> findAll(); 

    public Patient validateUser(String email, String password);
}
