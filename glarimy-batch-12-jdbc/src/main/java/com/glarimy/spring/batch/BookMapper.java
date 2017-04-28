package com.glarimy.spring.batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookMapper implements RowMapper<Book> {
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book();
		book.setIsbn(rs.getInt("isbn"));
		book.setTitle(rs.getString("title"));
		return book;
	}
}
