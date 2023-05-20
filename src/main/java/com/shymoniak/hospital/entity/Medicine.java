package com.shymoniak.hospital.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medicine")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id", nullable = false)
    private Long medicineId;

    @Column(name = "analog_id")
    private Long analogId;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "medicine_name", nullable = false, length = 30)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(
            mappedBy = "medicine",
            cascade = CascadeType.PERSIST,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<DiagnosisMedicine> diagnoses = new ArrayList<>();
}
