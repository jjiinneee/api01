package org.jjiinnee.api01.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jjiinnee.api01.controller.APIUserController;
import org.jjiinnee.api01.domain.APIUser;
import org.jjiinnee.api01.dto.APITokenDTO;
import org.jjiinnee.api01.dto.APIUserDTO;
import org.jjiinnee.api01.repository.APIUserRepository;
import org.jjiinnee.api01.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class APITokenServiceImpl implements APITokenService {
  
  private final JWTUtil jwtUtil;
  private final APIUserRepository apiUserRepository;
  
  @Override
  public APITokenDTO makeTokens(String mid,String mpw){
  
    Optional<APIUser> result = apiUserRepository.findAPIUserByMidAndMpw(mid, mpw);
    
    APIUser apiUser = result.orElseThrow(()-> new APIUserController.APIUserNotFoundException());
  
    Map<String, Object> claim = Map.of("mid",mid);
    
    //유효기간 10분
    String accessToken = jwtUtil.generateToken(claim,10);
    //유효기간 60분
    String refreshToken = jwtUtil.generateToken(claim,60);
    
    APITokenDTO apiTokenDTO = APITokenDTO.builder()
                              .mid(mid)
                              .access(accessToken)
                              .refresh(refreshToken)
                              .build();
    
    
    return apiTokenDTO;
  }
}
