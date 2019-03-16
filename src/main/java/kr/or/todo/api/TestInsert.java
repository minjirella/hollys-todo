package kr.or.todo.api;

import java.util.ArrayList;
import java.util.List;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.TodoDto;

public class TestInsert {

	public static void main(String[] args) {
//		//1
		String title = "Learn Maven&JDBC";
		String name = "minji";
		int seq = 1;
		//2
		String title1 = "Drum";
		String name1 = "minji";
		int seq1 = 1;
		
		TodoDto todo = new TodoDto(title, name, seq);
		TodoDto todo1 = new TodoDto(title1, name1, seq1);
		TodoDao dao = new TodoDao();
		
		int insertCnt = dao.insertTodo(todo);
		insertCnt = dao.insertTodo(todo1);
		
		System.out.println(insertCnt);
		
// 2
//		TodoDao dao = new TodoDao();
//		List<TodoDto> todo = new ArrayList<TodoDto>();
//		List<TodoDto> doing = new ArrayList<TodoDto>();
//		List<TodoDto> done = new ArrayList<TodoDto>();
//		List<TodoDto> list = dao.getTodos();
//		
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).getType());
//			if(list.get(i).getType().equals("TODO")) {
//				todo.add(list.get(i));
//			}else if(list.get(i).getType().equals("DOING")) {
//				doing.add(list.get(i));
//			}else {
//				done.add(list.get(i));
//			}
//		}
//		for(int i=0; i<todo.size(); i++) {
//			System.out.println(todo.get(i));
//		}
//		
	}
}
