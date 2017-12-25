package ouc.sms.entity;

import java.util.Date;

import ouc.sms.util.InputUtil;

public class Projects {

	/*
	 * ������Ŀ���prono	������Ŀ����proname	������Ŀ���ձ��rsno	������Ŀ������ֵ	������Ŀ����prodesc
	 */
	private int proNo;       //1��Ŀ���
	private String proName;  //2��Ŀ����
	private int rsNo;        //7�������ͱ��
	private String mngNo;    //8������,�����������˵�
	private int proScore;    //3��Ŀ�������֣��ɼ���˸���
	private String proDesc;  //4��Ŀ���������걨���ύ
	private String proTime;    //5����ʱ�䣬��Ŀ������ʱ��
	private String proMethod; //6��Ŀ������޴�ʩ���ɸ����˱�д
	private String proDmd;    //10��Ŀ����
	private int proSta;      //9��Ŀ�����������ɼ������д
	public int getProSta() {
		return proSta;
	}
	public void setProSta(int proSta) {
		this.proSta = proSta;
	}
	private Date date;//����ʱ��
	public Date getDate() { 
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getProDmd() {
		return proDmd;
	}
	public void setProDmd(String proDmd) {
		this.proDmd = proDmd;
	}
	private String empNo;
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	
	/*
	 * 9.12
	 */
	
	public int getApplicantCheck() {
		return applicantCheck;
	}
	public void setApplicantCheck(int applicantCheck) {
		this.applicantCheck = applicantCheck;
	}
	public int getManagerCheck() {
		return managerCheck;
	}
	public void setManagerCheck(int managerCheck) {
		this.managerCheck = managerCheck;
	}
	public int getSupervisorCheck() {
		return supervisorCheck;
	}
	public void setSupervisorCheck(int supervisorCheck) {
		this.supervisorCheck = supervisorCheck;
	}
	public int getBossCheck() {
		return bossCheck;
	}
	public void setBossCheck(int bossCheck) {
		this.bossCheck = bossCheck;
	}
	private int applicantCheck=0;
	private int managerCheck=0;
	private int supervisorCheck=0;
	private int bossCheck=0;
	
	private String applicantNo=null;
	
	public String getApplicantNo() {
		return applicantNo;
	}
	public void setApplicantNo(String applicantNo) {
		this.applicantNo = applicantNo;
	}
	/*
	 * ����������Ϣ
	*/
	public Projects(int rsNo,String mngNo,int proNo,String proName,String proDesc){
		this.proNo=proNo;
		this.proName=proName;
	
		this.rsNo=rsNo;
	
		this.mngNo=mngNo;
		this.proDesc=proDesc;
		/*
		 * xyz
		 */
		
	}
	public Projects(int pno, String pname,String applicantNo,String ptime, int rno, int pscore, String mngno, String pdesc, String pmethod, String pdmd,int prosta){
		this.proNo=pno;
		this.proName=pname;
		this.proTime=ptime;
		this.rsNo=rno;
		this.proScore=pscore;
		this.mngNo=mngno;
		this.proDesc=pdesc;
		this.proMethod=pmethod;
		this.proDmd=pdmd;
		this.proSta=prosta;
		/*
		 * xyz
		 */
		this.applicantNo=applicantNo;
		
	}
	
	/*
	 * �����������˵�����θ��ݷ��ձ�ţ�find���ű�ţ��ٸ��ݲ��ű�ţ�find�����˱�ţ��ȼ���ֻ��һ��mng�����ݲ��źžͿ����ҵ�mng
	*/
	
	public int getRsNo() {
		return rsNo;
	}
	public void setRsNo(int rsNo) {
		this.rsNo = rsNo;
	}
	public String getMngNo() {
		return mngNo;
	}
	public void setMngNo(String mngNo) {
		this.mngNo = mngNo;
	}

	public String getProMethod() {
		return proMethod;
	}
	public void setProMethod(String proMethod) {
		this.proMethod = proMethod;
	}

	public String getProTime() {
		return proTime;
	}
	public void setProTime(String proTime) {
		this.proTime = proTime;
	}
	public int getProNo() {
		return proNo;
	}
	public void setProNo(int proNo) {
		this.proNo = proNo;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}

	public int getProScore() {
		return proScore;
	}
	public void setProScore(int proScore) {
		this.proScore = proScore;
	}
	public String getProDesc() {
		return proDesc;
	}
	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}
    public void inputPro(){
		
		this.proNo = InputUtil.getIntInput("Please input a no:");
		this.proName=InputUtil.getStringInput("Please input a name:");
		getRandScore();
		this.proDesc= InputUtil.getStringInput("Please input a Desc:");
		this.rsNo= InputUtil.getIntInput("Please input a Rsno:");
		
	}
	public int getRandScore(){
		System.out.println("Please input the proScore:");
		this.proScore=(int)(Math.random()*100);
		System.out.println(proScore);
		return proScore;
	}
	
	public Projects(){}

	

	
	
	
}
