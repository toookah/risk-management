package ouc.sms.dao.impl;

import java.util.Map;

import ouc.sms.entity.Projects;

public interface ProDaoInterface {
	public boolean savePro(Projects Pro);
	public boolean updatePro(Projects Pro);
	public Projects findOnePro(int eno);
	public Map<Object, Projects> findWaitPro(int proSta);
	public Map<Object, Projects> findAllPro();
	public boolean addPro(Projects project);
}
