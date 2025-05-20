package com.hospital.dao;

import com.hospital.model.MedicalRecord;
import java.util.List;
public interface MedicalHistoryDAO {
    
    /**
     * Fetch all medical records for a given patient.
     * @param patientId the patient ID
     * @return list of medical records
     */
    List<MedicalRecord> findByPatientId(int patientId);

    /**
     * Save a new medical record entry.
     * @param record the record to save
     */
    void save(MedicalRecord record);

    /**
     * Update an existing medical record.
     * @param record the record with updated values
     */
    void update(MedicalRecord record);

    /**
     * Delete a medical record by its ID.
     * @param recordId the record ID
     */
    void delete(int recordId);
}
    

