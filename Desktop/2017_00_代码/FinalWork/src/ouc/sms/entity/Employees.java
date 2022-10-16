package ouc.sms.entity;

import java.util.Map;

import ouc.sms.dao.ProDao;
public class Employees {
	private String empNo;//++
	private String empName;
	private String empId;
	private String phNo;
	private String email;
	private String ncName;
	private String pwd;
	private int jobNo;//limit
	private float sal;
	private int depNo;
	private String mngNo;
	/*
	 * 鏋勯�鍑芥暟
	 */
	public Employees(){
		
	}
	
//	public Employees(String empNo, String empName, String ncName,String pwd) {
//		// TODO Auto-generated constructor stub
//		this.empNo=empNo;
//		this.empName=empName;
//		this.ncName=ncName;
//		this.pwd=pwd;
//	}
//	
	public Employees(String empNo, String empName, String ncName,String pwd, String mngno) {
		// TODO Auto-generated constructor stub
		this.empNo=empNo;
		this.empName=empName;
		this.ncName=ncName;
		this.pwd=pwd;
		this.mngNo=mngno;
	}
	
	public String getEmpNo() {
		
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNcName() {
		return ncName;
	}
	public void setNcName(String ncName) {
		this.ncName = ncName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getJobNo() {
		return jobNo;
	}
	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	public int getDepNo() {
		return depNo;
	}
	public void setDepNo(int depNo) {
		this.depNo = depNo;
	}
	public String getMngNo() {
		return mngNo;
	}
	public void setMngNo(String mngNo) {
		this.mngNo = mngNo;
	}
	
	public void create(Projects pro){
		ProDao rd=new ProDao();
		rd.savePro(pro);
		//浼犲�缁欐暟鎹簱
		System.out.println("risks submit");
	}
	public void check(){
		
		ProDao pd=new ProDao();
		Map<Object,Projects> map=pd.findAllPro();
		for(Projects pj:map.values()){
			System.out.println(pj.getProNo()+" "+pj.getProName()+" "
		+pj.getProScore()+" "+pj.getProDesc()+" "+pj.getRsNo());
		}
		
	}
	public void checkService(){
		System.out.println("emp check");
		check();
		
	}
	public void auditLoop(int rno){
		
	}
	public boolean audit(int rno){
		return false;
	}
	public Projects dealProjects(int prono,String proMethod){
		return null;
	}
	

}
