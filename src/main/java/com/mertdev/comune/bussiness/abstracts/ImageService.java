package com.mertdev.comune.bussiness.abstracts;

import com.mertdev.comune.entities.concretes.Image;

public interface ImageService {
    public void create(Image image);

    public Image findByFilename(String filename);
}
