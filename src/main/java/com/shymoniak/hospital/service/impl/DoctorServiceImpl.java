package com.shymoniak.hospital.service.impl;

import com.shymoniak.hospital.configuration.jwt.JWTTokenProvider;
import com.shymoniak.hospital.domain.DoctorDTO;
import com.shymoniak.hospital.entity.Doctor;
import com.shymoniak.hospital.entity.enums.UserRole;
import com.shymoniak.hospital.repository.DoctorRepository;
import com.shymoniak.hospital.service.DoctorService;
import com.shymoniak.hospital.service.utils.ObjectMapperUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private DoctorRepository doctorRepository;
    private ObjectMapperUtils modelMapper;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JWTTokenProvider jwtTokenProvider;

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
        return modelMapper.map(doctorRepository.findByEmailAddressEquals(email), DoctorDTO.class);
    }

    @Override
    public List<DoctorDTO> showAllDoctors() {
        List<DoctorDTO> doctorDTOList = modelMapper.mapAll(doctorRepository.findAll(), DoctorDTO.class);
        return doctorDTOList;
    }

    @Override
    public String signin(String email, String password) {
        System.out.println(">>> " + email);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        System.out.println(">>> " + email);

        return jwtTokenProvider.createToken(email, doctorRepository.findByEmailAddressEquals(email).getRole());
    }

}
