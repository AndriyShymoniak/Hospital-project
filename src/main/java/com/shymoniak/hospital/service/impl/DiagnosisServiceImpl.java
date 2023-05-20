package com.shymoniak.hospital.service.impl;

import com.shymoniak.hospital.domain.DiagnosisDTO;
import com.shymoniak.hospital.entity.Diagnosis;
import com.shymoniak.hospital.repository.DiagnosisRepository;
import com.shymoniak.hospital.service.DiagnosisService;
import com.shymoniak.hospital.service.utils.ObjectMapperUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class DiagnosisServiceImpl implements DiagnosisService {
    private DiagnosisRepository diagnosisRepository;
    private ObjectMapperUtils modelMapper;

    @Override
    public void addDiagnosis(DiagnosisDTO diagnosisDTO) {
        diagnosisRepository.save(modelMapper.map(diagnosisDTO, Diagnosis.class));
    }

    @Override
    public void changeDiagnosis(DiagnosisDTO diagnosisDTO) {
        diagnosisRepository.save(modelMapper.map(diagnosisDTO, Diagnosis.class));
    }

    @Override
    public void deleteDiagnosis(Long id) {
        diagnosisRepository.deleteById(id);
    }

    @Override
    public DiagnosisDTO getDiagnosisById(Long id) {
        return modelMapper.map(diagnosisRepository.getOne(id), DiagnosisDTO.class);
    }

    @Override
    public List<DiagnosisDTO> showAllDiagnosis() {
        return modelMapper.mapAll(diagnosisRepository.findAll(), DiagnosisDTO.class);
    }

    @Override
    public List<DiagnosisDTO> showAllDiagnosisByDoctorId(Long id) {
        return modelMapper.mapAll(diagnosisRepository.findAllByDoctorDoctorId(id), DiagnosisDTO.class);
    }

    @Override
    public List<DiagnosisDTO> showAllDiagnosisByPatientId(Long id) {
        return modelMapper.mapAll(diagnosisRepository.findAllByPatientPatientId(id), DiagnosisDTO.class);
    }

    @Override
    public List<DiagnosisDTO> showAllDiagnosisByDate(Date dateFrom, Date dateTo) {
        return modelMapper.mapAll(diagnosisRepository.findByDiagnosisDateBetween(dateFrom, dateTo), DiagnosisDTO.class);
    }

}