package com.shymoniak.hospital.service.impl;

import com.shymoniak.hospital.domain.PatientDTO;
import com.shymoniak.hospital.entity.Patient;
import com.shymoniak.hospital.repository.PatientRepository;
import com.shymoniak.hospital.service.PatientService;
import com.shymoniak.hospital.service.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void addPatient(PatientDTO patientDTO) {
        patientRepository.save(modelMapper.map(patientDTO, Patient.class));
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<PatientDTO> showAllPatients() {
        List<Patient> patientList = patientRepository.findAll();
        List<PatientDTO> patientDTOList = modelMapper.mapAll(patientList, PatientDTO.class);
        return patientDTOList;
    }
}
