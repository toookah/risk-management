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

public class AuditProServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AuditProServlet() {
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
		request.setCharacterEncoding("UTF-8");
		Projects pro=new Projects();
		ProDao pd=new ProDao();
		Employees sup=new Supervisors();
		Employees mng=new Managers();
		
		String pronoStr=request.getParameter("prono");	
		int prono=Integer.valueOf(pronoStr).intValue();
		pro=pd.findOnePro(prono);
		String scoreStr=request.getParameter("score");	
		int score=Integer.valueOf(scoreStr).intValue();

		String demmand=request.getParameter("demmand");	
		String describe=request.getParameter("describe");	
		
		String submit=request.getParameter("submit");	
		/*r
		 * ������ύ��˽��
		 */
		
			/*
			 * fail
			 */
		if(submit.equals("fail")){
			pro.setProSta(4);
			pro.setSupervisorCheck(0);
			pro.setManagerCheck(1);
			
		}else{
			pro.setProSta(3);
			pro.setManagerCheck(1);
		}
		System.out.println("ProSta"+pro.getProSta());
		pro.setProScore(score);	
		pro.setProDmd(demmand);
		pro.setProDesc(describe);
		pd.updatePro(pro);

		/*
		 * ���ش���ҳ��
		 */
		Map<Object, Projects> waitMap=new HashMap();
		waitMap=pd.findWaitPro(2);
		
//		request.setAttribute("whoIsNow",whoIsNow);
		request.setAttribute("waitProjects", waitMap);
		
		request.getRequestDispatcher("/wait_audit_pro.jsp")
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
