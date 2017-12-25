package ouc.sms.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ouc.sms.dao.ProDao;
import ouc.sms.entity.Employees;
import ouc.sms.entity.Managers;
import ouc.sms.entity.Projects;
import ouc.sms.entity.Supervisors;

public class SubmitProServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SubmitProServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//�����������룻��������ҳ�����ʹ��UTF-8;��ΪPOST����
		Projects pro=new Projects();
		ProDao pd=new ProDao();
		Employees sup=new Supervisors();
		Employees mng=new Managers();
		
		String pronoStr=request.getParameter("prono");	
		int prono=Integer.valueOf(pronoStr).intValue();
		pro=pd.findOnePro(prono);
		String promethod=request.getParameter("method");	
		/*
		 * 负责人提交结果
		 */
        
		pro=mng.dealProjects(prono,promethod);
		pro.setManagerCheck(0);
		pro.setSupervisorCheck(1);
		
		pd.updatePro(pro);
		/*
		 * 返回待办页面
		 */
		Map<Object, Projects> waitMap=new HashMap();
		waitMap=pd.findWaitPro(1);
		

		request.setAttribute("waitProjects", waitMap);
		
		request.getRequestDispatcher("/wait_pro.jsp")
			.forward(request, response);
		
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
