package com.shymoniak.hospital.controller;

import com.shymoniak.hospital.domain.MedicineDTO;
import com.shymoniak.hospital.service.MedicineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Для ліків за логікою програми поовинні виконуватись наступні функції
 * - Get all medicine                     для отримання списку ліків
 * - Get all analog medicine              для отримання списку ліків аналогів
 * - Get medicine by ID                   для отримання ліків за ID
 * - Add medicine                           для можливості додати нові ліки
 */
@RestController
@RequestMapping("medicine")
@AllArgsConstructor
public class MedicineController {
    private MedicineService medicineService;

    @GetMapping({"", "/"})
    public ResponseEntity<List<MedicineDTO>> showAllMedicines(){
        return new ResponseEntity<>(medicineService.showAllMedicines(), HttpStatus.OK);
    }

    @GetMapping("/analogId/{analogId}")
    public ResponseEntity<List<MedicineDTO>> showAllAnalogMedicines(@PathVariable ("analogId") Long analogId){
        return new ResponseEntity<>(medicineService.showAllAnalogMedicines(analogId), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<MedicineDTO> findMedicineById(@PathVariable ("id") Long id){
        return new ResponseEntity<>(medicineService.getMedicineById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addMedicine(@RequestBody MedicineDTO medicineDTO) {
        medicineService.addMedicine(medicineDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{deleteId}")
    public ResponseEntity<Void> deleteMedicineById(@PathVariable ("deleteId") Long deleteId){
        medicineService.deleteMedicine(deleteId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
