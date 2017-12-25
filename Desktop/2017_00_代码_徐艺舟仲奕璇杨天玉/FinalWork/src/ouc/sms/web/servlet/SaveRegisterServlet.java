package ouc.sms.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ouc.sms.dao.EmpDao;
import ouc.sms.entity.Employees;


public class SaveRegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SaveRegisterServlet() {
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
		HttpSession session=request.getSession();
		/*if(obj==null){
			response.sendRedirect("/FinalWork/save_register.jsp");
			return;
		}*/
		
		try{
			request.setCharacterEncoding("UTF-8");
			
			String empName=request.getParameter("empName");
			String empId=request.getParameter("empid");
			String phNo=request.getParameter("pNno");
			String email=request.getParameter("email");
			String ncName=request.getParameter("ncName");
			String pwd=request.getParameter("pwd");
			
			String jjobNo=request.getParameter("eprvl");
			EmpDao ed= new EmpDao();
			String eprvl=request.getParameter("eprvl");
			String empNo=ed.getProNo(eprvl);
			
			String depNoStr=request.getParameter("depNo");
			String mngNo=request.getParameter ("mngNo");
			
			int depNo=Integer.valueOf(depNoStr);

			ncName.trim();
			Employees emp =new Employees();
			emp.setEmpNo(empNo);
			emp.setEmpName(empName);
			emp.setEmpId(empId);
			emp.setPhNo(phNo);
			emp.setEmail(email);
			emp.setNcName(ncName);
			emp.setPwd(pwd);
			emp.setSal(ed.getEmpSal(eprvl));
			emp.setDepNo(depNo);
			emp.setMngNo(mngNo);
			
			Map<Object,Employees> map=ed.findAllEmp();
			for(Employees ey:map.values()){
				if(ey.getNcName().equals(emp.getNcName())){
					request.setAttribute("msg","用户名已使用");	
					request.getRequestDispatcher("/login_emp.jsp").forward(request, response);
				}
			}
			if(ed.saveEmp(emp)){
				request.setAttribute("msg","注册成功");
				request.getRequestDispatcher("/login_emp.jsp").forward(request, response);//ҳ����ת
			}else {
				request.setAttribute("msg","注册失败");
				request.getRequestDispatcher("/save_register.jsp").forward(request, response);}
			
			
		    }catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("msg","空");
				request.getRequestDispatcher("/save_register.jsp").forward(request, response);
			}catch (NullPointerException e) {
				e.printStackTrace();
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				if(e.getMessage()==null){
					request.setAttribute("msg","其它异常");
					
				}else{
					request.setAttribute("msg",e.getMessage());
				}
				request.getRequestDispatcher("/save_register.jsp").forward(request, response);
			}
		session.removeAttribute("register");
	}
}
