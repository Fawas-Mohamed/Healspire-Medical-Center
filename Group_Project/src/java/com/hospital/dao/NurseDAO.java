package com.hospital.dao;
import com.hospital.model.Nurse;
import java.util.List;
public interface NurseDAO {
  List<Nurse> findAll();
  void save(Nurse n);
  void deleteById(int id);
}
