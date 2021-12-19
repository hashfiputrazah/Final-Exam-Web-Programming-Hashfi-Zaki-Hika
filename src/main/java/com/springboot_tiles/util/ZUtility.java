package com.springboot_tiles.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.springboot_tiles.to.UserTO;

public class ZUtility {
	public static final String ERROR_STYLE = "border:1px solid crimson;";
	public static final String SESS_USER_ID = "SessUserID";
	public static final String SESS_TIMEOUT = "TimeOut";

	public static final boolean isNullOrEmpty(String s) {
		return s == null || s.isEmpty();
	}
	
	public static final boolean isNullOrEmpty(Object s) {
		return s == null || isNullOrEmpty(s.toString());
	}
	
	public static final String createErrorMsg(String errorMsg) {
		return "<ul class='parsley-errors-list filled'>" +
	            "  <li class='parsley-type'>" +
	            "    <i class='fa fa-warning'></i> " + errorMsg +
	            "  </li>" +
	            "</ul>";
	}
	
	public static Integer parseInt(String s, Integer default_) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return default_;
		}
	}
	
	public static final String encodeString(String s) {
		if (s == null) {
			return "";
		} else {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
	        try {
				new ObjectOutputStream(out).writeObject(s);
			} catch (IOException e) {
				return "";
			}
	        return new String(Base64.getEncoder().encode(out.toByteArray()));
		}
	}
	
	public static final String decodeString(String s) {
		if (isNullOrEmpty(s)) {
			return "";
		}
		ByteArrayInputStream in = new ByteArrayInputStream(Base64.getDecoder().decode(s.getBytes()));
		try {
			return (String) new ObjectInputStream(in).readObject();
		} catch (ClassNotFoundException | IOException e) {
			return null;
		}
	}
	public static String convertFirstCapital(String str){ 
		  
        // Create a char array of given String 
        char ch[] = str.toCharArray(); 
        for (int i = 0; i < str.length(); i++) { 
  
            // If first character of a word is found 
            if (i == 0 && ch[i] != ' ' ||  
                ch[i] != ' ' && ch[i - 1] == ' ') { 
  
                // If it is in lower-case 
                if (ch[i] >= 'a' && ch[i] <= 'z') { 
  
                    // Convert into Upper-case 
                    ch[i] = (char)(ch[i] - 'a' + 'A'); 
                } 
            } 
  
            // If apart from first character 
            // Any one is in Upper-case 
            else if (ch[i] >= 'A' && ch[i] <= 'Z')  
  
                // Convert into Lower-Case 
                ch[i] = (char)(ch[i] + 'a' - 'A');             
        } 
  
        // Convert the char array to equivalent String 
        String st = new String(ch); 
        return st; 
    }
	public static byte[] base64toBinary(String base64Encode) {
    	String b64 = base64Encode;
    	byte[] decoder = Base64.getDecoder().decode(b64);
        return decoder;
    }
	
	public static String convertObjToJson(Object obj) {
		String jsonStr = null;
		try {
        	ObjectMapper Obj = new ObjectMapper(); 
        	Obj.setSerializationInclusion(Include.NON_NULL);
            jsonStr = Obj.writeValueAsString(obj); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
		return jsonStr;
	}
	
	public static String convertListToJson(List<?> list) {
		String jsonStr = "";
		try {
        	ObjectMapper mapper = new ObjectMapper(); 
        	mapper.enable(SerializationFeature.INDENT_OUTPUT);
        	mapper.setSerializationInclusion(Include.NON_NULL);
            jsonStr = mapper.writeValueAsString(list); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
		return jsonStr;
	}
	
	public static String prettyPrintObject(Object obj) {
		// pretty print
		String jsonStr = "";
		try {
        	ObjectMapper mapper = new ObjectMapper(); 
        	jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
		return jsonStr;
	}
	
	public static boolean isJSONValid(String string) {
		try {
			new JSONObject(string);
		} catch (JSONException ex) {
			try {
				new JSONArray(string);
			} catch (JSONException ex1) {
				return false;
			}
		}
		return true;
	}
	
	public static String floatToString(float i) {
		if(i ==0) {
			return "";
		}else {
			return String.valueOf(i);
		}
	}
	
	public static String isNullorEmptyString(String s) {
		if (isNullOrEmpty(s)) {
			return "";
		}else {
			return s;
		}
	}
	public static String strFormat2f(Double input) {
		return String.format("%.2f", input);
	}
	public static boolean isValidNumber(String input) {
		char[] data = input.toCharArray();
		 
		boolean valid = true;
		for (char c : data) {
		    if (!Character.isDigit(c)) {
		        valid = false;
		        break;
		    }
		}
		
		return valid;
	}
	
	public static boolean isNumber(String string) {
		boolean numeric = true;

        try {
            Double num = Double.parseDouble(string);
        } catch (NumberFormatException e) {
            numeric = false;
        }
        
        return numeric;
	}
	
	public static int getRandomInt() {
		Random r = new Random( System.currentTimeMillis() );
	    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}
	
	public static int getRandomInt(int a, int b) {
		String time = new ZTime().getCurrentDate();
		Random r = new Random( System.currentTimeMillis() );
		int i = ((1 + r.nextInt(2)) * a + r.nextInt(b));
		String hsl = time+""+String.valueOf(i);
		
	    return Integer.valueOf(hsl);
	}
	
	public static String getRandom() {
        Random random = new Random();
        int nextInt = random.nextInt(900000);
        nextInt=nextInt+100000;
        String str=nextInt+"";
        return str;
    }
	
	public static String getTimeYearMonthDay(String dateFormat) {
        String[] strNow = new SimpleDateFormat(dateFormat).format(new Date()).toString().split("-");
        String str="";
        for (String string : strNow) {
            str=str+string;
        }
        return str;
    }

	
	public static String getDatePrimaryKey() {
        return getTimeYearMonthDay("yyMM")+getRandom();
    }

	
	public static List<String> removeDuplicatesList(List<String> listResult){ 
    	Set<String> primesWithoutDuplicates = new LinkedHashSet<String>(listResult); 
    	listResult.clear();
    	listResult.addAll(primesWithoutDuplicates);
        return listResult; 
    }
	public static String getIPLocal(){
		String strResult = " ";
		InetAddress address;
		try {
			address = InetAddress.getLocalHost();
			strResult = address.getHostAddress();
			/*for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
			        //Perhaps networkInterface.isVirtual() will help you identify the correct one?
				if(networkInterface.isVirtual()) {
					strResult = networkInterface.getInterfaceAddresses().toString();
				}
				System.out.println("list network "+ networkInterface.isVirtual()+" "+ networkInterface.getInterfaceAddresses());
		    }*/
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		return strResult ;
	}
	
	public static UserTO doGetUserSession(HttpServletRequest request) {
		UserTO user = (UserTO) request.getSession().getAttribute(ZUtility.SESS_USER_ID);
		
		return user;
	}
	
	public static String doGetSession(UserTO user) {
		String strResult = SESS_TIMEOUT;
		
		if(!ZUtility.isNullOrEmpty(user)) {
			strResult = SESS_USER_ID;
		}
		return strResult;
	}
	
	public static String doWaterMarkEmail(String email) {
		String regex = "(?<=.)[^@](?=[^@]*?@)|(?:(?<=@.)|(?!^)\\\\G(?=[^@]*$)).(?=.*\\\\.)";
		String strResult = email.replaceAll(regex, "*");
		return strResult;
	}
	
	public static String doGetUUID() {
		String strResult = UUID.randomUUID().toString();
		return strResult;
	}
	
	public static int doGetExpired() {
		int i = (60 * 24);
		return i;
	}
	
	public static Map<String, Object> doApiMessage(int code, String message) {
		Map<String, Object> m = new HashMap<>();
		m.put("code", code);
        m.put("message", message);
		return m;
	}
	
	public static String doFirstCapitalEveryWord(String message) {
		// stores each characters to a char array
		char[] charArray = message.toCharArray();
		boolean foundSpace = true;

		for (int i = 0; i < charArray.length; i++) {
			// if the array element is a letter
			if (Character.isLetter(charArray[i])) {
				// check space is present before the letter
				if (foundSpace) {
					// change the letter into uppercase
					charArray[i] = Character.toUpperCase(charArray[i]);
					foundSpace = false;
				}
			}else {
				// if the new character is not character
				foundSpace = true;
			}
		}

	    // convert the char array to the string
	    message = String.valueOf(charArray);
	    
	    System.out.println("Message: " + message);
	    return message;
	}
	public static boolean isValidEmail(String email) {
		 boolean validate;
		 String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.+[a-z]+";
		 String emailPattern2 = "[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.+[a-z]+\\.+[a-z]+";

		 if (email.matches(emailPattern)) {
			 validate = true;
		 } else if (email.matches(emailPattern2)) {
			 validate = true;
		 } else {
			 validate = false;
		 }

		 return validate;
	}
	
	public static <T> Logger Logger(Class<T> className) {
		 Logger logger = LoggerFactory.getLogger(className);
		 
		 return logger;
	 }
}
