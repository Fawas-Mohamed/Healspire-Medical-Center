/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.dao.impl;

/**
 *
 * @author 
 */
import com.hospital.dao.UserDAO;
import com.hospital.model.User;
import com.hospital.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.*;

public class UserDAOImpl implements UserDAO {

  
  private static final String URL = "jdbc:mysql://localhost:3306/hospital_db";
    private static final String USER = "root";
    private static final String PASS = "";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
    }
    @Override
    public User validateUser(String email, String password) {
           User user = null;
        try (Connection conn = DriverManager.getConnection(URL, USER,PASS)) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
               
                user.setemail(rs.getString("email"));
                
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

  @Override
    public Optional<User> findByUsernameAndPassword(String email, String password) {
        String sql = "SELECT id, fullname, email, role "
                   + "FROM users WHERE email=? AND password=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User u = mapRow(rs);
                    return Optional.of(u);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding by username/password", e);
        }
        return Optional.empty();
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users(fullname,email,password,role) VALUES(?,?,?,?)";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getFullname());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) user.setId(keys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error saving user", e);
        }
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT id, fullname, email, role FROM users ORDER BY id";
        List<User> list = new ArrayList<>();
        try (Connection c = DBConnection.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching all users", e);
        }
        return list;
    }

    @Override
    public void deleteById(int userId) {
        String sql = "DELETE FROM users WHERE id=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting user id=" + userId, e);
        }
    }

    @Override
    public void updatePassword(int userId, String newPassword) {
        String sql = "UPDATE users SET password=? WHERE id=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, newPassword);
            ps.setInt(2, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating password for user id=" + userId, e);
        }
    }
 private User mapRow(ResultSet rs) throws SQLException {
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setPassword(rs.getString("fullname"));
        u.setEmail(rs.getString("email"));
        u.setRole(rs.getString("role"));
        
        return u;
    }
}