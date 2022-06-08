package org.jjiinnee.api01.repository;


import lombok.extern.log4j.Log4j2;
import org.jjiinnee.api01.domain.APIUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class APIUserRepositoryTest {
  
  @Autowired
  APIUserRepository  apiUserRepository;
  
  @Test
  public void testInserts() {
    IntStream.rangeClosed(1,100).forEach(i -> {
      APIUser apiUser = APIUser.builder()
              .mid("apiuser"+i)
              .mpw("1111")
              .build();
      apiUserRepository.save(apiUser);
    });
    
    
  }
  
}
