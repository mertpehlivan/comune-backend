package com.mertdev.comune.entities.concretes;

import com.mertdev.comune.entities.abstracts.Publication;
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
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String filename;

    private String mimeType;

    private byte[] data;

    @ManyToOne()
    @JoinColumn(name = "publication_id")
    private Publication publication;

}
