package com.shymoniak.hospital.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DoctorPatient {
    private int id;
    private String comment;
    private Patient patient;

    private Doctor doctor;
}
