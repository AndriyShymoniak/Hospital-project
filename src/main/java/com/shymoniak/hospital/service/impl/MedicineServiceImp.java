package com.shymoniak.hospital.service.impl;

import com.shymoniak.hospital.domain.MedicineDTO;
import com.shymoniak.hospital.entity.Medicine;
import com.shymoniak.hospital.repository.MedicineRepository;
import com.shymoniak.hospital.service.MedicineService;
import com.shymoniak.hospital.service.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImp implements MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;


    @Override
    public void addMedicine(MedicineDTO medicineDTO) {
        medicineRepository.save(modelMapper.map(medicineDTO, Medicine.class));
    }

    @Override
    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }

    @Override
    public List<MedicineDTO> showAllMedicines() {
        List<MedicineDTO> medicineDTOList = modelMapper.mapAll(medicineRepository.findAll(), MedicineDTO.class);
        return medicineDTOList;
    }
}
