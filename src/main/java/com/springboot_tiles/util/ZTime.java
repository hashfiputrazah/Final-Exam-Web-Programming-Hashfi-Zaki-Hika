package com.springboot_tiles.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ZTime {
	private String formatTimeLog = "yyyy-MM-dd HH:mm:ss";
	
	public ZTime() {
	}
	public ZTime(String out_format, Date input, String in_format) {
		String inputPattern = in_format;
		SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
		SimpleDateFormat outputFormat = new SimpleDateFormat(out_format);
		Date date = null;
    
		String str = null;
		try{
			date = inputFormat.parse(input.toString());
			str = outputFormat.format(date);
		}catch (ParseException localParseException) {}
	}
	  
	public String convertDate(String out_format, Date input, String in_format){
		String inputPattern = in_format;
		SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
		SimpleDateFormat outputFormat = new SimpleDateFormat(out_format);
		Date date = null;
		String str = null;
		try {
			date = inputFormat.parse(input.toString());
			str = outputFormat.format(date);
		}catch (ParseException localParseException) {}
	  
		return str;
	}
	  
	public String convertDateEmail(String in_format, Date input){
		return convertDate(in_format, input, "EEE MMM d HH:mm:ss zzz yyyy");
	}
	  
	public String getDateEmail(Date input){
		if (input != null) {
			return String.valueOf(convertDate("dd-MM-yyyy", input, "EEE MMM d HH:mm:ss zzz yyyy"));
		}
	  
		return "null";
	}
	  
	public String getTimeEmail(Date input) {
		if (input != null) {
			return String.valueOf(convertDate("HH:mm:ss", input, "EEE MMM d HH:mm:ss zzz yyyy"));
		}
		  
		return "null";
	}
	
	  
	public int getThnEmail(Date input) {
		return Integer.valueOf(convertDate("yyyy", input, "EEE MMM d HH:mm:ss zzz yyyy")).intValue();
	}
	  
	public void setTimeFormatLog(String format){
		this.formatTimeLog = format;
	}
	  
	public String LogTimeDate(){
		SimpleDateFormat sf = new SimpleDateFormat(this.formatTimeLog);
		Date tgl = new Date();
		String hasil = sf.format(tgl);
		
		return hasil;
	}
	  
	public String nmFileTgl(){
		SimpleDateFormat sf = new SimpleDateFormat("-yyyMMdd");
		Date tgl = new Date();
		String hasil = sf.format(tgl);
		  
		return hasil;
	}
	  
	public String LogTimeCal() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(this.formatTimeLog);
		  
		return sdf.format(cal.getTime());
	}
	  
	public String LogTimeLocal() {
		DateTimeFormatter sf = DateTimeFormatter.ofPattern(this.formatTimeLog);
		LocalDateTime ldt = LocalDateTime.now();
		String hasil = sf.format(ldt);
		  
		return hasil;
	}
	  
	public String timePolos(){
		DateTimeFormatter sf = DateTimeFormatter.ofPattern("ddMMyyy_HHmm");
		LocalDateTime ldt = LocalDateTime.now();
		String hasil = sf.format(ldt);
		  
		return hasil;
	}
	  
	public String getTimeNow() {
		DateTimeFormatter sf = DateTimeFormatter.ofPattern("ddMMyyy_HHmmss");
		LocalDateTime ldt = LocalDateTime.now();
		String hasil = sf.format(ldt);
		  
		return hasil;
	}
	  
	public String getDateTimeNow() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date tgl = new Date();
		  
		return sdf.format(tgl);
	}
	
	public String getDateMMddyyyy() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		Date tgl = new Date();
		
		return sdf.format(tgl);
	}
	  
	public String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date tgl = new Date();
		  
		return sdf.format(tgl);
	}
	  
	public String getTanggalSQL() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		Date tgl = new Date();
		  
		return sdf.format(tgl);
	}
	public String getTanggalSQLMilis() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		Date tgl = new Date();
		  
		return sdf.format(tgl);
	}
	  
	public String getTanggalMySQL() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date tgl = new Date();
		  
		return sdf.format(tgl);
	}
	
	public String getDateNow() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date tgl = new Date();
		  
		return sdf.format(tgl);
	}
	
	public String getMonthNow() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date tgl = new Date();
		  
		return sdf.format(tgl);
	}
	
	public String parseMonthYear(String input) {
		SimpleDateFormat inputDate = new SimpleDateFormat("MM-yyyy");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date tgl = new Date();
		String str = null;
		try {
			tgl = inputDate.parse(input);
			str = sdf.format(tgl);
		}catch (ParseException localParseException) {}
		  
		return str;
	}
	
	public String parseMonth(String input) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat inputDate = new SimpleDateFormat("MMM-yyyy");
		Date tgl = new Date();
		try {
			tgl = sdf.parse(input);
		}catch (ParseException localParseException) {}
		
		return inputDate.format(tgl);
	}
	
	public String getYesterday() {
	    final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -1);
	    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	    String formatted = format1.format(cal.getTime());
	    return formatted;
	}
	
	public String getYesterdayTime() {
		SimpleDateFormat yesterdayDate = new SimpleDateFormat("dd-MM-yyyy");
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return yesterdayDate.format(cal.getTime()).toString();
	}
	
	public String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date tgl = new Date();
		  
		return sdf.format(tgl);
	}
	  
	public Timestamp getTanggalPostgreSQL() {
		return Timestamp.from(Instant.now());
	}
	  
	public Timestamp getTanggalOracle() {
		Date tgl = new Date();
		Timestamp sqlTimeStamp = new Timestamp(tgl.getTime());
		  
		return sqlTimeStamp;
	}
	  
	public String getHttpResponseTgl() {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
		Date tgl = new Date();
		  
		return sdf.format(tgl);
	}
	
	public int getParseYear(String input) {
		int year = Integer.parseInt(input);
		return year;
	}
	
	public String getParseTanggal(String input) {
		SimpleDateFormat inputDate = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date tgl = new Date();
		String str = null;
		try {
			tgl = inputDate.parse(input);
			str = sdf.format(tgl);
		}catch (ParseException localParseException) {}
		  
		return str;
	}
	
	public String getTanggal(String input) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat inputDate = new SimpleDateFormat("dd-MM-yyyy");
		Date tgl = new Date();
		try {
			tgl = sdf.parse(input);
		}catch (ParseException localParseException) {}
		
		return inputDate.format(tgl);
	}
	
	public String parseDDMonthYYYY(String input) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat inputDate = new SimpleDateFormat("dd-MMM-yyyy");
		Date tgl = new Date();
		try {
			tgl = sdf.parse(input);
		}catch (ParseException localParseException) {}
		
		return inputDate.format(tgl);
	}
	
	public String parseMonthDYr(String input) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat inputDate = new SimpleDateFormat("MMMM dd, yyyy");
		Date tgl = new Date();
		try {
			tgl = sdf.parse(input);
		}catch (ParseException localParseException) {}
		
		return inputDate.format(tgl);
	}
	
	public String parseMMDDYY(String input) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat inputDate = new SimpleDateFormat("MM-dd-yyyy");
		
		Date tgl = new Date();
		try {
			tgl = sdf.parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return inputDate.format(tgl);
	}
	
	public String parseDDMMYY(String input) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		SimpleDateFormat inputDate = new SimpleDateFormat("dd-MM-yyyy");
		
		Date tgl = new Date();
		try {
			tgl = sdf.parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return inputDate.format(tgl);
	}
	
	public String parseDDMMYYYY(String input) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		SimpleDateFormat inputDate = new SimpleDateFormat("yyyy-MM-dd");
		Date tgl = new Date();
		try {
			tgl = sdf.parse(input);
		}catch (ParseException localParseException) {}
		
		return inputDate.format(tgl);
	}
	
	public String getMonth(String input) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat inputDate = new SimpleDateFormat("MM-yyyy");
		Date tgl = new Date();
		try {
			tgl = sdf.parse(input);
		}catch (ParseException localParseException) {}
		
		return inputDate.format(tgl);
	}
	
	public String StringDatetoYesterday(String dateInString) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        try {
        	
        	cal.setTime(formatter.parse(dateInString));
        	cal.add(Calendar.DATE, -1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return formatter.format(cal.getTime());
	}
	
	public String StringDatetoAfterDay(String dateInString) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        try {
        	
        	cal.setTime(formatter.parse(dateInString));
        	cal.add(Calendar.DATE, 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return formatter.format(cal.getTime());
	}
	
	public Date stringToDate(String input) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//        String dateInString = "07/06/2013";

        Date date = new Date();
        try {

            date = formatter.parse(input);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return date;
	}
	
	public String getGenerateID() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		Date tgl = new Date();
		  
		return sdf.format(tgl);
	}
	
	public String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		Date tgl = new Date();
		  
		return sdf.format(tgl);
	}
	
	public String getGenerateIDFAM(String transDate) {
		SimpleDateFormat inputDate = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmsss");
		Date tgl = new Date();
		try {
			tgl = inputDate.parse(transDate);
		}catch (ParseException localParseException) {}
		
		return sdf.format(tgl);
	}
	
	public Date parseStringToDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date tgl =null;
		try {
			tgl = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return tgl;
	}
	public String parseDateToString(Date date) {
		String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		
		return sdf;
	}
	
	public String parseDateTime(String input) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		SimpleDateFormat inputDate = new SimpleDateFormat("dd-MM-yyyy");
		
		Date tgl = new Date();
		try {
			tgl = sdf.parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return inputDate.format(tgl);
	}
}
