package ouc.sms.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PrivilegeSelectionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PrivilegeSelectionServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object empNo=request.getParameter("empNo");
	  	String eprvl=request.getParameter("eprvl");
	  	int choice=Integer.parseInt(eprvl);
		request.setAttribute("empNo", empNo);
		
		
	
		switch(choice){
		case 1:
			request.getRequestDispatcher("/security_ordinary.jsp").forward(request, response);
			break;
		case 2:
			request.getRequestDispatcher("/security_manager.jsp").forward(request, response);
			break;
		case 3:
			request.getRequestDispatcher("/security_supervisor.jsp").forward(request, response);
			break;
		case 4:
			request.getRequestDispatcher("/security_boss.jsp").forward(request, response);
			break;
		}
		//session.removeAttribute("currentEmp");
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
