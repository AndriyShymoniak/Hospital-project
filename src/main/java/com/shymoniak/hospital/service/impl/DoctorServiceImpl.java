package com.shymoniak.hospital.service.impl;

import com.shymoniak.hospital.domain.DoctorDTO;
import com.shymoniak.hospital.entity.Doctor;
import com.shymoniak.hospital.entity.enums.UserRole;
import com.shymoniak.hospital.repository.DoctorRepository;
import com.shymoniak.hospital.service.DoctorService;
import com.shymoniak.hospital.service.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void addDoctor(DoctorDTO doctorDTO) {
        doctorDTO.setRole(UserRole.ROLE_USER_DOCTOR);
        System.out.println("Password = " + doctorDTO.getPassword());
        doctorDTO.setPassword(passwordEncoder.encode(doctorDTO.getPassword()));
        doctorRepository.save(modelMapper.map(doctorDTO, Doctor.class));
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public DoctorDTO getDoctorById(Long id) {
        return modelMapper.map(doctorRepository.getOne(id), DoctorDTO.class);
    }

    @Override
    public DoctorDTO getDoctorByEmail(String email) {
        return modelMapper.map(doctorRepository.findByEmailAddress(email), DoctorDTO.class);
    }

    @Override
    public List<DoctorDTO> showAllDoctors() {
        List<DoctorDTO> doctorDTOList = modelMapper.mapAll(doctorRepository.findAll(), DoctorDTO.class);
        return doctorDTOList;
    }

}
