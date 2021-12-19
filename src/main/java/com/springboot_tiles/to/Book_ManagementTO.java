package com.springboot_tiles.to;

public class Book_ManagementTO {
	private String id_book;
	private String book_name;
	private int book_genre;
	private String book_author;
	private String book_image;
	private String genre_name;
	private int id_genre;
	
	public String getGenre_name() {
		return genre_name;
	}
	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}
	public int getId_genre() {
		return id_genre;
	}
	public void setId_genre(int id_genre) {
		this.id_genre = id_genre;
	}
	public String getId_book() {
		return id_book;
	}
	public void setId_book(String id_book) {
		this.id_book = id_book;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getBook_genre() {
		return book_genre;
	}
	public void setBook_genre(int book_genre) {
		this.book_genre = book_genre;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_image() {
		return book_image;
	}
	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}
}
