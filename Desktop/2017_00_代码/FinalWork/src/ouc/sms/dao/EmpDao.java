package ouc.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import ouc.sms.dao.impl.EmpDaoInterface;
import ouc.sms.entity.Employees;
import ouc.sms.entity.Projects;

public class EmpDao implements EmpDaoInterface{
	public static Map<Object,Employees> map = new HashMap<Object,Employees>();//������̬������������ȥ��
//	static{
//		map.put(1, new Employees("EMP001","Tom","tom","123","MNG001"));
//		map.put(2, new Employees("EMP002","Mary","mary","456","MNG001"));
//		map.put(3, new Employees("MNG003","Laura","laura","456",""));
//		map.put(4, new Employees("SPV001","Sam","sam","456",""));
//		map.put(5, new Employees("BOS002","Dan","dan","456",""));
//	}
	/*
	 * ��½
	*/
	static int no=20;
	public String getProNo(String eprvl){
		String noPlus=Integer.toString(no);
		String zero="000";
		String zeroPlus=zero.substring(noPlus.length());
		return eprvl+zeroPlus+(no++);
	}
	public float getEmpSal(String eprvl){
		float empSal=2000;
		if(eprvl.equals("BOS")){
		    empSal=(float)(Math.random()*20000+20000);
		}else if(eprvl.equals("SUP")){
			empSal=(float)(Math.random()*10000+10000);
		}else if(eprvl.equals("MNG")){
			empSal=(float)(Math.random()*5000+5000);
		}else {
			empSal=(float)(Math.random()*2500+2500);
		}
		return empSal;
	}
	
	public Employees login(Employees emp){
		Map<Object,Employees> map=this.findAllEmp();

		for(Employees ey:map.values()){
			if(ey.getNcName().equals(emp.getNcName())&&ey.getPwd().equals(emp.getPwd())){
				
				return ey;
			}
		}
		return null;
	}
	public boolean saveEmp(Employees emp){
		String sql="insert into FinalWork.EMPLOYEES(empNo,empName,ncName,pwd,mngno)"
				+ "values (?,?,?,?,?)";
		Object[] values={emp.getEmpNo(),emp.getEmpName(),emp.getNcName(),emp.getPwd(),emp.getMngNo()};
				//empNo, String empName, String ncName,String pwd, String mngno};//<- Date date=null;
		return BaseDao.executeUpdate(sql, values);
	}
	public boolean updateEmp(Employees emp){
		String sql="update FinalWork.EMPLOYEES set empName=?,ncName=?,pwd=?,mngno=? where empNo=?";
		Object[] values={emp.getEmpName(),emp.getNcName(),emp.getPwd(),emp.getMngNo(),emp.getEmpNo()};
				//empNo, String empName, String ncName,String pwd, String mngno};//<- Date date=null;
		return BaseDao.executeUpdate(sql, values);
	}
	public Employees findOneEmp(String empNo){
		String sql="select * from FinalWork.employees where EMPNO=?";
    	Connection conn=null;
    	ResultSet rs = null;
    	PreparedStatement ps = null;
    	Map<Integer,Employees> map = null;
        try{
            conn=BaseDao.getConnection();
            ps=conn.prepareStatement(sql); 
            ps.setString(1, empNo);        
            rs=ps.executeQuery();
           
            if(rs.next()){//String empNo, String empName, String ncName,String pwd, String mngno
            Employees emp=new Employees(empNo,rs.getString("empName"),rs.getString("ncName"),rs.getString("pwd"),rs.getString("mngno"));
            return emp;
            }
            
        }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        finally{
        	BaseDao.closeAll(conn, ps, rs);
        	
        }
		return null;
	}
	public Map<Object, Employees> findAllEmp(){
		String sql="select * from FinalWork.employees";
    	Connection conn=null;
    	ResultSet rs = null;
    	PreparedStatement ps = null;
    	
        try{
            //调用Class.forName()方法加载驱动程序
        	
//          Class.forName("com.mysql.jdbc.Driver");//驱动类异常//*******0907［1］********
            conn=BaseDao.getConnection();//*******0907［1］********
            ps=conn.prepareStatement(sql);       
            rs=ps.executeQuery();
           
            while(rs.next()){
            	//Object a=rs.getInt("EMPLOYEE_ID");//根据列名去改列的值
            String empNo=rs.getString("empNo");
            Employees emp=new Employees(empNo,rs.getString("empName"),rs.getString("ncName"),rs.getString("pwd"),rs.getString("mngno"));
            map.put(empNo,emp);
            }
            
        }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        finally{
        	BaseDao.closeAll(conn, ps, rs);
        	
        }
		return map;
	}
	
}
