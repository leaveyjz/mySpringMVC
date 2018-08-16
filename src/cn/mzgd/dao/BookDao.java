package cn.mzgd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.mzgd.model.BookModel;

public class BookDao extends BaseDao<BookModel>{

	public int insert(BookModel bookModel) {
		String sql = "insert into books(num,name,catogary,price) values (?,?,?,?)";
		return super.executeUpdate(sql,new Object[] {bookModel.getNum(),bookModel.getName(),
				bookModel.getCatogary(),bookModel.getPrice()});
	}
	
	public int update(BookModel bookModel) {
		String sql = "update books set num=?,name=?,price=?,catogary=? where id=?";
		return super.executeUpdate(sql,new Object[] {bookModel.getNum(),bookModel.getName(),
				bookModel.getPrice(),bookModel.getCatogary(),bookModel.getId()});
	}
	
	public int deleteById(int id) {
		String sql = "delete from books where id=?";
		return super.executeUpdate(sql,id );
	}
	
	public ArrayList<BookModel> queryByName(String keyword){
		String sql = "select * from books where name like ?";
		System.out.println(sql);
		return super.executeQuery(sql, "%"+keyword+"%");
		
	}
	
	public BookModel queryById(int id){
		String sql = "select * from books where id = ?";
		ArrayList<BookModel> aList = new ArrayList<BookModel>();
		aList = super.executeQuery(sql, id);
		System.out.println(aList.isEmpty()?null:aList.get(0));
		return aList.isEmpty()?null:aList.get(0);
		
	}
	
	
	
	@Override
	public BookModel getRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		BookModel bookModel = null;
		bookModel = new BookModel();
		bookModel.setId(rs.getInt("id"));
		bookModel.setNum(rs.getInt("num"));
		bookModel.setName(rs.getString("name"));
		bookModel.setCatogary(rs.getString("catogary"));
		bookModel.setPrice(rs.getDouble("price"));
		bookModel.setDate(rs.getDate("date"));
	    System.out.println(bookModel.toString());
		return bookModel;
	}
	
}
