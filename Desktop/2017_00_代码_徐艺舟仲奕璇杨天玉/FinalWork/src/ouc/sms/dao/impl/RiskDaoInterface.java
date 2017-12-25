package ouc.sms.dao.impl;

import java.util.Map;

import ouc.sms.entity.Risks;

public interface RiskDaoInterface {
	public boolean saveRisk(Risks Risk);
	public boolean updateRisk(Risks Risk);
	public Risks findOneRisk(int eno);
	public Map<Integer, Risks> findAllRisk();

}
