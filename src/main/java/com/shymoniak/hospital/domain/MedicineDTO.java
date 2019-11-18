package com.shymoniak.hospital.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private List<DiagnosisMedicineDTO> diagnoses;
}
