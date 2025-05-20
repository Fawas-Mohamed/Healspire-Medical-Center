/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.model;

/**
 *
 * @author 
 */
import java.util.Date;
public class Patient {

    /**
     * @return the contact_no
     */
    public String getContact_no() {
        return contact_no;
    }

    /**
     * @param contact_no the contact_no to set
     */
    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }
    private int id;
  private String fullName;
  private String email;
  private String password;
  private String contact_no;
  private String gender;
  private Date dob;

  // getters / setters…
  public int    getId()           { return id; }
  public void   setId(int id)     { this.id = id; }
  public String getFullName()     { return fullName; }
  public void   setFullName(String n) { this.fullName = n; }
  public String getEmail()        { return email; }
  public void   setEmail(String e){ this.email = e; }
  public String getPassword()     { return password; }
  public void   setPassword(String p){ this.password = p; }
 
  public String getGender()       { return gender; }
  public void   setGender(String g){ this.gender = g; }
  public Date   getDob()          { return dob; }
  public void   setDob(Date d)    { this.dob = d; }

    
}
