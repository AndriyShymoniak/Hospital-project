package com.shymoniak.hospital.service;

import com.shymoniak.hospital.domain.DiagnosisDTO;

import java.util.List;

public interface DiagnosisService {

    void addDiagnosis(DiagnosisDTO diagnosisDTO);
    void changeDiagnosis(DiagnosisDTO diagnosisDTO);
    List<DiagnosisDTO> showAllDiagnosis();
    void deleteDiagnosis(Long id);
}
