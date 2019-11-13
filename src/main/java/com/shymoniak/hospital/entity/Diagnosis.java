package com.shymoniak.hospital.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "diagnosis")
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diagnosis_id", nullable = false)
    private long diagnosisId;

    @Column(name = "diagnosis_name", nullable = false, length = 100)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "diagnosis_date", nullable = false)
    private Date diagnosisDate;


    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "diagnosis")
    private List<Medicine> medicines = new ArrayList<>();
}
