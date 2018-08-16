package cn.mzgd.service;

import java.util.ArrayList;

import cn.mzgd.dao.BookDao;
import cn.mzgd.model.BookModel;

public class BookService {
	BookDao bookDao = new BookDao();
	
	public int insert(BookModel bookModel) {
		return bookDao.insert(bookModel);
	}
	
	public int deleteById(int id) {
		return bookDao.deleteById(id);
	}
	
	public BookModel queryById(int id) {
		return bookDao.queryById(id);
	}
	
	public ArrayList<BookModel> queryByName(String keyword){
		return bookDao.queryByName(keyword);
	}
	
	public int update(BookModel bookModel) {
		return bookDao.update(bookModel);
	}

}
