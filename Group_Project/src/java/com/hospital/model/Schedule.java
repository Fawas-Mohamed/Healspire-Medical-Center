/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.model;

import java.util.Date;

/**
 *
 * @author 
 */
public class Schedule {
  // com/hospital/model/Schedule.java

  private int id;
  private int doctorId;
  private String doctorName;        // ← new
  private Date scheduleDate;
  private String timeSlot;

  // getters / setters
  public int getId() { return id; }
  public void setId(int id) { this.id = id; }

  public int getDoctorId() { return doctorId; }
  public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

  public String getDoctorName() { return doctorName; }    // ← new
  public void setDoctorName(String n) { this.doctorName = n; }  // ← new

  public Date getScheduleDate() { return scheduleDate; }
  public void setScheduleDate(Date d) { this.scheduleDate = d; }

  public String getTimeSlot() { return timeSlot; }
  public void setTimeSlot(String s) { this.timeSlot = s; }
}

