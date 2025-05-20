/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospital.dao;

/**
 *
 * @author 
 */
import com.hospital.model.Invoice;
import java.util.List;

public interface InvoiceDAO {
  Invoice create(Invoice inv);
  List<Invoice> findByPatientId(int patientId);
  Invoice findById(int id);
}
