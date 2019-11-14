package com.shymoniak.hospital.controller;

import com.shymoniak.hospital.domain.PatientDTO;
import com.shymoniak.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping({"", "/"})
    ResponseEntity<List<PatientDTO>> showAllPatients(){
        return new ResponseEntity<>(patientService.showAllPatients(), HttpStatus.OK);
    }

    @GetMapping("/lastName/{lastName}")
    ResponseEntity<List<PatientDTO>> showAllPatientsBySurname(@PathVariable ("lastName") String surname){
        return new ResponseEntity<>(patientService.showAllPatientsBySurname(surname), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    ResponseEntity<PatientDTO> findPatientById(@PathVariable ("id") Long id){
        return new ResponseEntity<>(patientService.findPatientById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addPatient(@RequestBody PatientDTO patientDTO) {
        patientService.addPatient(patientDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
