package com.shymoniak.hospital.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shymoniak.hospital.entity.Medicine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicineDTO {
    private Long medicineId;
    private Long analogId;
    private int price;
    private String name;
    private String description;

    @JsonIgnore
    private DiagnosisDTO diagnosis;

    // TODO: 16.11.2019
//    @JsonIgnore
//    private List<MedicineDTO> analogMedicine;
}
