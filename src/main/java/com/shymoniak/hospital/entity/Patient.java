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
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id", nullable = false)
    private Long patientId;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "middle_name", nullable = false, length = 30)
    private String middleName;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Column(name = "phone_number", length = 13)
    private String phoneNumber;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "email_address", length = 100)
    private String emailAddress;

    @Column(name = "birth_date")
    private Date birthDate;

    @OneToMany(
            mappedBy = "doctor",
            cascade = CascadeType.PERSIST,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
//    @JsonIgnoreProperties("doctor")
//    @JsonBackReference
//    @JsonManagedReference
    private List<DoctorPatient> doctors = new ArrayList<>();


    public Long getPatientId() {
        return patientId;
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

    public String getAddress() {
        return address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @JsonManagedReference
    public List<DoctorPatient> getDoctors() {
        return doctors;
    }
}