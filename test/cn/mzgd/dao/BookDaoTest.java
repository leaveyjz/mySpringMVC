package cn.mzgd.dao;
import java.awt.print.Book;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.mzgd.model.BookModel;

public class BookDaoTest {

	private static BookDao bookDao = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bookDao = new BookDao();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	 
	@Test
	public void insertTest() {
		BookModel bookModel = new BookModel();
		bookModel.setName("十万个为什么");
		bookModel.setNum(125);
		bookModel.setCatogary("科普读物");
		bookModel.setPrice(55.5);
		bookDao.insert(bookModel);
	}
	
	
	@Test
	public void DeleteByIdTest() {
		bookDao.deleteById(2);
	}
	
	@Test
	public void queryByNameTest() {
		ArrayList<BookModel> alist= new ArrayList<BookModel>();
		alist = bookDao.queryByName("十");
	}
	
	@Test
	public void queryByIdTest() {
		BookModel bookModel = new BookModel();
		bookModel = bookDao.queryById(119);
		System.out.println(bookModel);
	}
	
	@Test
	public void updateTest() {
		BookModel bookModel = new BookModel();
		bookModel=bookDao.queryById(6);
		System.out.println(bookModel.toString());
		bookModel.setNum(2222);
		bookModel.setPrice(11.11);
		System.out.println(bookModel.toString());
		bookDao.update(bookModel);
	}
	
	
	

}
