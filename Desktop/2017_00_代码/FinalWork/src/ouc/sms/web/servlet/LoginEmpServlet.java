package ouc.sms.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ouc.sms.dao.EmpDao;
import ouc.sms.entity.Employees;


public class LoginEmpServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginEmpServlet() {
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
		try {
			String ncName=request.getParameter("ncName");
			String pwd=request.getParameter("pwd");
			Employees emp=new Employees();
			emp.setNcName(ncName);
			emp.setPwd(pwd);
			EmpDao ed=new EmpDao();
			//�����ƣ�
			
			Map<Object,Employees> map=ed.findAllEmp();
			for(Employees ey:map.values()){
				if(ey.getNcName().equals(emp.getNcName())){
					if(ey.getPwd().equals(emp.getPwd())){
						String empNo=ey.getEmpNo();
						HttpSession session = request.getSession();
						session.setAttribute("empNo", empNo);
						request.setAttribute("empNo", empNo);
						request.setAttribute("msg","登录成功");
						request.setAttribute("currentEmp", emp);  
						request.getRequestDispatcher("/privilegeServlet").forward(request, response);
					}else{
						request.setAttribute("msg","密码错误");
						request.getRequestDispatcher("/login_emp.jsp").forward(request, response);
					}
				}
			}
			
			request.setAttribute("msg","对不起，您还未注册");
			request.getRequestDispatcher("/login_emp.jsp").forward(request, response);
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
