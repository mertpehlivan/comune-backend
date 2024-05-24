package com.mertdev.comune.entities.concretes.embeddable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CommunityBar {
    private String bgColor;
    private String textColor;
    private String joinButtonColor;
    private String joinButtonTextColor;
    private String borderColor;
    private int border;
}