package com.example.activityservice.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import org.springframework.http.ResponseEntity;
import com.example.activityservice.dto.ActivityRequest;
import com.example.activityservice.service.ActivityService;
import java.util.List;


@RestController
@RequestMapping("/api/activities")
public class ActivityController {
    
    @Autowired
    private ActivityService activityService;
    
    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest activity) {
        return ResponseEntity.ok(activityService.trackActivity(activity));
    }
    
    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivities(@RequestHeader("X-User") String userId) {
        return ResponseEntity.ok(activityService.getUserActivities(userId));
    }
}
