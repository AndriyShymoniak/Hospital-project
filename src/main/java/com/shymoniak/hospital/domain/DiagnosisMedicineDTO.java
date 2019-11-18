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
public class DiagnosisMedicineDTO {
    private Long diagnosisMedicineId;
    
    private MedicineDTO medicine;

    @JsonIgnore
    private DiagnosisDTO diagnosis;

}
