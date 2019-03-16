package kr.or.todo.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.todo.dao.TodoDao;
import kr.or.connect.todo.dto.TodoDto;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MainServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
		TodoDao dao = new TodoDao();
		List<TodoDto> todo = new ArrayList<TodoDto>();
		List<TodoDto> doing = new ArrayList<TodoDto>();
		List<TodoDto> done = new ArrayList<TodoDto>();
		List<TodoDto> list = dao.getTodos();
		
		for(int i=0; i<list.size(); i++) {
			switch (list.get(i).getType()) {
			case ("TODO"):
				todo.add(list.get(i));
				break;
			case ("DOING"):
				doing.add(list.get(i));
				break;
			default:
				done.add(list.get(i));
			}
		}

		request.setAttribute("todo", todo);
		request.setAttribute("doing", doing);
		request.setAttribute("done", done);
		
        RequestDispatcher rd= request.getRequestDispatcher("/main.jsp");
        rd.forward(request, response);
	}

}
