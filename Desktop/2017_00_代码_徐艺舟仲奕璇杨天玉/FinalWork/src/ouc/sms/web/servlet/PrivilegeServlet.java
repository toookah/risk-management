package ouc.sms.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ouc.sms.entity.Employees;

public class PrivilegeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PrivilegeServlet() {
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
		String empNo=(String)request.getAttribute("empNo");
		String prvl=empNo.substring(0, 3);
		/*
		 * xyz
		 */
		int eprvl=1;
		if(prvl.equals("BOS")){
			eprvl=4;
		}
		if(prvl.equals("SPV")){
			eprvl=3;
		}
		if(prvl.equals("MNG")){
			eprvl=2;
		}
		request.setAttribute("empNo",empNo);
		request.setAttribute("eprvl",eprvl);
		request.getRequestDispatcher("/primary_menu.jsp").forward(request, response);
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
