package com.project.newspaperservice;

import java.util.List;

import com.project.newspaper.dto.NewspaperDto;
import com.project.newspaper.entity.Newspaper;

public interface NewspaperServiceDAO {
	boolean validateNewspaperdto(NewspaperDto newspaperDto); 
	boolean savenewspaperdto(NewspaperDto newspaperDto);
	
	boolean validateNewspaperName(String newspaerName);
	List<Object> getNewspaperName(String newspaperName);
	
	boolean validateNewspaperLanguage(String Language);
	NewspaperDto getNewspaperLanguage(String Language);
	
	List<Object> getAllNewspaperEntity();
	
	boolean deleteNewspaperEntity(String newspaperName);
	
	boolean validateupdateNewspaperEntity(NewspaperDto newspaperDto);
	boolean updateNewspaperEntity(NewspaperDto newspaperDto);

	
	

}
