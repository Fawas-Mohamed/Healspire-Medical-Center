package com.hospital.model;

import java.util.Date;
public class LogEntry {
    private int id;
    private int entityId; 
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
