package com.shymoniak.hospital.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicineDTO {
    private long medicineId;
    private int price;
    private String name;
    private String description;
    private DiagnosisDTO diagnosis;
}
