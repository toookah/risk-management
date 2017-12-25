package ouc.sms.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ouc.sms.dao.ProDao;
import ouc.sms.entity.Projects;

public class ShowMyProfeedbackServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShowMyProfeedbackServlet() {
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
		
		ProDao pd=new ProDao();
		Map<Object,Projects> map=pd.findAllPro();
		request.setAttribute("myPro", map);
		request.getRequestDispatcher("/show_MyProfeedback.jsp").forward(request, response);
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
