package com.shymoniak.hospital.controller;


import com.shymoniak.hospital.domain.DiagnosisDTO;
import com.shymoniak.hospital.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Для діагнозів за логікою програми поовинні виконуватись наступні функції
 * - Get all diagnosis              для списку діагнозів
 * - Get all diagnosis by doctor    для списку діагнозів посортованих за лікарем
 * - Get all diagnosis by patient   для списку діагнозів посортованих за пацієнтом
 * - Get diagnosis by ID            для отримання діагнозу за ID
 * - Add diagnosis                  для можливості додати новий діагноз
 * - Change diagnosis               для можливості змінювати діагноз
 */
@RestController
@RequestMapping("diagnosis")
public class DiagnosisController {
    @Autowired
    private DiagnosisService diagnosisService;

    @GetMapping({"", "/"})
    public ResponseEntity<List<DiagnosisDTO>> showAllDiagnosis() {
        return new ResponseEntity<>(diagnosisService.showAllDiagnosis(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    ResponseEntity<DiagnosisDTO> findDoctorById(@PathVariable ("id") Long id){
        return new ResponseEntity<>(diagnosisService.getDiagnosisById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addDiagnosis(@RequestBody DiagnosisDTO diagnosisDTO) {
        diagnosisService.addDiagnosis(diagnosisDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Void> changeDiagnosis(@RequestBody DiagnosisDTO diagnosisDTO) {
        diagnosisService.changeDiagnosis(diagnosisDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

// TODO: 07.11.2019
//    @DeleteMapping("/del/{id}")
//    public ResponseEntity<Void> DeleteDiagnosisById(@PathVariable Long id) {
//        if (movieService.findMovieById(id) != null){
//            movieService.deleteMovieById(id);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}