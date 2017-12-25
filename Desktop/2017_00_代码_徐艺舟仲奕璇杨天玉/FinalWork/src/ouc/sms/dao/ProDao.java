package ouc.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ouc.sms.dao.impl.ProDaoInterface;
import ouc.sms.entity.Employees;
import ouc.sms.entity.Projects;

public class ProDao implements ProDaoInterface{
	public static Map<Object, Projects> map = new HashMap<Object,Projects>();
	static int no=20;
	public int getProNo(){
		return (no++);
	}
    static{
//int pno, String pname,String applicantNo,Date ptime, int rno, int pscore, String mngno, String pdesc, String pmethod, String pdmd,int prosta
//    	map.put(1,new Projects(1,"111","MNG001",new Date(),1,67,"MNG001","111","1111","11111",1));
//    	map.put(2,new Projects(2,"222","SUP001",new Date(),2,35,"MNG002","222","2222","22222",1));
//    	map.put(3, new Projects(3, "ǽ��","BOS001",new Date(), 3, 89, "MNG003", "ǽƤ����", "ˮ�ಹ", "�������Ѻ�",2));
//    	map.put(4,new Projects(4,"111","EMP001",new Date(),1,67,"MNG001","111","1111","11111",1));
    }
	public boolean addPro(Projects pro) {
		String sql="insert into FinalWork.PROJECTS(pno,pname,applicantNo,ptime,rno,pscore,"
				                                + "mngno,pdesc,pmethod,pdmd,prosta)"
				+ "values (?,?,?,?,?,?,?,?,?,?,?)";
		Object[] values={pro.getProNo(),pro.getProName(),pro.getApplicantNo(),pro.getProTime(),pro.getRsNo(),pro.getProScore(),
				         pro.getMngNo(),pro.getProDesc(),pro.getProMethod(),pro.getProDmd(),pro.getProSta()};
				//int pno, String pname,String applicantNo,Date ptime, int rno, int pscore, String mngno, String pdesc, String pmethod, String pdmd,int prosta
		return BaseDao.executeUpdate(sql, values);
	}
    
	public boolean savePro(Projects pro){
		String sql="insert into FinalWork.PROJECTS(pno,pname,applicantNo,ptime,rno,pscore,"
                + "mngno,pdesc,pmethod,pdmd,prosta)"
		+ "values (?,?,?,?,?,?,?,?,?,?,?)";
		Object[] values={pro.getProNo(),pro.getProName(),pro.getApplicantNo(),pro.getProTime(),pro.getRsNo(),pro.getProScore(),
		pro.getMngNo(),pro.getProDesc(),pro.getProMethod(),pro.getProDmd(),pro.getProSta()};
		return BaseDao.executeUpdate(sql, values);
	}
	public boolean updatePro(Projects pro){
		String sql="update FinalWork.PROJECTS set pname=?,applicantNo=?,ptime=?,rno=?,pscore=?,"
                + "mngno=?,pdesc=?,pmethod=?,pdmd=?,prosta=? where pno=?";
		Object[] values={pro.getProName(),pro.getApplicantNo(),pro.getProTime(),pro.getRsNo(),pro.getProScore(),
				pro.getMngNo(),pro.getProDesc(),pro.getProMethod(),pro.getProDmd(),pro.getProSta(),pro.getProNo()};
		return BaseDao.executeUpdate(sql, values);
	}
	public Projects findOnePro(int pno){
		String sql="select * from FinalWork.PROJECTS where pno=?";
    	Connection conn=null;
    	ResultSet rs = null;
    	PreparedStatement ps = null;
    	Map<Integer,Employees> map = null;
        try{
            conn=BaseDao.getConnection();
            ps=conn.prepareStatement(sql); 
            ps.setInt(1, pno);        
            rs=ps.executeQuery();
           
            if(rs.next()){
            	//int pno, String pname,String applicantNo,Date ptime, int rno, 
            	//int pscore, String mngno, String pdesc, String pmethod, String pdmd,int prosta
            	
            Projects pro=new Projects(pno,rs.getString("pname"),rs.getString("applicantNo"),
            		     rs.getString("ptime"),rs.getInt("rno"),rs.getInt("pscore"),
            		     rs.getString("mngno"),rs.getString("pdesc"),rs.getString("pmethod"),
            		     rs.getString("pdmd"),rs.getInt("prosta"));
            return pro;
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
	
	
	public Map<Object, Projects> findWaitPro(int proSta){
		Map<Object, Projects> waitMap = new HashMap<Object,Projects>();
		map=this.findAllPro();
		for(Projects pj:map.values()){
			if(pj.getProSta()==proSta){
				waitMap.put(waitMap.size()+1, pj);
			}
		}
		return waitMap;		
	}
	public Map<Object, Projects> findAllPro(){
		String sql="select * from FinalWork.PROJECTS";
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
            int pno=rs.getInt("pno");
            Projects pro=new Projects(pno,rs.getString("pname"),rs.getString("applicantNo"),
       		     rs.getString("ptime"),rs.getInt("rno"),rs.getInt("pscore"),
       		     rs.getString("mngno"),rs.getString("pdesc"),rs.getString("pmethod"),
       		     rs.getString("pdmd"),rs.getInt("prosta"));
            map.put(pno,pro);
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
