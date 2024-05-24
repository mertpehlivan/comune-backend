package com.mertdev.comune.bussiness.responses;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GetImageResponse {
    private Long id;
    private String filename;

    private String mimeType;

    private byte[] data;

}
