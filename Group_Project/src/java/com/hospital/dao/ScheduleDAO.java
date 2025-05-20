package com.hospital.dao;

import com.hospital.model.Schedule;
import java.util.List;

public interface ScheduleDAO {
  void save(Schedule s);
  public List<Schedule> findByDoctorId(int doctorId);
  List<Schedule> findAll();
 
}
