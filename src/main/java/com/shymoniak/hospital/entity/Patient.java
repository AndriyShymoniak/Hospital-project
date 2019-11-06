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
public class Patient {
    private int id;
    private String name;
    private String surname;
    private String middleName;
    private String phoneNumber;
    private String address;
    private String mail;
    private Date birthDate;

    private List<Doctor> doctors = new ArrayList<>();
}