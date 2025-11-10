package com.example.activityservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.activityservice.model.Activity;
import java.util.List;

@Repository
public interface ActivityRepository extends MongoRepository<Activity, String> {
    
    List<Activity> findByUserId(String userId);
    
    List<Activity> findByType(com.example.activityservice.model.ActivityType type);
    
    List<Activity> findByUserIdAndType(String userId, com.example.activityservice.model.ActivityType type);
    
}
