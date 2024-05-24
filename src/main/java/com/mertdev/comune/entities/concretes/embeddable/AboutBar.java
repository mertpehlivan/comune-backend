package com.mertdev.comune.entities.concretes.embeddable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AboutBar {
    private String aboutBgColor;
    private String aboutTextColor;
    private int aboutBorderSize;
    private String aboutBorderColor;
}