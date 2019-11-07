package com.shymoniak.hospital.entity;

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
    private long medicineId;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "medicine_name", nullable = false, length = 30)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "diagnosis_id")
    private Diagnosis diagnosis;

    /**
     * Цей список має видавати ліки аналоги
     */
    /*
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "medicine_id")
    private List<Medicine> analogMedicineId = new ArrayList<>();
    */
}
