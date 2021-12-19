package com.springboot_tiles.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.springboot_tiles.to.Book_ManagementTO;
import com.springboot_tiles.util.ZConnection;

@Repository
public class BookManagementDAOImpl implements BookManagementDAO {
	@Qualifier("datasource")
	@Autowired DataSource dataSource;
	
	@Override
	public List<Book_ManagementTO> getBook() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Book_ManagementTO> List_Book_Management = new ArrayList<Book_ManagementTO>();
		StringBuffer sql = new StringBuffer();
		
		try {
			conn = dataSource.getConnection();
			sql.append("SELECT rb.id_book ,rb.book_name ,rb.book_genre ,rb.book_author ,rb.book_image ,rf.genre_name \n"); 
			sql.append("  FROM ref_book_storage rb \n");
			sql.append("LEFT JOIN ref_genre rf on rf.id_genre = rb.book_genre \n"); 
			pst = conn.prepareStatement(sql.toString());
			
			rs = pst.executeQuery();
			while (rs.next()) {
				Book_ManagementTO tobBook_Management = new Book_ManagementTO();
				tobBook_Management.setId_book(rs.getString("id_book"));
				tobBook_Management.setBook_name(rs.getString("book_name"));				
				tobBook_Management.setBook_genre(rs.getInt("book_genre"));
				tobBook_Management.setBook_author(rs.getString("book_author"));				
				tobBook_Management.setBook_image(rs.getString("book_image"));
				tobBook_Management.setGenre_name(rs.getString("genre_name"));
				List_Book_Management.add(tobBook_Management);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ZConnection.closeConnection(conn);
				ZConnection.closePrepareStatment(pst);
				ZConnection.closeResultSet(rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return List_Book_Management;
	}

	@Override
	public String Update(Book_ManagementTO tobBook_Management) {
		StringBuffer sql = new StringBuffer();
		Connection conn = null;
		PreparedStatement pst= null;
		String strResult = null;
		
		try {
			conn = dataSource.getConnection();
			sql.append("Update ref_book_storage SET book_name = ?,book_genre = ?,book_author = ? where id_book = ? ");
			pst = conn.prepareStatement(sql.toString());
			pst.setString(1, tobBook_Management.getBook_name());
			pst.setInt(2, tobBook_Management.getBook_genre());
			pst.setString(3, tobBook_Management.getBook_author());
			pst.setString(4, tobBook_Management.getId_book());
			pst.execute();
			
			strResult = "SUCCESS";
		} catch (SQLException e) {
			e.printStackTrace();
			strResult = e.getMessage();
		} finally {
			try {
				ZConnection.closeConnection(conn);
				ZConnection.closePrepareStatment(pst);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return strResult;
	}

	@Override
	public String Delete(int id_book) {
		Connection conn = null;
		StringBuffer sql = new StringBuffer();
		PreparedStatement pst = null;
		String result = "Failed";
		
		try {
			conn = dataSource.getConnection();
			ZConnection.beginTransaction(conn);
			sql.delete(0, sql.length());
			sql.append("delete from ref_book_storage where id_book=? \n"); 
			pst = conn.prepareStatement(sql.toString());
			pst.setInt(1, id_book);
			pst.addBatch();
			
			
			ZConnection.executeBatchPrepareStatement(pst);
			ZConnection.commitTransaction(conn);
			result="Success";
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ZConnection.closePrepareStatment(pst);
				ZConnection.closeConnection(conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public String Insert(Book_ManagementTO tobBook_Management) {
		Connection conn = null;
		StringBuffer sql = new StringBuffer();
		PreparedStatement pst = null;
		String Result = "Failed";
		
		try {
			conn = dataSource.getConnection();
			ZConnection.beginTransaction(conn);
			Random rand = new Random();
	        // Generate random integers in range 0 to 999
	        int rand_int1 = rand.nextInt(1000);
			sql.delete(0, sql.length());
			sql.append("insert into ref_book_storage (id_book,book_name,book_genre,book_author) \n"); 
			sql.append("values (?,?,?,?) \n");
			pst = conn.prepareStatement(sql.toString());
			pst.setInt(1, rand_int1);
			pst.setString(2, tobBook_Management.getBook_name());
			pst.setInt(3, tobBook_Management.getBook_genre());
			pst.setString(4, tobBook_Management.getBook_author());
			pst.addBatch();
			ZConnection.executeBatchPrepareStatement(pst);
			ZConnection.commitTransaction(conn);
			Result = "Success";
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ZConnection.closePrepareStatment(pst);
				ZConnection.closeConnection(conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return Result;
	}

}
