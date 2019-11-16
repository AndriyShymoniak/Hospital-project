package com.shymoniak.hospital.repository;

import com.shymoniak.hospital.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
//    List<Medicine> findAllByAnalogMedicineEquals(Long diagnosisId);
//    List<Medicine> findAllByAnalogMedicineIs(Long diagnosisId);
//    List<Medicine> findAllByAnalogMedicine(Long diagnosisId);
    List<Medicine> findAllByDiagnosisDiagnosisId(Long diagnosisId);
    List<Medicine> findAllByAnalogId(Long analogId);

}
