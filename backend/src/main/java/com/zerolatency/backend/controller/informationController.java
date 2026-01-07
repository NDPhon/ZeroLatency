package com.zerolatency.backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zerolatency.backend.dto.ResponseFormat;
import com.zerolatency.backend.model.UserDestination;
import com.zerolatency.backend.model.UserProfile;
import com.zerolatency.backend.model.UserWebsite;
import com.zerolatency.backend.service.informationService;

@RestController
@RequestMapping(
    "/api/information"
)
public class informationController {
    @Autowired informationService infoService;

    @GetMapping(
        "/get-profile/{userId}"
    )
    public ResponseEntity<ResponseFormat> getProfileByUserId(@PathVariable("userId") Long userId) {
        Optional<UserProfile> profileOpt = infoService.getProfileByUserId(userId);
        if (profileOpt.isPresent()) {
            ResponseFormat response = new ResponseFormat(200L, "Success", profileOpt.get());
            return ResponseEntity.ok(response);
        } else {
            ResponseFormat response = new ResponseFormat(404L, "Profile not found", null);
            return ResponseEntity.status(404).body(response);
        }
    }

    @GetMapping(
        "/get-destination/{userId}"
    )
    public ResponseEntity<ResponseFormat> getDestinationByUserId(@PathVariable("userId") Long userId) {
        Optional<UserDestination> destinationOpt = infoService.getDestinationByUserId(userId);
        if (destinationOpt.isPresent()) {
            ResponseFormat response = new ResponseFormat(200L, "Success", destinationOpt.get());
            return ResponseEntity.ok(response);
        } else {
            ResponseFormat response = new ResponseFormat(404L, "Destination not found", null);
            return ResponseEntity.status(404).body(response);
        }
    }

    @GetMapping(
        "/get-website/{userId}"
    )
    public ResponseEntity<ResponseFormat> getWebsiteByUserId(@PathVariable("userId") Long userId) {
        Optional<UserWebsite> websiteOpt = infoService.getWebsiteByUserId(userId);
        if (websiteOpt.isPresent()) {
            ResponseFormat response = new ResponseFormat(200L, "Success", websiteOpt.get());
            return ResponseEntity.ok(response);
        } else {
            ResponseFormat response = new ResponseFormat(404L, "Website not found", null);
            return ResponseEntity.status(404).body(response);
        }
    }

    @GetMapping(
        "/get-full-info/{userId}"
    )
    public ResponseEntity<ResponseFormat> getFullInfoByUserId(@PathVariable("userId") Long userId) {
        Optional<?> fullInfoOpt = infoService.getFullInfoByUserId(userId);
        if (fullInfoOpt.isPresent()) {
            ResponseFormat response = new ResponseFormat(200L, "Success", fullInfoOpt.get());
            return ResponseEntity.ok(response);
        } else {
            ResponseFormat response = new ResponseFormat(404L, "No information found", null);
            return ResponseEntity.status(404).body(response);
        }
    }
}
