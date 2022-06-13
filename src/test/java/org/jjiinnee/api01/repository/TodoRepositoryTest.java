package org.jjiinnee.api01.repository;

import lombok.extern.log4j.Log4j2;
import org.jjiinnee.api01.domain.Todo;
import org.jjiinnee.api01.dto.PageRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class TodoRepositoryTest {
  
  @Autowired
  private TodoRepository todoRepository;
  
  @Test
  public void insertTodo(){
    IntStream.rangeClosed(1,100).forEach( i -> {
  
      LocalDate dueDate = LocalDate.now().plusDays(i % 10);
      
      Todo todo = Todo.builder()
              .title("todo" + i )
              .writer("user"+ (i%10))
              .dueDate(dueDate)
              .build();
      
      todoRepository.save(todo);
    });
  }
  
  
  @Test
  public void searchTest(){
    PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
            .keyword("1")
            .from(LocalDate.of(2022,06,10))
            .to(LocalDate.of(2022,06,13))
            .build();
    
    todoRepository.list(pageRequestDTO);
  }
}
