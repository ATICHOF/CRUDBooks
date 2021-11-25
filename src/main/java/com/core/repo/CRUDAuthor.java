package com.core.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.core.models.Author;

@Repository
public interface CRUDAuthor extends CrudRepository<Author, Long>{

}
