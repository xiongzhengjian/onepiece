package com.wistron.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * This class converts the string returned from the front page to date format.
 * @author slim2
 *
 */
public class CustomStrToDateConverter implements Converter<String,Date>{

	@Override
	public Date convert(String source) {
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(source);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
