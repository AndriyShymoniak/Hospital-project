package com.shymoniak.hospital.controller;

import com.shymoniak.hospital.domain.DoctorDTO;
import com.shymoniak.hospital.domain.PatientDTO;
import com.shymoniak.hospital.domain.request.SigninRequest;
import com.shymoniak.hospital.domain.response.SigninResponse;
import com.shymoniak.hospital.service.DoctorService;
import com.shymoniak.hospital.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@AllArgsConstructor
public class AuthController {
    private PatientService patientService;
    private DoctorService doctorService;

    @PostMapping("signup")
    public ResponseEntity<Void> registerUser(@RequestBody PatientDTO dto) {
        patientService.addPatient(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("signup/doctor")
    public ResponseEntity<Void> registerDoctor(@RequestBody DoctorDTO dto) {
        doctorService.addDoctor(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("signin")
    public ResponseEntity<SigninResponse> signin(@RequestBody SigninRequest request) {
        String token = patientService.signin(request.getUsername(), request.getPassword());
        String role = "";
        Long id = patientService.findPatientByEmail(request.getUsername()).getPatientId();
        System.out.println(token + "\n" + request.getUsername() + "\n" + request.getPassword());

        if(token != null) {
            role = patientService.findPatientByEmail(request.getUsername()).getRole().toString();
            System.out.println("ROLE: " + role);
        }

        SigninResponse signinResponse = new SigninResponse(token, role, id);
        System.out.println(signinResponse.getId() + " " + signinResponse.getRole());
        return new ResponseEntity<>(signinResponse, HttpStatus.OK);
    }

    @PostMapping("signin/doctor")
    public ResponseEntity<SigninResponse> signinDoctor(@RequestBody SigninRequest request) {
        String token = doctorService.signin(request.getUsername(), request.getPassword());
        String role = "";
        Long id = doctorService.getDoctorByEmail(request.getUsername()).getDoctorId();
        System.out.println("id = " + id);
        System.out.println(token + "\n" + request.getUsername() + "\n" + request.getPassword() + "\n id = " + id);

        if(token != null) {
            role = doctorService.getDoctorByEmail(request.getUsername()).getRole().toString();
            System.out.println("ROLE: " + role);
        }

        SigninResponse signinResponse = new SigninResponse(token, role, id);
        System.out.println(signinResponse.getId() + " " + signinResponse.getRole());

        return new ResponseEntity<>(signinResponse, HttpStatus.OK);
    }
}

