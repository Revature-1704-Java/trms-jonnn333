package servletSector;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.EmployeeDAO;
import the_beans.Employee;

/**
 * Servlet implementation class ReimbursementEntry
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// use this for more sensitive requests (ie. login info, passwords, etc.)
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("Link.html").include(request, response);
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		EmployeeDAO employeeCheck = new EmployeeDAO();
		
		if(employeeCheck.isValidEmployee(name, password) == true) {
			Employee employeeObject = new Employee();
			//employeeCheck.getEmployee("");
			
			out.print("Welcome, "+name+" (testLogin)");
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("password", password);
		}
		
		else {
			out.print("username or password incorrect!");
			request.getRequestDispatcher("Login.html").include(request, response);
		}
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	// use this for non-sensitive, small-data, small-queries
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
