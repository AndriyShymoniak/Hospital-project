package com.shymoniak.hospital.entity;

import com.shymoniak.hospital.entity.embeddableclasses.DoctorPatientId;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctor_patient")
public class DoctorPatient {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "doctor_patient_id", nullable = false)
    private long doctorPatientId;

//    @EmbeddedId
//    private DoctorPatientId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
//    @MapsId("patientId")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
//    @MapsId("doctorId")
    private Doctor doctor;
}
