package com.shymoniak.hospital.service;

import com.shymoniak.hospital.domain.DoctorDTO;

import java.util.List;

public interface DoctorService {

    void addDoctor(DoctorDTO doctorDTO);
    void deleteDoctor(Long id);
    DoctorDTO getDoctorById(Long id);
    DoctorDTO getDoctorByEmail(String email);
    List<DoctorDTO> showAllDoctors();
}
