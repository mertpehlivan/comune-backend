package com.mertdev.comune.entities.concretes;

import com.mertdev.comune.entities.abstracts.AccountAbstract;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ProfileImage{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filename;

    private String mimeType;

    private byte[] data;

    @OneToOne
    @JoinColumn(name = "account_id")
    private AccountAbstract account;


}