package kr.or.todo.api;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.TodoDto;

public class TestUpdate {
	public static void main(String[] args) {
		String type = "DONE";
		Long id = (long) 4;
		
		TodoDto todo = new TodoDto(id, type);
		TodoDao dao = new TodoDao();
		
		int updateCnt = dao.updateTodo(todo);
		
		System.out.println(updateCnt);
	}
}
