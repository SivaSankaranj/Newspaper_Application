package com.project.controller;

import java.util.List;

import com.project.newspaper.dto.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.newspaperservice.NewspaperServiceImpl;

@Component
@RequestMapping("/")
public class NewspaperController {
	@Autowired
	private NewspaperServiceImpl serviceImpl;

	public NewspaperController() {
		System.out.println("object is created:" + this.getClass().getName());
	}

	@RequestMapping("/save.do")
	public String saveNewspaperDetails(@ModelAttribute NewspaperDto newspaper, Model model) {
		System.out.println("Invoked save Newspaper details method()");
		if (this.serviceImpl.validateNewspaperdto(newspaper)) {
			boolean isSaved = this.serviceImpl.savenewspaperdto(newspaper);
			if (isSaved) {
				model.addAttribute("Name", newspaper.getNewspaperName());
				model.addAttribute("Price", newspaper.getPrice());
				model.addAttribute("Language", newspaper.getLanguage());
				model.addAttribute("NoOfpages", newspaper.getNoofPages());
				model.addAttribute("validateMessgage", "data is saved successfully.......,,,");

			} else {
				model.addAttribute("ErrorMessage", "Invalid data,,, please check it once......");
			}
		}

		return "WEB-INF/pages/viewNewspaperDetails.jsp";

	}

	@RequestMapping("/searchNewspaper.do")
	public String getNewspaperName(@RequestParam String searchNewspaper, Model model) {
		System.out.println("Invoked get newspaper Name() by controller class");
		if (this.serviceImpl.validateNewspaperName(searchNewspaper)) {
			List<Object> newspaperDtO = this.serviceImpl.getNewspaperName(searchNewspaper);
			model.addAttribute("ListofNewspaper", newspaperDtO);
			model.addAttribute("Validate Message", "NewspaperEntiy By name is found");
			return "WEB-INF/pages/viewNewspaperNameDetails.jsp";
		} else {
			model.addAttribute("errorMessage", "Newspaper Name is not found");
		}
		return "WEB-INF/pages/viewNewspaperNameDetails.jsp";

	}

	@RequestMapping("/searchLanguage.do")
	public String getNewspaperLanguage(@RequestParam String searchLanguage, Model model) {
		System.out.println("Invoked get newspaper Language() by controller class");
		if (this.serviceImpl.validateNewspaperLanguage(searchLanguage)) {
			NewspaperDto dto = this.serviceImpl.getNewspaperLanguage(searchLanguage);
			if (dto != null) {
				model.addAttribute("Name", dto.getNewspaperName());
				model.addAttribute("Price", dto.getPrice());
				model.addAttribute("Language", dto.getLanguage());
				model.addAttribute("NoofPages", +dto.getNoofPages());
				return "WEB-INF/pages/viewNewspaperLanguageDetails.jsp";
			} else {
				model.addAttribute("searchvalidation", "invalid language try again......,,,");
			
			}

		
		
	}
		return "WEB-INF/pages/viewNewspaperLanguageDetails.jsp";
}
	@RequestMapping("/getAllNewspaper.do")
	public String getAllNewspaperEntity(Model model) {
		System.out.println("NewspaperController.getAllNewspaperEntity()");
		List<Object> allNewspaperEntity=this.serviceImpl.getAllNewspaperEntity();
		model.addAttribute("ListOfNewspaper",allNewspaperEntity);
		return "WEB-INF/pages/getAllNewspaperEntity.jsp";
	}
	@RequestMapping("/deleteNewspaper.do")
	public String deleteNewspaperEntity(@RequestParam(value="newspaperName") String newspaperName,Model model) {
		System.out.println("NewspaperController.deleteNewspaperEntity()");
		boolean isDeleted=this.serviceImpl.deleteNewspaperEntity(newspaperName);
		if(isDeleted) {
			model.addAttribute("validationMessage", "Newspaper Details deleted successfully,,,,,,,");
		}else {
			model.addAttribute("validationMessage", "could not delete the data,,,,, try again");
			
		}
		return "WEB-INF/pages/deleteNewspaperEntity.jsp";
		
	}
	@RequestMapping("/update.do")
	public String updateNewspaperEntity(@ModelAttribute NewspaperDto newspaper,Model model) {
		System.out.println("NewspaperController.updateNewspaperEntity()");
			boolean isUpdated = this.serviceImpl.updateNewspaperEntity(newspaper);
			if (isUpdated) {
				model.addAttribute("Name",newspaper.getNewspaperName());
				model.addAttribute("Price", newspaper.getPrice());
				model.addAttribute("Language", newspaper.getLanguage());
				model.addAttribute("NoOfpages", newspaper.getNoofPages());
				model.addAttribute("validateMessgage", "data is updated successfully.......,,,");
				return "WEB-INF/pages/updateNewspaperDetails.jsp";
		
	}else {
		model.addAttribute("ErrorMessage", "Invalid data,,, please check it once......");
	}
			return "WEB-INF/pages/updateNewspaperDetails.jsp";
		



}
}
	