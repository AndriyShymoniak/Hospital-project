package com.shymoniak.hospital.controller;

import com.shymoniak.hospital.domain.DoctorDTO;
import com.shymoniak.hospital.domain.PatientDTO;
import com.shymoniak.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Для лікарів за логікою програми поовинні виконуватись наступні функції
 * - Get all doctors                для списку лікарів
 * - Get doctor by ID               для отримання лікаря за ID
 * - Add doctor                     для можливості додати нового лікаря
 */
@RestController
@RequestMapping("doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping({"", "/"})
    ResponseEntity<List<DoctorDTO>> showAllDoctors(){
        return new ResponseEntity<>(doctorService.showAllDoctors(), HttpStatus.OK);
    }

//    @GetMapping("/docId/{docId}")
//    ResponseEntity<List<PatientDTO>> showAllPatientsByDoctorId(@PathVariable ("docId") Long id){
//        return new ResponseEntity<>(doctorService.showAllPatientsByDoctorId(id), HttpStatus.OK);
//    }

    @GetMapping("/id/{id}")
    ResponseEntity<DoctorDTO> findDoctorById(@PathVariable ("id") Long id){
        return new ResponseEntity<>(doctorService.getDoctorById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addDoctor(@RequestBody DoctorDTO doctorDTO) {
        doctorService.addDoctor(doctorDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{deleteId}")
    public ResponseEntity<Void> deleteDoctorById(@PathVariable ("deleteId") Long deleteId){
        doctorService.deleteDoctor(deleteId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}