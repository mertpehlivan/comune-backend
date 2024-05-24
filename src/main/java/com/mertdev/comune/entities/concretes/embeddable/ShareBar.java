package com.mertdev.comune.entities.concretes.embeddable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ShareBar {
    private String shareBgColor;
    private String shareTextColor;
    private String shareButtonColor;
    private String shareButtonTextColor;
    private String shareBorderColor;
    private int shareBorderSize;
}