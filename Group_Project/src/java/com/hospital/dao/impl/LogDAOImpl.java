/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.dao.impl;

/**
 *
 * @author 
 */
import com.hospital.dao.LogDAO;
import com.hospital.model.LogEntry;
import com.hospital.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LogDAOImpl implements LogDAO {
    @Override
    public List<LogEntry> findAllUserLogs() {
        List<LogEntry> list = new ArrayList<>();
        String sql = "SELECT id, user_id, action, timestamp FROM user_logs ORDER BY timestamp DESC";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                LogEntry e = new LogEntry();
                e.setId(rs.getInt("id"));
                e.setEntityId(rs.getInt("user_id"));
                e.setAction(rs.getString("action"));
                e.setTimestamp(rs.getTimestamp("timestamp"));
                list.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public List<LogEntry> findAllDoctorLogs() {
        List<LogEntry> list = new ArrayList<>();
        String sql = "SELECT id, user_id AS username, action, timestamp FROM doctorslog ORDER BY timestamp DESC";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                LogEntry e = new LogEntry();
                e.setId(rs.getInt("id"));
                e.setEntityId(rs.getInt("username"));
                e.setAction(rs.getString("action"));
                e.setTimestamp(rs.getTimestamp("timestamp"));
                list.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(LogEntry entry) {
        String sql = "INSERT INTO userlog(user_id, action, timestamp) VALUES (?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, entry.getEntityId());
            pst.setString(2, entry.getAction());
            pst.setTimestamp(3, new Timestamp(entry.getTimestamp().getTime()));
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<LogEntry> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

