package com.hospital.dao;

import com.hospital.model.TestReport;
import java.util.List;
public interface TestReportDAO {
  List<TestReport> findByPatientId(int patientId);
  TestReport findById(int id);

    void save(TestReport r);

    List<TestReport> findAll();
}
