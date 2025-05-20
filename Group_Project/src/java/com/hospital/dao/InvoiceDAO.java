package com.hospital.dao;
import com.hospital.model.Invoice;
import java.util.List;

public interface InvoiceDAO {
  Invoice create(Invoice inv);
  List<Invoice> findByPatientId(int patientId);
  Invoice findById(int id);
}
