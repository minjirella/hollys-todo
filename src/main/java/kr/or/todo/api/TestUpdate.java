package kr.or.todo.api;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.TodoDto;

public class TestUpdate {
	public static void main(String[] args) {
		String type = "DOING";
		Long id = (long) 2;
		
		TodoDto todo = new TodoDto(id, type);
		TodoDao dao = new TodoDao();
		
		int updateCnt = dao.updateTodo(todo);
		
		System.out.println(updateCnt);
	}
}
