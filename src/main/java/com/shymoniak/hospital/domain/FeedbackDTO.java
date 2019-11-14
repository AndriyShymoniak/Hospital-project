package com.shymoniak.hospital.domain;

import com.shymoniak.hospital.entity.enums.FeedbackQuality;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDTO {
    private Long feedbackId;
    private String comment;
    private Date date;
    // TODO: 07.11.2019
    //REMAKE!
//    private FeedbackQuality quality;
}
