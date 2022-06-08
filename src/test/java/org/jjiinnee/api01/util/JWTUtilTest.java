package org.jjiinnee.api01.util;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
@Log4j2
public class JWTUtilTest {
  
  @Autowired
  private JWTUtil jwtUtil;
  
  @Test
  public void testGenerateToken(){
    Map<String,Object> claimMap =  Map.of("mid","ABCD");
    String jwtStr = jwtUtil.generateToken(claimMap,1);
    log.info(jwtStr);
  }
  
  @Test
  public void testValidate(){
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NTQ2NjA1NzgsIm1pZCI6IkFCQ0QiLCJpYXQiOjE2NTQ2NjA1MTh9.EVxFtSeOAUNIrWN8sudTOcbHsW4NGCCF6MgcNQfDjeA";
    
    jwtUtil.validateToken(token);
    
  }
}
