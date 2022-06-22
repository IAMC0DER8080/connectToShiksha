package com.mpasc.connecttoclass.spring.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mpasc.connecttoclass.spring.entity.AssignmentEntity;
import com.mpasc.connecttoclass.spring.entity.AssignmentModel;



public class ApplicationUtil {
	
	
	public static List<String> currentDate() {
		 List<String> rsponcelist= new ArrayList<>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		Date date = new Date();  
		rsponcelist.add(formatter.format(date)); 
	    formatter = new SimpleDateFormat("HH:mm:ss");  
	    rsponcelist.add(formatter.format(date));
	   
		
		return rsponcelist;
	}
	
	public static String dateFormat(String dateInput) throws ParseException {
		SimpleDateFormat currentDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		 
		
	   String rsponce= formatter.format(currentDateFormat.parse(dateInput));
		
		return rsponce;
	}
	
	
	public static String timeFormat(String timeInput) throws ParseException {
		  SimpleDateFormat timefromater = new SimpleDateFormat("HH:mm:ss");
		  SimpleDateFormat currentTimeFormat = new SimpleDateFormat("hh:mma");
		 
		
	   String rsponce= timefromater.format(currentTimeFormat.parse(timeInput));
		
		return rsponce;
	}
	
	 public static boolean compareDates(String dateInput)
	    {
		   boolean flag=true;
	        try{
	           
	        	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
	        	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        	LocalDateTime now = LocalDateTime.now();  
	        
	            String currentDatestr = dtf.format(now);
	            Date currentDate =sdf.parse(currentDatestr);
	        	
	            Date lectureDate = sdf.parse(dateInput);
	            

				
	            if(currentDate.after(lectureDate)){
	            	flag=false;
	            }
	           
	            if(currentDate.before(lectureDate)){
	                System.out.println("Date1 is before Date2");
	            }

	            //equals() returns true if both the dates are equal
	            if(currentDate.equals(lectureDate)){
	                System.out.println("Date1 is equal Date2");
	            }

	            System.out.println();
	       // }
	        }
	        catch(ParseException ex){
	            ex.printStackTrace();
	        }
	        return flag;
	    }

}
