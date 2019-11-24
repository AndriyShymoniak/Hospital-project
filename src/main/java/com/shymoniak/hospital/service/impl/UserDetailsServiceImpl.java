package com.shymoniak.hospital.service.impl;

import com.shymoniak.hospital.entity.Patient;
import com.shymoniak.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PatientRepository patientRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Patient patient = patientRepository.findByEmailAddressEquals(email);
        if(patient == null) {
            throw new UsernameNotFoundException("User with email '" + email + "' not found");
        }

         return User
                .builder()
                    .username(patient.getEmailAddress())
                    .password(patient.getPassword())
                    .authorities(patient.getRole())
                .build();
    }
}

