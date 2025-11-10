package com.example.activityservice.controller;

import java.util.Map;

import com.example.activityservice.model.Activity;
import com.example.activityservice.model.ActivityType;

import lombok.Data;

@Data
public class ActivityResponse {

	public ActivityResponse(Activity activity) {
		this.id = activity.getId();
		this.userId = activity.getUserId();
		this.type = activity.getType();
		this.duration = activity.getDuration();
		this.caloriesBurned = activity.getCaloriesBurned();
		this.additionalMetrics = activity.getAdditionalMetrics();
	}

	private String id;
	private String userId;
	private ActivityType type;
	private Integer duration;
	private Integer caloriesBurned;
	private Map<String, Object> additionalMetrics;
}
