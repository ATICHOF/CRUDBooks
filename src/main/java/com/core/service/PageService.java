package com.core.service;
import java.util.List;
import com.core.models.Page;

public interface PageService {
	List<Page> findAll();
	Page findPageById(long id);
	void addPage(Page page);
	void deletePageById(long id);
}
