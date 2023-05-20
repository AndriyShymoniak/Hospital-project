package com.shymoniak.hospital.controller;


import com.shymoniak.hospital.domain.DiagnosisDTO;
import com.shymoniak.hospital.service.DiagnosisService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
@AllArgsConstructor
public class DiagnosisController {
    private DiagnosisService diagnosisService;

    @GetMapping({"", "/"})
    public ResponseEntity<List<DiagnosisDTO>> showAllDiagnosis() {
        return new ResponseEntity<>(diagnosisService.showAllDiagnosis(), HttpStatus.OK);
    }

    @GetMapping("/docId/{docId}")
    ResponseEntity<List<DiagnosisDTO>> findDiagnosisByDoctorId(@PathVariable ("docId") Long docId){
        return new ResponseEntity<>(diagnosisService.showAllDiagnosisByDoctorId(docId), HttpStatus.OK);
    }

    @GetMapping("/patId/{patId}")
    ResponseEntity<List<DiagnosisDTO>> findDiagnosisByPatientId(@PathVariable ("patId") Long patId){
        return new ResponseEntity<>(diagnosisService.showAllDiagnosisByPatientId(patId), HttpStatus.OK);
    }

    @GetMapping("/dateFrom/{dateFrom}/dateTo/{dateTo}")
    ResponseEntity<List<DiagnosisDTO>> findDiagnosisByDateBetween(
            @PathVariable ("dateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date dateFrom,
            @PathVariable ("dateTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateTo){
        return new ResponseEntity<>(diagnosisService.showAllDiagnosisByDate(dateFrom, dateTo), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    ResponseEntity<DiagnosisDTO> findDiagnosisById(@PathVariable ("id") Long id){
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
}