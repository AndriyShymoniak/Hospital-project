package com.shymoniak.hospital.controller;

import com.shymoniak.hospital.domain.FeedbackDTO;
import com.shymoniak.hospital.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping({"", "/"})
    ResponseEntity<List<FeedbackDTO>> showAllFeedbacks(){
        return new ResponseEntity<>(feedbackService.showAllFeedbacks(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addFeeedback(@RequestBody FeedbackDTO feedbackDTO) {
        feedbackService.addFeedback(feedbackDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
