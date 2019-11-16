package com.shymoniak.hospital.domain;

import com.shymoniak.hospital.entity.embeddableclasses.DoctorPatientId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorPatientDTO {
    private Long id;

    private PatientDTO patient;
    private DoctorDTO doctor;
}
