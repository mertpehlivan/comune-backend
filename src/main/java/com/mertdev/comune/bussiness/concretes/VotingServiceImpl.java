package com.mertdev.comune.bussiness.concretes;

import com.mertdev.comune.bussiness.abstracts.AccountService;
import com.mertdev.comune.bussiness.abstracts.CommunityService;
import com.mertdev.comune.bussiness.responses.CreatedVotingResponse;
import com.mertdev.comune.bussiness.abstracts.VotingService;
import com.mertdev.comune.bussiness.requests.CreateVotingRequest;
import com.mertdev.comune.dataAccess.abstracts.ChicRepository;
import com.mertdev.comune.dataAccess.abstracts.VotingRepository;
import com.mertdev.comune.entities.concretes.Chic;
import com.mertdev.comune.mappers.VotingMappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class VotingServiceImpl implements VotingService {
    private final VotingRepository votingRepository;
    private final VotingMappers votingMappers;
    private final AccountService accountService;
    private final CommunityService communityService;
    private final ChicRepository chicRepository;
    @Override
    public CreatedVotingResponse create(CreateVotingRequest createVotingRequest) {
        try {
            log.info("Creating...");
            log.info("Community creating...: {}",createVotingRequest.getPrivacy());
            var voting = votingMappers.mapToVoting(createVotingRequest);
            voting.setAccount( accountService.getAccount());
            voting.setCommunity(communityService.findById(createVotingRequest.getCommunityId()));
            log.info("Community id: {}",createVotingRequest.getCommunityId());
            log.info("Community created: {}",createVotingRequest.getPrivacy());
            var saved = votingRepository.save(voting);
            List<Chic> chics = saved.getChicis();
            List<Chic> updatedChics = chics.stream()
                    .map(chic -> {
                        chic.setVoting(saved);
                        return chic;
                    })
                    .collect(Collectors.toList());
            chicRepository.saveAll(updatedChics);
            log.info("Created: {}",saved.getId());
            return votingMappers.maptoCreatedVotingResponse(saved);
        }catch (Exception e){
            throw e;
        }
    }
    @Override
    public void putChic(Long id){
        var user = accountService.getAccount();
        var chich = chicRepository.findById(id);
        chich.get().getWhoVoting().add(user.getId());
        chicRepository.save(chich.get());
    }
}
