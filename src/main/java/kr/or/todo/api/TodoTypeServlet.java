package kr.or.todo.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.TodoDto;

@WebServlet("/main/*")
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodoTypeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
		TodoDao dao = new TodoDao();
		long id = Long.parseLong(request.getParameter("id"));
		String type = request.getParameter("type");
		TodoDto todo = new TodoDto(id, type);
		
		int result = dao.updateTodo(todo);
		
		if(result != 1) {
			System.out.println("fail");
		}else {
			System.out.println("success");
		}
	}
}
