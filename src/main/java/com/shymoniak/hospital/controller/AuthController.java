package com.shymoniak.hospital.controller;

import com.shymoniak.hospital.domain.PatientDTO;
import com.shymoniak.hospital.domain.request.SigninRequest;
import com.shymoniak.hospital.domain.response.SigninResponse;
import com.shymoniak.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private PatientService patientService;

    @PostMapping("signup")
    public ResponseEntity<Void> registerUser(@RequestBody PatientDTO dto) {
        patientService.addPatient(dto);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PostMapping("signin")
    public ResponseEntity<SigninResponse> signin(@RequestBody SigninRequest request) {
        String token = patientService.signin(request.getUsername(), request.getPassword());
        String role = "";
        System.out.println(token + "\n" + request.getUsername() + "\n" + request.getPassword());

        if(token != null) {
            role = patientService.findPatientByEmail(request.getUsername()).getRole().toString();
            System.out.println("ROLE: " + role);
        }

        return new ResponseEntity<>(new SigninResponse(token, role), HttpStatus.OK);
    }

}

