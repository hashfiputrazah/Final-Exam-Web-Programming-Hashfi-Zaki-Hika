package com.springboot_tiles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot_tiles.dao.BookManagementDAO;
import com.springboot_tiles.dao.UserDAO;
import com.springboot_tiles.to.Book_ManagementTO;

@Service
public class BookManagementServiceImpl implements BookManagementService {
	@Autowired
	private BookManagementDAO dao;
	
	@Override
	public List<Book_ManagementTO> getBook() {
		// TODO Auto-generated method stub
		return dao.getBook();
	}

	@Override
	public String Update(Book_ManagementTO tobBook_Management) {
		// TODO Auto-generated method stub
		return dao.Update(tobBook_Management);
	}

	@Override
	public String Delete(int id_book) {
		// TODO Auto-generated method stub
		return dao.Delete(id_book);
	}

	@Override
	public String Insert(Book_ManagementTO tobBook_Management) {
		// TODO Auto-generated method stub
		return dao.Insert(tobBook_Management);
	}

}
