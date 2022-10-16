package ouc.sms.entity;

import java.util.Map;

import ouc.sms.dao.impl.RiskDaoInterface;
import ouc.sms.util.InputUtil;

public class Risks{
	
	private int rsNo;
	private String rsName;
	private String mngNo; 

	/*
	 * 
	 */
	public Risks(){}
	
	public Risks(int rno,String rname,String mngno){
		this.rsNo = rno;
		this.rsName = rname;
		this.mngNo=mngno;
	}
	
	/*
	 * 输入 risk
	 */
	public void inputRisk(){
		
		this.rsNo = InputUtil.getIntInput("Please input a risk no:");
		this.rsName = InputUtil.getStringInput("Please input the risk name:");
	}

	public int levelOfRisk(int rln){
		/*
		 * judge the level of risk
		 * 
		 * riskLevel |  meaning 
		 *--------------------
		 *     4        repair
		 *     3        improve
		 *     2        good 
		 *     1        perfect 
		 */
		if(rln>80){
			return 4;
		}else if(rln>20){
			return 3;
		}else if(rln>5){
			return 2;
		}else{
			return 1;
		}
	}
	
	public int getRsNo() {
		return rsNo;
	}
	public void setRsNo(int rsNo) {
		this.rsNo = rsNo;
	}
	public String getRsName() {
		return rsName;
	}
	public void setRsName(String rsName) {
		this.rsName = rsName;
	}

	public String getMngNo() {
		return mngNo;
	}

	public void setMngNo(String mngNo) {
		this.mngNo = mngNo;
	}
	
	


}
