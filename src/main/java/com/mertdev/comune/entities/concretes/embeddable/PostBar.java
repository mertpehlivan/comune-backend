package com.mertdev.comune.entities.concretes.embeddable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PostBar {
    private String postBgColor;
    private String postTextColor;
    private String postButtonColor;
    private String postButtonTextColor;
    private String postBorderColor;
    private int postBorderSize;
}