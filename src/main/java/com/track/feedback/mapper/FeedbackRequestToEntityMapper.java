package com.track.feedback.mapper;


import com.track.feedback.dto.FeedbackRequest;
import com.track.feedback.entity.Feedback;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.function.BiFunction;

@Component
public class FeedbackRequestToEntityMapper implements BiFunction<FeedbackRequest, Long, Feedback> {

    @Override
    public Feedback apply(FeedbackRequest request, Long userId) {
        Feedback feedback = new Feedback();
        feedback.setUserId(userId);
        feedback.setAnonymous(request.isAnonymous());
        feedback.setContent(request.getContent());
        feedback.setCreatedAt(LocalDateTime.now());


        return feedback;
    }
}
