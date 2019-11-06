package com.shymoniak.hospital.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
    private int id;
    private int price;
    private String name;
    private String description;
    private List<Medicine> analogMedicineId = new ArrayList<>();
}
