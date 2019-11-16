package com.shymoniak.hospital.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.shymoniak.hospital.entity.embeddableclasses.DoctorPatientId;
import lombok.*;

import javax.persistence.*;

@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctor_patient")
public class DoctorPatient {
    @Id
    private Long doctorPatientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
//    @JsonIgnoreProperties("patients")
//    @JsonManagedReference
//    @JsonBackReference
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
//    @JsonIgnoreProperties("doctors")
//    @JsonManagedReference
//    @JsonBackReference
    private Doctor doctor;

    public Long getDoctorPatientId() {
        return doctorPatientId;
    }

    @JsonBackReference
    public Patient getPatient() {
        return patient;
    }

    @JsonBackReference
    public Doctor getDoctor() {
        return doctor;
    }
}
