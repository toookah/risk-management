package ouc.sms.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ouc.sms.dao.ProDao;
import ouc.sms.entity.Projects;

public class WaitAuditProServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public WaitAuditProServlet() {
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
		try {
			request.setCharacterEncoding("UTF-8");//�����������룻��������ҳ�����ʹ��UTF-8;��ΪPOST����
			
			ProDao pd=new ProDao();

			Map<Object, Projects> waitMap=new HashMap();
//			Map<Object, Projects> useMap=new HashMap();
			waitMap=pd.findWaitPro(2);
			
			HttpSession session = request.getSession(); 
			Object empNo=session.getAttribute("empNo");
			System.out.println("empNo"+empNo);
			
			
			System.out.println("zcavd  xxxxxx");
			
//			for(Projects pro:waitMap.values()){
//				System.out.println(pro.getMngNo());
//				String mngno=pro.getMngNo();
//				String supno;
//				
//				if(mngno.equals("MNG001")){
//					supno="SPV001";
//				}else{
//					supno="SPV002";
//				}
//				if(supno.equals(empNo)){
//					useMap.put(pro.getProNo(), pro);
//					System.out.println(pro.getProNo());
//				}
//			}
//			System.out.println("tioazhaun");
			
			request.setAttribute("waitAuditProjects", waitMap);
			request.getRequestDispatcher("/wait_audit_pro.jsp")
				.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
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
