package com.zerolatency.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_destination")
public class UserDestination {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "dest_id")
    private Long destId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, unique = true)
    private Users user;

    private String kindergarten;
    @Column(name = "primary_school")
    private String primarySchool;
    @Column(name = "middle_school")
    private String middleSchool;
    @Column(name = "high_school")
    private String highSchool;
    @Column(name = "college_university")
    private String collegeUniversity;
}
