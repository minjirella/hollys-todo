package kr.or.todo.api;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.TodoDto;

public class TestInsert {

	public static void main(String[] args) {
		//1
		String title = "Learn Maven&JDBC";
		String name = "minjirella";
		int seq = 1;
		//2
		String title1 = "Drum";
		String name1 = "minjirella";
		int seq1 = 1;
		
		TodoDto todo = new TodoDto(title, name, seq);
		TodoDto todo1 = new TodoDto(title1, name1, seq1);
		TodoDao dao = new TodoDao();
		
		int insertCnt = dao.insertTodo(todo);
		insertCnt = dao.insertTodo(todo1);
		
		System.out.println(insertCnt);
		
	}
}
