/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.dao;

/**
 *
 * @author 
 */

import com.hospital.model.Patient;
import java.util.List;
import java.util.Optional;
public interface PatientDAO {
  void save(Patient p);
  Optional<Patient> findByEmailAndPassword(String email, String password);

    List<Patient> findAll(); 

    public Patient validateUser(String email, String password);
}