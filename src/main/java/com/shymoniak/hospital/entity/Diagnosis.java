package com.shymoniak.hospital.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Diagnosis {
    private int id;
    private String name;
    private String description;
    private Date diagnosisDate;
    private Doctor doctor;
    private Patient patient;
    private Feedback feedback;
    private List<Medicine> medicines = new ArrayList<>();
}
