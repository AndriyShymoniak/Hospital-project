package com.shymoniak.hospital.service;

import com.shymoniak.hospital.domain.DiagnosisDTO;

import java.util.List;

public interface DiagnosisService {

    void addDiagnosis(DiagnosisDTO diagnosisDTO);
    void changeDiagnosis(DiagnosisDTO diagnosisDTO);
    List<DiagnosisDTO> showAllDiagnosis();
    List<DiagnosisDTO> showAllDiagnosisByDoctorId(Long id);
    List<DiagnosisDTO> showAllDiagnosisByPatientId(Long id);
    void deleteDiagnosis(Long id);
    DiagnosisDTO getDiagnosisById(Long id);
}
