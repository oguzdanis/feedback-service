package com.track.feedback.mapper;

import com.track.feedback.dto.FeedbackResponse;
import com.track.feedback.entity.Feedback;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class FeedbackToResponseMapper implements Function<Feedback, FeedbackResponse> {

    @Override
    public FeedbackResponse apply(Feedback f) {
        FeedbackResponse feedbackResponse = new FeedbackResponse();
        feedbackResponse.setUserId(f.getUserId());
        feedbackResponse.setContent(f.getContent());
        feedbackResponse.setCreatedAt(f.getCreatedAt());
        feedbackResponse.setUserId(f.getUserId());
        return feedbackResponse;
    }
}
