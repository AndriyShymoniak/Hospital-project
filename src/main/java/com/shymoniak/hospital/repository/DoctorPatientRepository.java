package com.shymoniak.hospital.repository;
import com.shymoniak.hospital.entity.DoctorPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorPatientRepository extends JpaRepository<DoctorPatient, Long> {
}
