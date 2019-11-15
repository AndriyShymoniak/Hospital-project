package com.shymoniak.hospital.repository;

import com.shymoniak.hospital.entity.Doctor;
import com.shymoniak.hospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
//    List<Patient> getAllByDoctorId(Long id);
}
