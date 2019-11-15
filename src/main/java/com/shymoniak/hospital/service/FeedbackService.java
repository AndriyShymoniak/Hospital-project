package com.shymoniak.hospital.service;

import com.shymoniak.hospital.domain.FeedbackDTO;

import java.util.List;

public interface FeedbackService {
    void addFeedback(FeedbackDTO feedbackDTO);
    List<FeedbackDTO> showAllFeedbacks();
    FeedbackDTO getFeedbackById(Long id);
}
