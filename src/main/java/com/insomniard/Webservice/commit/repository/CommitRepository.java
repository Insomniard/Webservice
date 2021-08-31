package com.insomniard.Webservice.commit.repository;

import com.insomniard.Webservice.commit.entity.Commit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitRepository extends JpaRepository<Commit, Long> {

}
