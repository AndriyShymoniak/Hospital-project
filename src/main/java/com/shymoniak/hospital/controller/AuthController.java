package com.shymoniak.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

//    @Autowired
//    private UserService userService;
//
//    @PostMapping("signup")
//    public ResponseEntity<Void> registerUser(@RequestBody UserDTO dto) {
//        userService.save(dto);
//        return new ResponseEntity<Void>(HttpStatus.CREATED);
//    }
//
//    @PostMapping("signin")
//    public ResponseEntity<SigninResponse> signin(@RequestBody SigninRequest request) {
//        String token = userService.signin(request.getUsername(), request.getPassword());
//        String role = "";
//        System.out.println(token + "\n" + request.getUsername() + "\n" + request.getPassword());
//
//        if(token != null) {
//            role = userService.findByUsername(request.getUsername()).getRole().toString();
//            System.out.println("ROLE: " + role);
//        }
//
//        return new ResponseEntity<>(new SigninResponse(token, role), HttpStatus.OK);
//    }

}

