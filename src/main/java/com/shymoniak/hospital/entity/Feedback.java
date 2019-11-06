package com.shymoniak.hospital.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    private int id;
    private String comment;
    private Date date;
    private FeedbackQuality quality;
}
