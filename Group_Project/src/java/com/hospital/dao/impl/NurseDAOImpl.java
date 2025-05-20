/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.dao.impl;

/**
 *
 * @author 
 */
import com.hospital.dao.NurseDAO;
import com.hospital.model.Nurse;
import com.hospital.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class NurseDAOImpl implements NurseDAO {
  @Override
  public List<Nurse> findAll() {
    List<Nurse> L = new ArrayList<>();
    String sql = "SELECT id,name,email,specialization,created_at FROM nurses";
    try (Connection c=DBConnection.getConnection();
         Statement s=c.createStatement();
         ResultSet rs=s.executeQuery(sql)) {
      while(rs.next()) {
        Nurse n=new Nurse();
        n.setId(rs.getInt("id"));
        n.setName(rs.getString("name"));
        n.setEmail(rs.getString("email"));
        n.setSpecialization(rs.getString("specialization"));
        n.setCreatedAt(rs.getTimestamp("created_at"));
        L.add(n);
      }
    } catch(SQLException e){e.printStackTrace();}
    return L;
  }
  @Override
  public void save(Nurse n) {
    String sql="INSERT INTO nurses(name,email,password,specialization) VALUES(?,?,?,?)";
    try (Connection c=DBConnection.getConnection();
         PreparedStatement p=c.prepareStatement(sql)) {
      p.setString(1,n.getName());
      p.setString(2,n.getEmail());
      p.setString(3,n.getPassword());
      p.setString(4,n.getSpecialization());
      p.executeUpdate();
    } catch(SQLException e){e.printStackTrace();}
  }
  @Override
  public void deleteById(int id) {
    String sql="DELETE FROM nurses WHERE id=?";
    try (Connection c=DBConnection.getConnection();
         PreparedStatement p=c.prepareStatement(sql)) {
      p.setInt(1,id);
      p.executeUpdate();
    } catch(SQLException e){e.printStackTrace();}
  }
}