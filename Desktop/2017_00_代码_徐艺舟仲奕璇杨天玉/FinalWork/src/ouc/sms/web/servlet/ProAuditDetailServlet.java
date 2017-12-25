package ouc.sms.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ouc.sms.dao.ProDao;
import ouc.sms.dao.RiskDao;
import ouc.sms.entity.Projects;
import ouc.sms.entity.Risks;

public class ProAuditDetailServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ProAuditDetailServlet() {
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
		int prono=0;
		String mngdepno=null;
		Projects pro=new Projects();
		Risks rs=new Risks();
		
		ProDao pd=new ProDao();
		RiskDao rd=new RiskDao();
		
		Map<Object, Projects> waitMap=new HashMap<Object, Projects>();
		
		Map<Integer, Risks> riskMap=new HashMap<Integer, Risks>();
		riskMap=rd.findAllRisk();
		
		String pronoStr=request.getParameter("proNo");		
		prono=Integer.valueOf(pronoStr).intValue();

		
		rs=riskMap.get(prono);		
//		mngdepno=rs.getMngNo();


		waitMap=pd.findAllPro();
		request.setAttribute("waitProjects", waitMap);
		
//		request.setAttribute("mngDepNo", mngdepno);
		request.setAttribute("prono", prono);
		
		request.getRequestDispatcher("/pro_audit_detail.jsp").forward(request, response);
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
