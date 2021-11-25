package com.core.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.core.models.Page;
@Repository
public interface CRUDPage extends CrudRepository<Page, Long> {

}
