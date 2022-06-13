package org.jjiinnee.api01.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jjiinnee.api01.dto.PageRequestDTO;
import org.jjiinnee.api01.dto.PageResponseDTO;
import org.jjiinnee.api01.dto.TodoDTO;
import org.jjiinnee.api01.service.TodoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/guest/todo")
public class GuestTodoController {
  
  private final TodoService todoService;
  
  //  consumes : 어떤 데이터를 받을 것인가
//  producer : 반환하는 리턴타입의 종류
  @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
  public Map<String, Long> register(@RequestBody TodoDTO todoDTO){
    
    log.info(todoDTO);
    
    Long tno = todoService.register(todoDTO);
    
    return Map.of("tno", tno);
  }
  
  @GetMapping("/{tno}")
  public TodoDTO read(@PathVariable("tno") Long tno){
    
    log.info("read tno: " + tno);
    
    return todoService.read(tno);
  }
  
  @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
  public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO){
    
    return todoService.list(pageRequestDTO);
  }
}
