package com.shymoniak.hospital.service.impl;

import com.shymoniak.hospital.entity.Doctor;
import com.shymoniak.hospital.entity.Patient;
import com.shymoniak.hospital.repository.DoctorRepository;
import com.shymoniak.hospital.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private PatientRepository patientRepository;
    private DoctorRepository doctorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Patient patient = patientRepository.findByEmailAddressEquals(email);
        Doctor doctor = doctorRepository.findByEmailAddressEquals(email);

        if(patient == null) {
            if (doctor == null){
                throw new UsernameNotFoundException("User with email '" + email + "' not found");
            } else {
                return User
                        .builder()
                        .username(doctor.getEmailAddress())
                        .password(doctor.getPassword())
                        .authorities(doctor.getRole())
                        .build();
            }
        }

         return User
                .builder()
                    .username(patient.getEmailAddress())
                    .password(patient.getPassword())
                    .authorities(patient.getRole())
                .build();
    }
}

