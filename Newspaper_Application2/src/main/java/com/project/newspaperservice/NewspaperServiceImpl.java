package com.project.newspaperservice;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.newspaper.dao.NewspaperDao;
import com.project.newspaper.dto.NewspaperDto;
import com.project.newspaper.entity.Newspaper;

@Component
public class NewspaperServiceImpl implements NewspaperServiceDAO {
	@Autowired
	private NewspaperDao newspaperDao;

	public NewspaperServiceImpl() {
		System.out.println("object is created:" + this.getClass().getName());
	}

	@Override
	public boolean validateNewspaperdto(NewspaperDto newspaperDto) {
		System.out.println("Invoked validate newspaperDTO");
		boolean flag = false;
		if (newspaperDto.getNewspaperName() != null && !newspaperDto.getNewspaperName().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			System.out.println("Newspaper name is invalid");
			return flag;
		}
		if (newspaperDto.getPrice() > 0) {
			flag = true;
		} else {
			flag = false;
			System.out.println("Newspaper price is Invalid");
			return flag;
		}
		if (newspaperDto.getLanguage() != null && !newspaperDto.getLanguage().isEmpty()) {
			flag = true;
		} else {
			flag = false;
			System.out.println("Newspaper language is invalid");
			return flag;
		}
		if (newspaperDto.getNoofPages() > 0) {
			flag = true;
		} else {

			System.out.println("Newspaper Noofpages is invalid");
			return flag;
		}
		return flag;

	}

	@Override
	public boolean savenewspaperdto(NewspaperDto newspaperDto) {
		System.out.println("Invoked save newspaperdto method()");
		Newspaper newspaper = new Newspaper();
		BeanUtils.copyProperties(newspaperDto, newspaper);
		boolean result = this.newspaperDao.saveNewspaperEntity(newspaper);
		return result;

	}

	@Override
	public boolean validateNewspaperName(String newspaerName) {
		System.out.println("Invoked validate newspaper name ()");
		boolean flag = false;
		if (newspaerName != null && !newspaerName.isEmpty()) {
			flag = true;
			return flag;
		} else {
			flag = false;
			System.out.println("newspaper name is invalid...,,,,");
		}

		return flag;
	}

	@Override
	public List<Object> getNewspaperName(String newspaperName) {
		System.out.println("Invoked get Newspaper Name()");
		List<Object> newspaperContainer = null;
		List<Newspaper> newspaperEntityContainer = this.newspaperDao.getNewspaperEntity(newspaperName);
		if (newspaperEntityContainer != null) {
			return newspaperContainer = new ArrayList<Object>(newspaperEntityContainer);

		}
		return newspaperContainer;
	}

	@Override
	public boolean validateNewspaperLanguage(String Language) {
		System.out.println("Invoked validate newspaper Language ()");
		boolean flag = false;
		if (Language != null && !Language.isEmpty()) {
			flag = true;
			return flag;
		} else {
			flag = false;
			System.out.println("Language is invalid...,,,,");
			return flag;
		}

	}

	@Override
	public NewspaperDto getNewspaperLanguage(String Language) {
		System.out.println("Invoked get Newspaper Language()");
		Newspaper entity=this.newspaperDao.getNewspaperEntityByLanguage(Language);
		if(entity!=null) {
			NewspaperDto dto=new NewspaperDto();
			BeanUtils.copyProperties(entity, dto);
			return dto; 
		}
		return null;
	}

	@Override
	public List<Object> getAllNewspaperEntity(){
		System.out.println("NewspaperServiceImpl.getAllNewspaperEntity()");
		List<Object> newspaperContainer=null;
		List<Newspaper> newspaperEntityContainer=this.newspaperDao.getAllNewspaperEntity();
		if(newspaperEntityContainer!=null) {
			return newspaperContainer=new ArrayList<Object>(newspaperEntityContainer);
		}
		return newspaperContainer;
	}

	@Override
	public boolean deleteNewspaperEntity(String newspaperName) {
		System.out.println("NewspaperServiceImpl.deleteNewspaperEntity()");
		boolean newspaper=(boolean) this.newspaperDao.deleteNewspaperEntity(newspaperName);
		return true;

		}

	@Override
	public boolean updateNewspaperEntity(NewspaperDto dto) {
		System.out.println("NewspaperServiceImpl.updateNewspaperEntity()");
		Newspaper newspaper = new Newspaper();
		BeanUtils.copyProperties(newspaper, newspaper);
		boolean result = this.newspaperDao.updateNewspaperEntity(dto);
		return result;
		
	}

	
}



