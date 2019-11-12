package com.shymoniak.hospital.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
    private long doctorId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String speciality;
    private Date birthDate;

    private List<DoctorPatientDTO> patients;
}