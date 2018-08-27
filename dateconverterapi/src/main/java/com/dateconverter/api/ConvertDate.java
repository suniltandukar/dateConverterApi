package com.dateconverter.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertDate {
	
	@RequestMapping(value = "/englishtonepali/{id}", method = RequestMethod.GET)
	public Map<String, Object> englishtonepali(@PathVariable("id") String englishdate){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
		String[] splitdate = englishdate.split("-");
		int year = Integer.parseInt(splitdate[0]);
		int month = Integer.parseInt(splitdate[1]);
		int day = Integer.parseInt(splitdate[2]);
		
		
		
		Converter converter = new Converter();
		NepaliDate nepaliDate = converter.getNepaliDate(year, month, day);
		

		 
		SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dformat.parse(nepaliDate.toString());
		String formatteddate = dformat.format(date);		
		map.put("data", formatteddate);
		}
		catch(Exception e) {
			System.out.println(e);
			map.put("data", "unsupported");
		}
		
		return map;
	}
	
	@RequestMapping(value = "/nepalitoenglish/{id}", method = RequestMethod.GET)
	public Map<String, Object> nepalitoenglish(@PathVariable("id") String nepalidate){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
		String[] splitdate = nepalidate.split("-");
		int year = Integer.parseInt(splitdate[0]);
		int month = Integer.parseInt(splitdate[1]);
		int day = Integer.parseInt(splitdate[2]);
		
		
		
		Converter converter = new Converter();
		EnglishDate englishDate = converter.getEnglishDate(year, month, day);
		
		SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dformat.parse(englishDate.toString()); //conversion string to date
		String formatteddate = dformat.format(date);		//formating date to req format
		map.put("data", formatteddate);

		}
		catch(Exception e) {
			System.out.println(e);
			map.put("data", "unsupported");
		}
		
		return map;
	}

}
