package com.hospital.dao;
import com.hospital.model.LogEntry;
import java.util.List;

public interface LogDAO {
    List<LogEntry> findAllUserLogs();
    List<LogEntry> findAllDoctorLogs();
    void save(LogEntry entry);

    public List<LogEntry> findAll();
}
