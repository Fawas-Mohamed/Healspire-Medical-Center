/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.dao;

import com.hospital.model.Schedule;
import java.util.List;

/**
 *
 * @author 
 */
public interface ScheduleDAO {
  void save(Schedule s);
  public List<Schedule> findByDoctorId(int doctorId);
  List<Schedule> findAll();
 
}
