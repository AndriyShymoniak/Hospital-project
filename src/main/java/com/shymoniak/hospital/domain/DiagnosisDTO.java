package com.shymoniak.hospital.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private DoctorDTO doctor;
    @JsonIgnore
    private PatientDTO patient;
    private FeedbackDTO feedback;
    private List<MedicineDTO> medicines;
}
