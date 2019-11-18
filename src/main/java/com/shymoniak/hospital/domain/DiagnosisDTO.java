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
public class DiagnosisDTO {
    private Long diagnosisId;
    private String name;
    private String description;
    private Date diagnosisDate;

    private DoctorDTO doctor;
    private PatientDTO patient;
    private FeedbackDTO feedback;

    private List<DiagnosisMedicineDTO> medicines;
}
