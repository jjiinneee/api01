package org.jjiinnee.api01.service;

import lombok.RequiredArgsConstructor;
import org.jjiinnee.api01.domain.APIUser;
import org.jjiinnee.api01.dto.APIUserDTO;
import org.jjiinnee.api01.repository.APIUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class APIUserServiceImple implements APIUserService{
  
  
  private final APIUserRepository apiUserRepository;
  private final ModelMapper modelMapper;
  
  @Override
  public Optional<APIUserDTO> checkUser(String mid, String mpw){
    Optional<APIUser> result = apiUserRepository.findAPIUserByMidAndMpw(mid,mpw);
    
    if(result.isEmpty()){
      return Optional.empty();
    }
    
    return Optional.of(modelMapper.map(result.get(),APIUserDTO.class));
  }
}
