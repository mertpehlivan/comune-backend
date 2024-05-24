package com.mertdev.comune.bussiness.abstracts;

import com.mertdev.comune.bussiness.requests.CreateUserRequest;
import com.mertdev.comune.bussiness.requests.ExistsUserRequest;
import com.mertdev.comune.bussiness.responses.CreatedUserResponse;
import com.mertdev.comune.bussiness.responses.GetUserResponse;
import com.mertdev.comune.entities.concretes.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    public CreatedUserResponse create(CreateUserRequest createUserRequest);

    boolean existUser(String email);

    public GetUserResponse get(UUID id);
    public void delete(UUID id);
    public List<GetUserResponse> search(UUID id);

    public GetUserResponse findUserByEmail(String email);
    public User findUserByEmailToUser(String email);
}
