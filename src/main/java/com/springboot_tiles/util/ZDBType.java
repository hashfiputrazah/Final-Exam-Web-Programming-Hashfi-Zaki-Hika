package com.springboot_tiles.util;

public enum ZDBType {
	MySQL("MySQL"), MSSQL("MSSQL");
	
	private String dbtype;
	ZDBType(String s) {
		dbtype = s;
	}
	public String getString(){
		return dbtype;
	}
}
