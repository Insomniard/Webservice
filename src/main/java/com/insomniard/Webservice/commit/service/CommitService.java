package com.insomniard.Webservice.commit.service;

import com.insomniard.Webservice.Account.domain.User;
import com.insomniard.Webservice.Account.domain.UserRepository;
import com.insomniard.Webservice.Board.Repository.BoardRepository;
import com.insomniard.Webservice.Board.dto.ReadDto;
import com.insomniard.Webservice.Board.dto.ReadListDto;
import com.insomniard.Webservice.Board.dto.RegistrationDto;
import com.insomniard.Webservice.Board.entity.Board;
import com.insomniard.Webservice.commit.dto.CommitReadDto;
import com.insomniard.Webservice.commit.dto.CommitRegistrationDto;
import com.insomniard.Webservice.commit.entity.Commit;
import com.insomniard.Webservice.commit.repository.CommitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Repository
public class CommitService {
    private final UserRepository userRepository;
    private final CommitRepository commitRepository;
    private final BoardRepository boardRepository;
    @Transactional
    public Long registration(CommitRegistrationDto commitRegistrationDto){
        return commitRepository.save(commitRegistrationDto.toEntity()).getCommitId();
    }
}
