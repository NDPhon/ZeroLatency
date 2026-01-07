package com.zerolatency.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zerolatency.backend.model.UserWebsite;

@Repository
public interface websiteJpaRepo extends JpaRepository<UserWebsite, Long> {
    UserWebsite findByUser_UserId(Long userId);   
}
