package com.shymoniak.hospital.controller;


import com.shymoniak.hospital.domain.DiagnosisDTO;
import com.shymoniak.hospital.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("diagnosis")
public class DiagnosisController {
    @Autowired
    private DiagnosisService diagnosisService;

    @GetMapping({"", "/"})
    public ResponseEntity<List<DiagnosisDTO>> showAllDiagnosis() {
        return new ResponseEntity<>(diagnosisService.showAllDiagnosis(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addDiagnosis(@RequestBody DiagnosisDTO diagnosisDTO) {
        diagnosisService.addDiagnosis(diagnosisDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
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