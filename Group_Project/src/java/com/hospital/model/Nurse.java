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
// com.hospital.model.Nurse.java

public class Nurse {
  private int id;
  private String name, email, password, specialization;
  private Date createdAt;
  // getters / setters…
  public int getId() { return id; }
  public void setId(int id) { this.id = id; }
  public String getName() { return name; }
  public void setName(String n) { this.name = n; }
  public String getEmail() { return email; }
  public void setEmail(String e) { this.email = e; }
  public String getPassword() { return password; }
  public void setPassword(String p) { this.password = p; }
  public String getSpecialization() { return specialization; }
  public void setSpecialization(String s) { this.specialization = s; }
  public Date getCreatedAt() { return createdAt; }
  public void setCreatedAt(Date d) { this.createdAt = d; }
}
