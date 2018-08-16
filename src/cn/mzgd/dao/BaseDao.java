package cn.mzgd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.mzgd.utils.JdbcUtils;

public abstract class BaseDao<T> {
	
	public abstract T getRow(ResultSet rs) throws SQLException;  
	
	public int executeUpdate(String sql,Object... param) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		JdbcUtils jdbcUtils = new JdbcUtils();
		
		try {
			connection = jdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				preparedStatement.setObject(i+1, param[i]);
			}
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally{
			try {
				preparedStatement.close();
				connection.close();
			} catch (Exception e2) {
				throw new RuntimeException(e2);
			}
		}
	}
	

	public ArrayList<T> executeQuery(String sql,Object... param) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		JdbcUtils jdbcUtils = new JdbcUtils();
		ArrayList<T> objectList = new ArrayList<T>();
		
		try {
			connection = jdbcUtils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			System.out.println(preparedStatement.toString());
			for (int i = 0; i < param.length; i++) {
				preparedStatement.setObject(i+1, param[i]);
			}
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				objectList.add(this.getRow(resultSet));
			}
			return objectList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally{
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception e2) {
				throw new RuntimeException(e2);
			}
		}
	}

}
