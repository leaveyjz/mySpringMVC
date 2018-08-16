package cn.mzgd.servlet;

import java.awt.print.Book;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.mzgd.model.BookModel;
import cn.mzgd.service.BookService;
import jdk.management.resource.ResourceRequestDeniedException;

@WebServlet("/postForm")
public class BookServlet extends HttpServlet {

	public BookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		String type = request.getParameter("type");
		
		if ("insert".equals(type)) {
			BookModel bookModel = new BookModel();
			bookModel.setNum(Integer.parseInt(request.getParameter("num")));
			bookModel.setName(request.getParameter("name"));
			bookModel.setCatogary(request.getParameter("catogary"));
			bookModel.setPrice(Double.parseDouble(request.getParameter("price")));
			BookService bookService = new BookService();
			bookService.insert(bookModel);
			response.sendRedirect(request.getContextPath() + "/query.jsp");
		} else if ("getByName".equals(type)) {
			BookService bookService = new BookService();
			ArrayList<BookModel> bookList = new ArrayList<BookModel>();
			String name = request.getParameter("name");
			bookList = bookService.queryByName(name);
			session.setAttribute("name", name);
			request.setAttribute("bookList", bookList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/query.jsp");
			dispatcher.forward(request, response);
		}else if("delete".equals(type)){
			int id = Integer.parseInt(request.getParameter("id"));
			BookService bookService = new BookService();
			bookService.deleteById(id);
	        String name = (String) session.getAttribute("name");
			ArrayList<BookModel> bookList = new ArrayList<BookModel>();
			bookList = bookService.queryByName(name);
			request.setAttribute("bookList", bookList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/query.jsp");
			dispatcher.forward(request, response);
		}else if ("getById".equals(type)) {
			BookModel bookModel = new BookModel();
			BookService bookService = new BookService();
			int id = Integer.parseInt(request.getParameter("id"));
			bookModel = bookService.queryById(id);
			request.setAttribute("book", bookModel);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/update.jsp");
			dispatcher.forward(request, response);
		}else if ("update".equals(type)) {
			BookModel bookModel = new BookModel();
			bookModel.setId(Integer.parseInt(request.getParameter("id")));
			bookModel.setNum(Integer.parseInt(request.getParameter("num")));
			bookModel.setName(request.getParameter("name"));
			bookModel.setPrice(Double.parseDouble(request.getParameter("price")));
			bookModel.setCatogary(request.getParameter("catogary"));
			BookService bookService = new BookService();
			bookService.update(bookModel);
			ArrayList<BookModel> bookList = new ArrayList<BookModel>();
			String name = (String) session.getAttribute("name");
			bookList = bookService.queryByName(name);
			request.setAttribute("bookList", bookList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/query.jsp");
			dispatcher.forward(request, response);
		}
	}
}
