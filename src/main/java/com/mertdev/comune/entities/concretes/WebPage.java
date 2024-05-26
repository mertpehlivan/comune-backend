package com.mertdev.comune.entities.concretes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "web_pages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "web_pages_0")
    private String webPages0;

    @Column(name = "alpha_two_code")
    private String alphaTwoCode;

    @Column(name = "domains_0")
    private String domains0;

    @Column(name = "domains_1")
    private String domains1;

    @Column(name = "state_province")
    private String stateProvince;

    @Column(name = "name")
    private String name;

    @Column(name = "web_pages_1")
    private String webPages1;

    @Column(name = "web_pages_2")
    private String webPages2;

    @Column(name = "domains_2")
    private String domains2;

    @Column(name = "web_pages_3")
    private String webPages3;

    @Column(name = "domains_3")
    private String domains3;

    @Column(name = "domains_4")
    private String domains4;

    @Column(name = "web_pages_4")
    private String webPages4;

    @Column(name = "web_pages_5")
    private String webPages5;

    @Column(name = "web_pages_6")
    private String webPages6;


}
