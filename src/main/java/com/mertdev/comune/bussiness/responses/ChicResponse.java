package com.mertdev.comune.bussiness.responses;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
public class ChicResponse {
    private Long id;
    private List<UUID> whoVoting;
    private Integer count;
    private String content;
}
