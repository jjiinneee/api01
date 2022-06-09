package org.jjiinnee.api01.service;

import org.jjiinnee.api01.dto.APITokenDTO;

public interface APITokenService {
  
  APITokenDTO makeTokens(String mid, String mpw);
  
}
