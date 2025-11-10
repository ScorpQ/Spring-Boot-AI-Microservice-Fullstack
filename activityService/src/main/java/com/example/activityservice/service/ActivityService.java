package com.example.activityservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.activityservice.controller.ActivityResponse;
import com.example.activityservice.dto.ActivityRequest;
import com.example.activityservice.model.Activity;
import com.example.activityservice.repository.ActivityRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service    
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public ActivityResponse trackActivity(ActivityRequest activity) {
        Activity activityEntity = new Activity();
        activityEntity.setUserId(activity.getUserId());
        activityEntity.setType(activity.getType());
        activityEntity.setDuration(activity.getDuration());
        activityEntity.setCaloriesBurned(activity.getCaloriesBurned());
        activityEntity.setStartTime(activity.getStartTime());
        activityEntity.setAdditionalMetrics(activity.getAdditionalMetrics());
        return new ActivityResponse(activityRepository.save(activityEntity));
    }
    
    public List<ActivityResponse> getUserActivities(String userId) {
        List<Activity> activities = activityRepository.findByUserId(userId);
        return activities.stream()
            .map(ActivityResponse::new)
            .collect(Collectors.toList());
    }
}
