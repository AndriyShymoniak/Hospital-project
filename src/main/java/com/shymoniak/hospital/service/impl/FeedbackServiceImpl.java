package com.shymoniak.hospital.service.impl;

import com.shymoniak.hospital.domain.DiagnosisDTO;
import com.shymoniak.hospital.domain.DoctorDTO;
import com.shymoniak.hospital.domain.FeedbackDTO;
import com.shymoniak.hospital.entity.Diagnosis;
import com.shymoniak.hospital.entity.Feedback;
import com.shymoniak.hospital.repository.FeedbackRepository;
import com.shymoniak.hospital.service.FeedbackService;
import com.shymoniak.hospital.service.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void addFeedback(FeedbackDTO feedbackDTO) {
        feedbackRepository.save(modelMapper.map(feedbackDTO, Feedback.class));
    }

    @Override
    public List<FeedbackDTO> showAllFeedbacks() {
        List<Feedback> feedbackList = feedbackRepository.findAll();
        List<FeedbackDTO> feedbackDTOList = modelMapper.mapAll(feedbackList, FeedbackDTO.class);
        return feedbackDTOList;
    }
}
