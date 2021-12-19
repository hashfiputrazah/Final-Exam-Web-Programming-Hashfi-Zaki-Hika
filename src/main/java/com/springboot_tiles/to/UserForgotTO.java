package com.springboot_tiles.to;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import lombok.Data;
@Data
public class UserForgotTO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long ForgotID;
    private String token;
    private Date expiryDate;
    private UserTO tobUser;


    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setExpiryDate(int minutes){
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, minutes);
        this.expiryDate = now.getTime();
    }

    public boolean isExpired() {
        return new Date().after(this.expiryDate);
    }

}
