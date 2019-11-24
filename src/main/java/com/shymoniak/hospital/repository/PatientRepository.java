package com.shymoniak.hospital.repository;

import com.shymoniak.hospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findAllByLastNameIgnoreCaseContaining(String lastName);
    Patient findByEmailAddressEquals(String email);
}
