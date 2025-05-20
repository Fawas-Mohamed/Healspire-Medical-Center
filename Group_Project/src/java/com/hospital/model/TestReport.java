package com.hospital.model;

import java.sql.Timestamp;
public class TestReport {
  private int id;
  private int patientId;
  private String reportName;
  private String filePath;
  private Timestamp createdAt;

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public int getPatientId() { return patientId; }
  public void setPatientId(int patientId) { this.patientId = patientId; }

  public String getReportName() { return reportName; }
  public void setReportName(String reportName) { this.reportName = reportName; }

  public String getFilePath() { return filePath; }
  public void setFilePath(String filePath) { this.filePath = filePath; }

  public Timestamp getCreatedAt() { return createdAt; }
  public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}
    
