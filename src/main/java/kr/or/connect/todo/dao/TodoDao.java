package kr.or.connect.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import kr.or.connect.todo.dto.TodoDto;

public class TodoDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "jj1234";
	
	public List<TodoDto> getTodos() {
		List<TodoDto> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String sql = "SELECT id, name, regdate, sequence, title, type FROM todo order by id desc";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
//					String description = rs.getString(1);
//					int id = rs.getInt("role_id");
//					Role role = new Role(id, description);
//					list.add(todo); // list에 반복할때마다 Role인스턴스를 생성하여 list에 추가한다.
					
					Long id = rs.getLong(1);
					String name = rs.getString(2);
					String regdate = rs.getString(3);
					int sequence = rs.getInt(4);
					String title = rs.getString(5);
					String type = rs.getString(6);
					TodoDto todo = new TodoDto(id, name, regdate, sequence, title, type);
					list.add(todo);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	public int insertTodo(TodoDto todo) {
		int insertCnt = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql = "Insert Into todo(title, name, sequence) values(?,?,?)";
		
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {
//			ps.setString(1,role.getRoleId());
			ps.setString(1, todo.getTitle());
			ps.setString(2, todo.getName());
			ps.setInt(3, todo.getSequence());
			
			insertCnt = ps.executeUpdate();
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return insertCnt;
	}
	
	public int updateTodo(TodoDto todo) {
		int updateCnt = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName( "com.mysql.jdbc.Driver" );			
			conn = DriverManager.getConnection ( dburl, dbUser, dbpasswd );			
			String sql = "update todo set type = ? where id = ?";
			
			ps = conn.prepareStatement(sql);			
			ps.setString(1, todo.getType());
			ps.setLong(2, todo.getId());
			
			updateCnt = ps.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {}
			} // if
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {}
			} // if
		} // finally
		return updateCnt;
	}
}
