package com.zerolatency.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zerolatency.backend.model.UserDestination;
import com.zerolatency.backend.model.Users;


@Repository
public interface destinationJpaRepo extends JpaRepository<UserDestination, Long> {
    UserDestination findByUser(Users user);
    UserDestination findByUser_UserId(Long userId);
}
