package com.springboot_tiles.dao;

import java.util.List;

import com.springboot_tiles.to.Book_ManagementTO;

public interface BookManagementDAO {
	public List<Book_ManagementTO> getBook();
	
//	update
	public String Update(Book_ManagementTO tobBook_Management);
//Delete
	public String Delete(int id_book);
	//insert
		public String Insert(Book_ManagementTO tobBook_Management);
	
}
