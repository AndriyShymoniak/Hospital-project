package com.shymoniak.hospital.service;

import com.shymoniak.hospital.domain.PatientDTO;

import java.util.List;

public interface PatientService {

    void addPatient(PatientDTO patientDTO);
    void deletePatient(Long id);
    List<PatientDTO> showAllPatients();
}
