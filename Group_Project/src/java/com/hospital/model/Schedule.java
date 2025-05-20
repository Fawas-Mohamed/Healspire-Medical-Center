package com.hospital.model;

import java.util.Date;

public class Schedule {
  private int id;
  private int doctorId;
  private String doctorName;    
  private Date scheduleDate;
  private String timeSlot;

  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public int getDoctorId() { return doctorId; }
  public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

  public String getDoctorName() { return doctorName; }  
  public void setDoctorName(String n) { this.doctorName = n; }  

  public Date getScheduleDate() { return scheduleDate; }
  public void setScheduleDate(Date d) { this.scheduleDate = d; }

  public String getTimeSlot() { return timeSlot; }
  public void setTimeSlot(String s) { this.timeSlot = s; }
}
