package com.project.newspaper.dto;

public class NewspaperDto {
private	String newspaperName;
private	double price;
private	String language;
private	int noofPages;

	public NewspaperDto() {

		super();

	}

	public NewspaperDto(String newspaperName, double price, String language, int noofPages) {
		super();
		this.newspaperName = newspaperName;
		this.price = price;
		this.language = language;
		this.noofPages = noofPages;
	}

	public String getNewspaperName() {
		return newspaperName;
	}

	public void setNewspaperName(String newspaperName) {
		this.newspaperName = newspaperName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getNoofPages() {
		return noofPages;
	}

	public void setNoofPages(int noofPages) {
		this.noofPages = noofPages;
	}

	@Override
	public String toString() {
		return "NewspaperDto [newspaperName=" + newspaperName + ", price=" + price + ", language=" + language
				+ ", noofPages=" + noofPages + "]";
	}

	
	

}
