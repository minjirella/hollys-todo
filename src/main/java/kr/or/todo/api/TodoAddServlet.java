package kr.or.todo.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.TodoDto;

@WebServlet("/new")
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	public TodoAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		request.setCharacterEncoding("utf-8");
		
		TodoDao dao = new TodoDao();
		
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		int sequence = Integer.parseInt(request.getParameter("sequence"));
		TodoDto todo = new TodoDto(title, name, sequence);
		
		int result = dao.insertTodo(todo);
		
		if(result != 1) {
			response.sendRedirect("/Todo/form");
			System.out.println("fail");
		}else {
			response.sendRedirect("/Todo/main");
			System.out.println("success");
		}
	}

}
