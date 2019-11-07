package com.shymoniak.hospital.service.impl;

import com.shymoniak.hospital.domain.DiagnosisDTO;
import com.shymoniak.hospital.domain.DoctorDTO;
import com.shymoniak.hospital.entity.Diagnosis;
import com.shymoniak.hospital.entity.Doctor;
import com.shymoniak.hospital.repository.DiagnosisRepository;
import com.shymoniak.hospital.repository.DoctorRepository;
import com.shymoniak.hospital.service.DoctorService;
import com.shymoniak.hospital.service.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void addDoctor(DoctorDTO doctorDTO) {
        doctorRepository.save(modelMapper.map(doctorDTO, Doctor.class));
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public List<DoctorDTO> showAllDoctors() {
        List<Doctor> doctorList = doctorRepository.findAll();
        List<DoctorDTO> doctorDTOList = modelMapper.mapAll(doctorList, DoctorDTO.class);
        return doctorDTOList;
    }
}
