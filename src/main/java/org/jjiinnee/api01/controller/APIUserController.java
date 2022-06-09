package org.jjiinnee.api01.controller;


import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jjiinnee.api01.dto.APITokenDTO;
import org.jjiinnee.api01.dto.APIUserDTO;
import org.jjiinnee.api01.service.APITokenService;
import org.jjiinnee.api01.service.APIUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Log4j2
public class APIUserController {
  
  //private final APIUserService apiUserService;
  private final APITokenService apiTokenService;
  public static class APIUserNotFoundException extends RuntimeException{
  
  }
  
//  @ApiOperation("Generate Tokens with POST")
//  @PostMapping("/generateToken")
//  public Map<String, String> generationToken(@RequestBody APIUserDTO apiUserDTO){
//
//   Optional<APIUserDTO> result =  apiUserService.checkUser(apiUserDTO.getMid(), apiUserDTO.getMpw());
//
//   if(result.isEmpty()){
//     throw  new APIUserNotFoundException();
//   }
//
//   return Map.of("ACCESS", "1111", "REFRESH","2222");
//
//  }
  
  @ApiOperation("Generate Tokens with POST")
  @PostMapping("/generateToken")
  public APITokenDTO generationToken(@RequestBody APIUserDTO apiUserDTO){
    return apiTokenService.makeTokens(apiUserDTO.getMid(), apiUserDTO.getMpw());
  }
}
