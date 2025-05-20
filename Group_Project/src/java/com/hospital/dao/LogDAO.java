/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.dao;

/**
 *
 * @author 
 */
import com.hospital.model.LogEntry;
import java.util.List;

/**
 * DAO interface for user and doctor log entries.
 */
public interface LogDAO {
    List<LogEntry> findAllUserLogs();
    List<LogEntry> findAllDoctorLogs();
    void save(LogEntry entry);

    public List<LogEntry> findAll();
}
