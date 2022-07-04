package com.project.newspaper.dao;

import java.util.List;

import com.project.newspaper.dto.NewspaperDto;
import com.project.newspaper.entity.Newspaper;

public interface NewspaperDao {
	
	boolean saveNewspaperEntity(Newspaper newspaper);
	List<Newspaper> getNewspaperEntity(String newspaperName);
	Newspaper getNewspaperEntityByLanguage(String Language);
	List<Newspaper> getAllNewspaperEntity();
	boolean deleteNewspaperEntity(String newspaperName);
	
	boolean updateNewspaperEntity(NewspaperDto dto);
	
	
	
	
	

}
