package com.track.feedback.controller;

import com.track.feedback.dto.FeedbackRequest;
import com.track.feedback.dto.FeedbackResponse;
import com.track.feedback.service.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<Void> submitFeedback(@RequestBody FeedbackRequest request, Principal principal) {
        Long userId = Long.parseLong(principal.getName());
        feedbackService.submit(request, userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SUPERVISOR')")
    public ResponseEntity<List<FeedbackResponse>> listAllFeedback() {
        return ResponseEntity.ok(feedbackService.getAll());
    }
}
