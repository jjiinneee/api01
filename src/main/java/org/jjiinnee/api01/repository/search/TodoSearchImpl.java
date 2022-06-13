package org.jjiinnee.api01.repository.search;


import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import org.jjiinnee.api01.domain.QTodo;
import org.jjiinnee.api01.domain.Todo;
import org.jjiinnee.api01.dto.PageRequestDTO;
import org.jjiinnee.api01.dto.TodoDTO;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class TodoSearchImpl extends QuerydslRepositorySupport implements TodoSearch {
  
  public TodoSearchImpl() {
    super(Todo.class);
  }
  
  @Override
  public Page<TodoDTO> list(PageRequestDTO pageRequestDTO) {
  
    QTodo todo = QTodo.todo;
  
    JPQLQuery<Todo> todoJPQLQuery =  from(todo);
    if(pageRequestDTO.getKeyword() != null){
      todoJPQLQuery.where(todo.title.contains(pageRequestDTO.getKeyword()));
    }
    
    if(pageRequestDTO.getFrom() != null && pageRequestDTO.getTo() != null){
      todoJPQLQuery.where(todo.dueDate.between(pageRequestDTO.getFrom(),pageRequestDTO.getTo()));
    }
    
    if(pageRequestDTO.getCompleted() != null){
      todoJPQLQuery.where(todo.complete.eq(pageRequestDTO.getCompleted()));
    }
    
    JPQLQuery<TodoDTO> todoQuery =  todoJPQLQuery.select(
                              Projections.bean(
                                      TodoDTO.class
                                      ,todo.title
                                      ,todo.tno
                                      ,todo.dueDate
                                      ,todo.writer
    ));
    Pageable pageable = PageRequest.of(pageRequestDTO.getPage() -1, pageRequestDTO.getSize(),
            Sort.by("tno").descending());
    this.getQuerydsl().applyPagination(pageable, todoQuery);
    
    List<TodoDTO>  dtoList = todoQuery.fetch();
    
    long totalCount = todoQuery.fetchCount();
    
    
    return new PageImpl<>(dtoList,pageable,totalCount);
  }
}
