package com.zerolatency.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerolatency.backend.dto.fullInfoResponse;
import com.zerolatency.backend.model.UserDestination;
import com.zerolatency.backend.model.UserProfile;
import com.zerolatency.backend.model.UserWebsite;
import com.zerolatency.backend.repo.destinationJpaRepo;
import com.zerolatency.backend.repo.profileJpaRepo;
import com.zerolatency.backend.repo.websiteJpaRepo;

@Service
public class informationService {
    @Autowired profileJpaRepo profileJpaRepo;
    @Autowired websiteJpaRepo websiteJpaRepo;
    @Autowired destinationJpaRepo destinationJpaRepo;

    public Optional<UserProfile> getProfileByUserId(Long userId) {
        return Optional.ofNullable(profileJpaRepo.findByUser_UserId(userId));
    }

    public Optional<UserWebsite> getWebsiteByUserId(Long userId) {
        return Optional.ofNullable(websiteJpaRepo.findByUser_UserId(userId));
    }

    public Optional<UserDestination> getDestinationByUserId(Long userId) {
        return Optional.ofNullable(destinationJpaRepo.findByUser_UserId(userId));
    }

    public Optional<fullInfoResponse> getFullInfoByUserId(Long userId) {
        Optional<UserProfile> profileOpt = getProfileByUserId(userId);
        Optional<UserWebsite> websiteOpt = getWebsiteByUserId(userId);
        Optional<UserDestination> destinationOpt = getDestinationByUserId(userId);

        if (profileOpt.isPresent() || websiteOpt.isPresent() || destinationOpt.isPresent()) {
            fullInfoResponse fullInfo = new fullInfoResponse();
            profileOpt.ifPresent(fullInfo::setProfile);
            websiteOpt.ifPresent(fullInfo::setWebsite);
            destinationOpt.ifPresent(fullInfo::setDestination);
            return Optional.of(fullInfo);
        }
        return Optional.empty();
    }
}
