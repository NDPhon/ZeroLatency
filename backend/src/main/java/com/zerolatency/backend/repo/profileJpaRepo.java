package com.zerolatency.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zerolatency.backend.model.UserProfile;

@Repository
public interface profileJpaRepo extends JpaRepository<UserProfile, Long>{
    UserProfile findByUser_UserId(Long userId);
}
