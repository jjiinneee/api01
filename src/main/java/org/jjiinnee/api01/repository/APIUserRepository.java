package org.jjiinnee.api01.repository;

import org.jjiinnee.api01.domain.APIUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface APIUserRepository extends JpaRepository<APIUser, String> {
  
  Optional<APIUser> findAPIUserByMidAndMpw(String mid, String mpw);
}
