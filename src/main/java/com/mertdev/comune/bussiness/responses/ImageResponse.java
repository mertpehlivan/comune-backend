package com.mertdev.comune.bussiness.responses;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ImageResponse {
    String src;
    String type;
}
