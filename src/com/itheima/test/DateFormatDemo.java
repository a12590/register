package com.itheima.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class DateFormatDemo {

	public static void main(String[] args) throws ParseException {
		String s = "2014-02-28";
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		Date d = df.parse(s);
//		System.out.println(d);
		
		DateLocaleConverter dlc = new DateLocaleConverter();
		dlc.convert(s);
	}

}
