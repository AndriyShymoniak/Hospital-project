package com.shymoniak.hospital.domain;

import com.shymoniak.hospital.entity.enums.FeedbackQuality;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDTO {
    private Long feedbackId;
    private String comment;
    private Date date;

    @Enumerated(EnumType.STRING)
    private FeedbackQuality quality;
}
