/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.dao;

/**
 *
 * @author 
 */
import com.hospital.model.Nurse;
import java.util.List;
public interface NurseDAO {
  List<Nurse> findAll();
  void save(Nurse n);
  void deleteById(int id);
}