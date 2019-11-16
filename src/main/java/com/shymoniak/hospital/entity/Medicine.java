package com.shymoniak.hospital.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "diagnosis_id")
    private Diagnosis diagnosis;

//    @OneToMany(
//            mappedBy = "diagnosis",
//            cascade = CascadeType.PERSIST,
//            orphanRemoval = true
//    )
//    private List<Medicine> analogMedicine = new ArrayList<>();

    public Long getMedicineId() {
        return medicineId;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getAnalogId() {
        return analogId;
    }

    @JsonBackReference
    public Diagnosis getDiagnosis() {
        return diagnosis;
    }
}
