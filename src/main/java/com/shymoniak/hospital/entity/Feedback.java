package com.shymoniak.hospital.entity;

import com.shymoniak.hospital.entity.enums.FeedbackQuality;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id", nullable = false)
    private Long feedbackId;

    @Column(name = "feedback_comment")
    private String comment;

    @Column(name = "feedback_date")
    private Date date;

//    @Column(name = "quality", length = 20)
//    private FeedbackQuality quality;
}
