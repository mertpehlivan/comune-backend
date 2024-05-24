package com.mertdev.comune.bussiness.concretes;

import com.mertdev.comune.Exceptions.AccountNotFoundException;
import com.mertdev.comune.Exceptions.CommunityNotFound;
import com.mertdev.comune.bussiness.abstracts.AccountService;
import com.mertdev.comune.bussiness.abstracts.BannerImageService;
import com.mertdev.comune.bussiness.abstracts.CommunityService;
import com.mertdev.comune.bussiness.abstracts.ProfileImageService;
import com.mertdev.comune.bussiness.requests.CreateCommunityRequest;
import com.mertdev.comune.bussiness.requests.UpdateCommunityRequest;
import com.mertdev.comune.bussiness.responses.CreatedCommunityResponse;
import com.mertdev.comune.bussiness.responses.GetCommunityResponse;
import com.mertdev.comune.dataAccess.abstracts.CommunityRepository;
import com.mertdev.comune.entities.concretes.Community;
import com.mertdev.comune.mappers.CommunityMappers;
import com.mertdev.comune.mappers.ImageMappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {
    private final CommunityMappers communityMappers;
    private final CommunityRepository communityRepository;
    private final ProfileImageService profileImageService;
    private final BannerImageService bannerImageService;
    private final ImageMappers imageMappers;

    @Override
    public CreatedCommunityResponse create(CreateCommunityRequest createUserRequest) throws IOException {
            var community =communityRepository.save(communityMappers.mapToUser(createUserRequest)) ;

            profileImageService.create(
                    imageMappers.mapToProfileImage(
                            createUserRequest.getProfileImage(),community
                    )
            );
            bannerImageService.create(
                    imageMappers.mapToBannerImage(
                            createUserRequest.getBannerImage(),community
                    )
            );

            return communityMappers.mapToResponse(community);
    }

    @Override
    public boolean existCommunity(String email) {
        return communityRepository.existsByEmail(email);
    }

    @Override
    public GetCommunityResponse get(UUID id) {
        var community = communityRepository.findById(id).orElseThrow(()-> new CommunityNotFound("Community not found"));
        return communityMappers.mapToGetCommunityResponse(community);
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<GetCommunityResponse> search(UUID id) {
        return null;
    }

    @Override
    public GetCommunityResponse findCommunityByEmail(String email) {
        try {
            var community = communityRepository.findByEmail(email)
                    .orElseThrow(()->new AccountNotFoundException("Community not found"));
            return communityMappers.mapToGetCommunityResponse(community);
        }catch (AccountNotFoundException accountNotFoundException){
            throw new AccountNotFoundException("Community not found", accountNotFoundException);
        }catch (Exception exception){
            throw new RuntimeException("An unexpected error occurred", exception);
        }
    }

    @Override
    public Community findCommunityByEmailToCommunity(String email) {

            var community = communityRepository.findByEmail(email);
           return community.get();
    }

    @Override
    public Community findById(UUID id) {
        return communityRepository.findById(id).get();
    }

    @Override
    public Boolean existsCommunityMember(UUID userId, UUID communityId) {
        return null;
    }
    @Transactional
    @Override
    public void updateCommunitySettings(UpdateCommunityRequest updateCommunityRequest) throws IOException {
        Community community = communityRepository.findById(updateCommunityRequest.getId())
                .orElseThrow(() -> new IllegalArgumentException("Community not found with id: " + updateCommunityRequest.getId()));

        community.setPrivacy(updateCommunityRequest.getPrivacy());
        community.setCommunityShareRole(updateCommunityRequest.getCommunityShareRole());
        community.setAboutUs(updateCommunityRequest.getAboutUs());
        communityRepository.save(community);

        if (updateCommunityRequest.getProfileImage() != null && !updateCommunityRequest.getProfileImage().isEmpty()) {
            profileImageService.create(
                    imageMappers.mapToProfileImage(updateCommunityRequest.getProfileImage(), community)
            );
        }

        if (updateCommunityRequest.getBannerImage() != null && !updateCommunityRequest.getBannerImage().isEmpty()) {
            bannerImageService.create(
                    imageMappers.mapToBannerImage(updateCommunityRequest.getBannerImage(), community)
            );
        }
    }
}
