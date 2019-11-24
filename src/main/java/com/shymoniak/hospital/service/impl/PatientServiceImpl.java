package com.shymoniak.hospital.service.impl;

import com.shymoniak.hospital.domain.PatientDTO;
import com.shymoniak.hospital.entity.Patient;
import com.shymoniak.hospital.entity.enums.UserRole;
import com.shymoniak.hospital.repository.PatientRepository;
import com.shymoniak.hospital.service.PatientService;
import com.shymoniak.hospital.service.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void addPatient(PatientDTO patientDTO) {
        patientDTO.setRole(UserRole.ROLE_USER_PATIENT);
        System.out.println("Password = " + patientDTO.getPassword());
        patientDTO.setPassword(passwordEncoder.encode(patientDTO.getPassword()));
        patientRepository.save(modelMapper.map(patientDTO, Patient.class));
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<PatientDTO> showAllPatients() {
        List<PatientDTO> patientDTOList = modelMapper.mapAll(patientRepository.findAll(), PatientDTO.class);
        return patientDTOList;
    }

    @Override
    public List<PatientDTO> showAllPatientsBySurname(String lastName) {
        List<PatientDTO> patientDTOList = modelMapper.mapAll(patientRepository.findAllByLastNameIgnoreCaseContaining(lastName), PatientDTO.class);
        return patientDTOList;
    }

    @Override
    public PatientDTO findPatientById(Long id) {
        return modelMapper.map(patientRepository.getOne(id), PatientDTO.class);
    }

    @Override
    public PatientDTO findPatientByEmail(String email) {
        return modelMapper.map(patientRepository.findByEmailAddress(email), PatientDTO.class);
    }
}
