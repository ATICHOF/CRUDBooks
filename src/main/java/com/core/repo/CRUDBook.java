package com.core.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.core.models.Book;

@Repository
public interface CRUDBook extends CrudRepository<Book, Long>{
	
}
