package com.shymoniak.hospital.controller;

import com.shymoniak.hospital.domain.DoctorDTO;
import com.shymoniak.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping({"", "/"})
    ResponseEntity<List<DoctorDTO>> showAllDoctors(){
        return new ResponseEntity<>(doctorService.showAllDoctors(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addDoctor(@RequestBody DoctorDTO doctorDTO) {
        doctorService.addDoctor(doctorDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}