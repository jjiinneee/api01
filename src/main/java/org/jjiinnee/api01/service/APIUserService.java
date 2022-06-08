package org.jjiinnee.api01.service;

import org.jjiinnee.api01.dto.APIUserDTO;

import java.util.Optional;

public interface APIUserService {
  
  Optional<APIUserDTO> checkUser(String mid, String mpw);
}
