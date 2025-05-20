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
public class LogEntry {
    private int id;
    private int entityId;       // user_id or doctor_id
    private String action;
    private Date timestamp;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getEntityId() { return entityId; }
    public void setEntityId(int entityId) { this.entityId = entityId; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    public Date getTimestamp() { return timestamp; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
}