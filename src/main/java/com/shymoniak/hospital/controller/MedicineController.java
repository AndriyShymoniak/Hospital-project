package com.shymoniak.hospital.controller;

import com.shymoniak.hospital.domain.MedicineDTO;
import com.shymoniak.hospital.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicine")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @GetMapping({"", "/"})
    ResponseEntity<List<MedicineDTO>> showAllMedicines(){
        return new ResponseEntity<>(medicineService.showAllMedicines(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addMedicine(@RequestBody MedicineDTO medicineDTO) {
        medicineService.addMedicine(medicineDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
