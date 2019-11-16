package com.shymoniak.hospital.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id", nullable = false)
    private Long doctorId;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "middle_name", nullable = false, length = 30)
    private String middleName;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Column(name = "phone_number", length = 13)
    private String phoneNumber;

    @Column(name = "email_address", length = 100)
    private String emailAddress;

    @Column(name = "speciality", nullable = false, length = 100)
    private String speciality;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.PERSIST,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
//    @JsonIgnoreProperties("patient")
//    @JsonBackReference
//    @JsonManagedReference
    private List<DoctorPatient> patients = new ArrayList<>();


    public Long getDoctorId() {
        return doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getSpeciality() {
        return speciality;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @JsonManagedReference
    public List<DoctorPatient> getPatients() {
        return patients;
    }
}
