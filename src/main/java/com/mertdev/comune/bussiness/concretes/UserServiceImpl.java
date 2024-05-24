package com.mertdev.comune.bussiness.concretes;

import com.mertdev.comune.Exceptions.UnavailableEmailException;
import com.mertdev.comune.Exceptions.AccountNotFoundException;
import com.mertdev.comune.bussiness.abstracts.BannerImageService;
import com.mertdev.comune.bussiness.abstracts.ProfileImageService;
import com.mertdev.comune.bussiness.abstracts.UserService;
import com.mertdev.comune.bussiness.requests.CreateUserRequest;
import com.mertdev.comune.bussiness.responses.CreatedUserResponse;
import com.mertdev.comune.bussiness.responses.GetUserResponse;
import com.mertdev.comune.dataAccess.abstracts.BannerImageRepository;
import com.mertdev.comune.dataAccess.abstracts.ProfileImageRepository;
import com.mertdev.comune.dataAccess.abstracts.UserRepository;
import com.mertdev.comune.entities.concretes.BannerImage;
import com.mertdev.comune.entities.concretes.ProfileImage;
import com.mertdev.comune.entities.concretes.User;
import com.mertdev.comune.mappers.ImageMappers;
import com.mertdev.comune.mappers.UserMappers;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMappers userMappers;
    private final UserRepository userRepository;
    private final ProfileImageService profileImageService;
    private final BannerImageService bannerImageService;
    private final ImageMappers imageMappers;

    @Override
    public CreatedUserResponse create(CreateUserRequest createUserRequest) {
        try {
            var user = userRepository.save(
                    userMappers.toUser(createUserRequest)
            );
            profileImageService.create(
                    imageMappers.mapToProfileImage(
                            createUserRequest.getProfileImage(),user
                    )
            );
            bannerImageService.create(
                    imageMappers.mapToBannerImage(
                            createUserRequest.getBannerImage(),user
                    )
            );
            return userMappers.toCreatedResponse(user);
        }catch (DataIntegrityViolationException | IOException exception){
            throw new UnavailableEmailException("Email is already in use");
        }

    }

    @Override
    public boolean existUser(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public GetUserResponse get(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<GetUserResponse> search(UUID id) {
        return null;
    }

    @Override
    public GetUserResponse findUserByEmail(String email) {
        try {
            var user = userRepository.findByEmail(email)
                    .orElseThrow(()->new AccountNotFoundException("User not found"));
            return userMappers.toGetUserResponse(user);
        }catch (AccountNotFoundException accountNotFoundException){
            throw new AccountNotFoundException("User not found", accountNotFoundException);
        }catch (Exception exception){
            throw new RuntimeException("An unexpected error occurred", exception);
        }

    }

    @Override
    public User findUserByEmailToUser(String email) {

            var user = userRepository.findByEmail(email);
            if (user.isPresent()){
                return user.get();
            }else {
                return null;
            }

    }
}
