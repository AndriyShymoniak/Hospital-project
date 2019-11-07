package com.shymoniak.hospital.service;

import com.shymoniak.hospital.domain.DoctorDTO;

import java.util.List;

public interface DoctorService {

    void addDoctor(DoctorDTO doctorDTO);
    void deleteDoctor(Long id);
    List<DoctorDTO> showAllDoctors();
}
