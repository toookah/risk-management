package ouc.sms.entity;

import ouc.sms.dao.impl.DeptDaoInterface;



public class Departments implements DeptDaoInterface{
	private int depNo;
	private String depName;
	private String mngNo;
	public Departments(){}
	
    public Departments(int depno,String depname,String mngno){  //部门编号，部门名称，部门负责人
		this.depNo=depno;
		this.depName=depname;
		this.mngNo=mngno;
	}
	public int getDepNo() {
		return depNo;
	}
	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getMngNo() {
		return mngNo;
	}
	public void setMngNo(String mngNo) {
		this.mngNo = mngNo;
	}

}
