package com.shymoniak.hospital.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String mailAddress;
    private String speciality;
    private Date birthDate;
    private List<Patient> patient = new ArrayList<>();
}
