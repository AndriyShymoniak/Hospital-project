package com.shymoniak.hospital.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicineDiagnosisDTO {
    private Long medicineDiagnosisId;

    @JsonIgnore
    private DiagnosisDTO diagnosis;

    private MedicineDTO medicine;
}
