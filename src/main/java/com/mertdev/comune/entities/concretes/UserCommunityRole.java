package com.mertdev.comune.entities.concretes;

import com.mertdev.comune.entities.abstracts.CommunityRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Entity
    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class UserCommunityRole {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Enumerated(EnumType.STRING)
        private CommunityRole role;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToOne
        @JoinColumn(name = "community_id")
        private Community community;
    }
