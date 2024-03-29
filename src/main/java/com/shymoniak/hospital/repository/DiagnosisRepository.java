package com.shymoniak.hospital.repository;

import com.shymoniak.hospital.entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
    List<Diagnosis> findAllByDoctorDoctorId(Long id);
    List<Diagnosis> findAllByPatientPatientId(Long id);
    List<Diagnosis> findByDiagnosisDateBetween(Date dateFrom, Date dateTo);
}
