package org.jjiinnee.api01.service;

import io.jsonwebtoken.JwtException;
import org.jjiinnee.api01.dto.APITokenDTO;

public interface APITokenService {
  
  APITokenDTO makeTokens(String mid, String mpw);
  
  
  APITokenDTO refreshTokens(String refreshToken) throws JwtException;
}
