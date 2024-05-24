package com.mertdev.comune.bussiness.responses;


import lombok.*;
import java.util.UUID;

@Builder
@Getter
public class CreatedUserResponse {
    private UUID id;
    private String token;
    private String firstname;
    private String lastname;
    private String email;
    private String location;
    private String profileImage;
}
