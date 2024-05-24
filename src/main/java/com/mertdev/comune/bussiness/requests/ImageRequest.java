package com.mertdev.comune.bussiness.requests;

import com.mertdev.comune.entities.abstracts.AccountAbstract;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
public class ImageRequest {
    private String filename;
    private String mimeType;
    private byte[] data;
    private AccountAbstract account;
}
