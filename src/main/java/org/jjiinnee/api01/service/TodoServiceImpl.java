package org.jjiinnee.api01.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jjiinnee.api01.domain.Todo;
import org.jjiinnee.api01.dto.PageRequestDTO;
import org.jjiinnee.api01.dto.PageResponseDTO;
import org.jjiinnee.api01.dto.TodoDTO;
import org.jjiinnee.api01.repository.TodoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class TodoServiceImpl implements TodoService {
  
  private final ModelMapper modelMapper;
  private final TodoRepository todoRepository;
  
  @Override
  public Long register(TodoDTO todoDTO){
    Todo todo = modelMapper.map(todoDTO, Todo.class);
  
    Long tno = todoRepository.save(todo).getTno();
  
    return tno;
  }
  
  @Override
  public TodoDTO read(Long tno){
    Optional<Todo> result = todoRepository.findById(tno);
  
    Todo todo = result.orElseThrow();
  
    return modelMapper.map(todo, TodoDTO.class);
  }
  
  @Override
  public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO){
    Page<TodoDTO>  result = todoRepository.list(pageRequestDTO);
    
    return PageResponseDTO.<TodoDTO>withAll()
            .pageRequestDTO(pageRequestDTO)
            .dtoList(result.toList())
            .total((int)result.getTotalElements())
            .build();
  }
}
