package ouc.sms.dao.impl;

import java.util.Map;

import ouc.sms.entity.Employees;
import ouc.sms.entity.Projects;

public interface EmpDaoInterface {
	public Employees login(Employees emp);
	public boolean saveEmp(Employees emp);
	public boolean updateEmp(Employees emp);
	public Employees findOneEmp(String empNo);
	public Map<Object, Employees> findAllEmp();


}
