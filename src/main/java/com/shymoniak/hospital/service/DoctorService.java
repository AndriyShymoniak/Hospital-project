package com.shymoniak.hospital.service;

import com.shymoniak.hospital.domain.DoctorDTO;
import com.shymoniak.hospital.domain.PatientDTO;

import java.util.List;

public interface DoctorService {

    void addDoctor(DoctorDTO doctorDTO);
    void deleteDoctor(Long id);
    DoctorDTO getDoctorById(Long id);
    List<DoctorDTO> showAllDoctors();
//    List<PatientDTO> showAllPatientsByDoctorId(Long id);
}
