/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.dao;

import com.hospital.model.TestReport;
import java.util.List;

/**
 *
 * @author 
 */
public interface TestReportDAO {
  List<TestReport> findByPatientId(int patientId);
  TestReport findById(int id);

    void save(TestReport r);

    List<TestReport> findAll();
}
