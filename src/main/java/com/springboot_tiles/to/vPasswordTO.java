package com.springboot_tiles.to;

import java.io.Serializable;

import lombok.Data;
@Data
public class vPasswordTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String newUserPWD;
	private String confUserPWD;
	private int data;
	private String iVal;

}
