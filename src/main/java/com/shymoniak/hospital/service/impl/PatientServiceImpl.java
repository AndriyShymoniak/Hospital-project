package com.shymoniak.hospital.service.impl;

import com.shymoniak.hospital.configuration.jwt.JWTTokenProvider;
import com.shymoniak.hospital.domain.PatientDTO;
import com.shymoniak.hospital.entity.Patient;
import com.shymoniak.hospital.entity.enums.UserRole;
import com.shymoniak.hospital.repository.PatientRepository;
import com.shymoniak.hospital.service.PatientService;
import com.shymoniak.hospital.service.utils.ObjectMapperUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;
    private ObjectMapperUtils modelMapper;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JWTTokenProvider jwtTokenProvider;

    @Override
    public void addPatient(PatientDTO patientDTO) {
        patientDTO.setRole(UserRole.ROLE_USER_PATIENT);
        System.out.println("Password = " + patientDTO.getPassword());
        patientDTO.setPassword(passwordEncoder.encode(patientDTO.getPassword()));
        System.out.println("Password hashed = " + patientDTO.getPassword());
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
        return modelMapper.map(patientRepository.findByEmailAddressEquals(email), PatientDTO.class);
    }

    @Override
    public String signin(String email, String password) {
        System.out.println(">>> " + email);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        System.out.println(">>> " + email);

        return jwtTokenProvider.createToken(email, patientRepository.findByEmailAddressEquals(email).getRole());
    }
}
