package com.shymoniak.hospital.controller;

import com.shymoniak.hospital.domain.FeedbackDTO;
import com.shymoniak.hospital.service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Для відгуків за логікою програми поовинні виконуватись наступні функції
 * - Get all feedbacks by doctor            для списку відгуків посортованим по лікарю
 * - Get doctor by ID                       для отримання відгука за ID
 * - Add doctor                             для можливості додати новий відгук
 */
@RestController
@RequestMapping("feedback")
@AllArgsConstructor
public class FeedbackController {
    private FeedbackService feedbackService;

    @GetMapping({"", "/"})
    public ResponseEntity<List<FeedbackDTO>> showAllFeedbacks(){
        return new ResponseEntity<>(feedbackService.showAllFeedbacks(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<FeedbackDTO> findFeedbackrById(@PathVariable ("id") Long id){
        return new ResponseEntity<>(feedbackService.getFeedbackById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addFeeedback(@RequestBody FeedbackDTO feedbackDTO) {
        feedbackService.addFeedback(feedbackDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
