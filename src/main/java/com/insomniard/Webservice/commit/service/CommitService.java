package com.insomniard.Webservice.commit.service;

import com.insomniard.Webservice.Board.dto.RegistrationDto;
import com.insomniard.Webservice.commit.dto.CommitRegistrationDto;
import com.insomniard.Webservice.commit.repository.CommitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommitService {
    private final CommitRepository commitRepository;
    @Transactional
    public Long registration(CommitRegistrationDto commitRegistrationDto){
        return commitRepository.save(commitRegistrationDto.toEntity()).getCommitId();
    }
}
