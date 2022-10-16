package ouc.sms.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ouc.sms.dao.ProDao;
import ouc.sms.dao.RiskDao;
import ouc.sms.dao.impl.ProDaoInterface;
import ouc.sms.entity.Projects;
import ouc.sms.entity.Risks;

public class SaveProServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SaveProServlet() {
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session=request.getSession();
			request.setCharacterEncoding("UTF-8");
			
			ProDao pd=new ProDao();
			String riskNo=request.getParameter("rsNo");
			String rsName=request.getParameter("rsName");
			int rsNo=Integer.valueOf(riskNo);           //rsNo��������
			String mngNo=request.getParameter("mngno"); //mngNo��Ŀ����
			//����
			
			int proNo=pd.getProNo();

			//System.out.println(prono);
			//int proNo=Integer.valueOf(prono);              //proNo������Ŀ���
			//����
			String proName=request.getParameter("proname");//proName������Ŀ����
			String proDesc=request.getParameter("prodesc");//proDesc������Ŀ����
			String protime=request.getParameter("protime");
			/*
			 * xyz
			 */
			RiskDao rd=new RiskDao();
			Risks risk=new Risks(rsNo,mngNo,rsName);
			rd.saveRisk(risk);
			
			String appNo=(String)session.getAttribute("empNo");
//			
			//��ǰʱ����Ҫ�ӷ���
			Projects project= new Projects(rsNo,mngNo,proNo,proName,proDesc);
			project.setProSta(1);
			project.setManagerCheck(1);
			project.setApplicantNo(appNo);
			project.setProTime(protime);
			project.setProScore((int)(Math.random()*40+60));

			String prvl=appNo.substring(0, 3);
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
			
//			
			if(pd.addPro(project)){
				//�ɹ�
				request.setAttribute("msg", "创建成功");
				
			}else {
				//ʧ��
				request.setAttribute("msg", "创建失败");
			}
			switch(eprvl){
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
			session.removeAttribute("newPro");
		} catch (NumberFormatException e) {
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














