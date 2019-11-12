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
public class PatientDTO {
    private long patientId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String emailAddress;
    private Date birthDate;
    private List<DoctorPatientDTO> doctors;
}