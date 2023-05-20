package com.shymoniak.hospital.service.impl;

import com.shymoniak.hospital.domain.MedicineDTO;
import com.shymoniak.hospital.entity.Medicine;
import com.shymoniak.hospital.repository.MedicineRepository;
import com.shymoniak.hospital.service.MedicineService;
import com.shymoniak.hospital.service.utils.ObjectMapperUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicineServiceImp implements MedicineService {
    private MedicineRepository medicineRepository;
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

    @Override
    public List<MedicineDTO> showAllAnalogMedicines(Long analogId) {
        List<MedicineDTO> medicineDTOList = modelMapper.mapAll(medicineRepository.findAllByAnalogId(analogId), MedicineDTO.class);
        return medicineDTOList;
    }

    @Override
    public MedicineDTO getMedicineById(Long id) {
        return modelMapper.map(medicineRepository.getOne(id), MedicineDTO.class);
    }

    @Override
    public MedicineDTO getDiagnosisById(Long id) {
        return modelMapper.map(medicineRepository.getOne(id), MedicineDTO.class);
    }
}
