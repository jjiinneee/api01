package org.jjiinnee.api01.repository;


import org.jjiinnee.api01.domain.Todo;
import org.jjiinnee.api01.repository.search.TodoSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoSearch {

}
