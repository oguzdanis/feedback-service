package com.track.feedback.service;


import com.track.feedback.dto.FeedbackRequest;
import com.track.feedback.dto.FeedbackResponse;
import com.track.feedback.entity.Feedback;
import com.track.feedback.mapper.FeedbackRequestToEntityMapper;
import com.track.feedback.mapper.FeedbackToResponseMapper;
import com.track.feedback.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final FeedbackRequestToEntityMapper requestMapper;
    private final FeedbackToResponseMapper responseMapper;

    public FeedbackService(FeedbackRepository feedbackRepository, FeedbackRequestToEntityMapper requestMapper, FeedbackToResponseMapper responseMapper) {
        this.feedbackRepository = feedbackRepository;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    public void submit(FeedbackRequest request, Long userId) {
        Feedback feedback = requestMapper.apply(request, userId);
        feedbackRepository.save(feedback);
    }

    public List<FeedbackResponse> getAll() {
        return feedbackRepository.findAll().stream()
                .map(responseMapper)
                .toList();
    }
}
