package org.jjiinnee.api01.repository.search;

import org.jjiinnee.api01.dto.PageRequestDTO;
import org.jjiinnee.api01.dto.TodoDTO;
import org.springframework.data.domain.Page;

public interface TodoSearch {
  
  Page<TodoDTO> list(PageRequestDTO pageRequestDTO);
}
