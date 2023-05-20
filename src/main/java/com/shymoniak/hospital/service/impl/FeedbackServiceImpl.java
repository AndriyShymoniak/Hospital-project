package com.shymoniak.hospital.service.impl;

import com.shymoniak.hospital.domain.FeedbackDTO;
import com.shymoniak.hospital.entity.Feedback;
import com.shymoniak.hospital.repository.FeedbackRepository;
import com.shymoniak.hospital.service.FeedbackService;
import com.shymoniak.hospital.service.utils.ObjectMapperUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {
    private FeedbackRepository feedbackRepository;
    private ObjectMapperUtils modelMapper;

    @Override
    public void addFeedback(FeedbackDTO feedbackDTO) {
        feedbackRepository.save(modelMapper.map(feedbackDTO, Feedback.class));
    }

    @Override
    public List<FeedbackDTO> showAllFeedbacks() {
        List<FeedbackDTO> feedbackDTOList = modelMapper.mapAll(feedbackRepository.findAll(), FeedbackDTO.class);
        return feedbackDTOList;
    }

    @Override
    public FeedbackDTO getFeedbackById(Long id) {
        return modelMapper.map(feedbackRepository.getOne(id), FeedbackDTO.class);
    }
}
