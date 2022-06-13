package org.jjiinnee.api01.service;

import org.jjiinnee.api01.dto.PageRequestDTO;
import org.jjiinnee.api01.dto.PageResponseDTO;
import org.jjiinnee.api01.dto.TodoDTO;

public interface TodoService {
  
  Long register(TodoDTO todoDTO);
  
  TodoDTO read(Long tno);
  
  PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO);
}
