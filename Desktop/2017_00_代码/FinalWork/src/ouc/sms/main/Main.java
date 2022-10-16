package ouc.sms.main;

import ouc.sms.dao.EmpDao;
import ouc.sms.entity.Employees;

public class Main {
	public static void main(String[] args) {
		Employees emp=new Employees("EMP001","Tomtest","tomtest","123","MNG002");
		Employees emp2=new Employees("EMP002","Tomtest","tomtest","123","MNG002");
		EmpDao ed=new EmpDao();
		System.out.println(ed.getProNo("EMP"));

		
//		Projects pro=new Projects();
//		pro.inputPro();
//		System.out.println("----------------------");
//		emp.create(pro);
//		emp.checkService();
//		System.out.println("----------------------");
//		Employees mng=new Managers();
//		mng.checkService();
//		System.out.println("----------------------");
//		Employees sup=new Supervisors();
//		sup.auditLoop(pro.getProNo());
//		sup.checkService();
		
	}

}
