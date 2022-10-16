package ouc.sms.dao;

import java.util.HashMap;
import java.util.Map;

import ouc.sms.dao.impl.RiskDaoInterface;
import ouc.sms.entity.Departments;
import ouc.sms.entity.Risks;

public class RiskDao implements RiskDaoInterface{
	public static Map<Integer,Risks> riskMap = new HashMap<Integer,Risks>();
	static{
		riskMap.put(1, new Risks(1,"wall","1"));
		riskMap.put(2, new Risks(2,"rushbin","2"));
		riskMap.put(3, new Risks(3,"sky","3"));
		riskMap.put(4, new Risks(4,"qwe","4"));
		riskMap.put(5, new Risks(5,"qwe","5"));
	}
	public boolean saveRisk(Risks Risk){
		for(Risks rc:riskMap.values()){
			if(Risk.getRsNo()==(rc.getRsNo())){
				System.out.println("riskno ALREADY USED");
				return false;
			}
		}
		riskMap.put(Risk.getRsNo(),Risk);
		System.out.println("risk save success");
		return true;
	}
	public boolean updateRisk(Risks Risk){
		riskMap.put(Risk.getRsNo(), Risk);
		return true;
	}
	public Risks findOneRisk(int eno){
		for(Risks rc:riskMap.values()){
			if(rc.getRsNo()== eno){
				return rc;
			}
		}
		return null;
	}
	public Map<Integer, Risks> findAllRisk(){
		return riskMap;
	}


}
