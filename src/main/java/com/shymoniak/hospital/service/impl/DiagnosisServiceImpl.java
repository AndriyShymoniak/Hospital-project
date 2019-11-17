package com.shymoniak.hospital.service.impl;

import com.shymoniak.hospital.domain.DiagnosisDTO;
import com.shymoniak.hospital.entity.Diagnosis;
import com.shymoniak.hospital.repository.DiagnosisRepository;
import com.shymoniak.hospital.service.DiagnosisService;
import com.shymoniak.hospital.service.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Autowired
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
        List<DiagnosisDTO> diagnosisDTOList = modelMapper.mapAll(diagnosisRepository.findAll(), DiagnosisDTO.class);
        return diagnosisDTOList;
    }

    @Override
    public List<DiagnosisDTO> showAllDiagnosisByDoctorId(Long id) {
        List<DiagnosisDTO> diagnosisDTOList = modelMapper.mapAll(diagnosisRepository.findAllByDoctorDoctorId(id), DiagnosisDTO.class);
        return diagnosisDTOList;
    }

    @Override
    public List<DiagnosisDTO> showAllDiagnosisByPatientId(Long id) {
        List<DiagnosisDTO> diagnosisDTOList = modelMapper.mapAll(diagnosisRepository.findAllByPatientPatientId(id), DiagnosisDTO.class);
        return diagnosisDTOList;
    }

}