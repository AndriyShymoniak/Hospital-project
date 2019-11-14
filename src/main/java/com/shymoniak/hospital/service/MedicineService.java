package com.shymoniak.hospital.service;

import com.shymoniak.hospital.domain.MedicineDTO;

import java.util.List;

public interface MedicineService {

    void addMedicine(MedicineDTO medicineDTO);
    void deleteMedicine(Long id);
    List<MedicineDTO> showAllMedicines();
    List<MedicineDTO> showAllAnalogMedicines(Long diagnosisId);
}
