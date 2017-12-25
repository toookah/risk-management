package ouc.sms.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class BaseDao {
	private static final String driverClass="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/FinalWork";
	private static final String username="root";
	private static final String passwords="12345";
	static{
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(url,username,passwords);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void closeAll(Connection conn,PreparedStatement ps,ResultSet rs){
		try {
			if(rs!=null)
				rs.close();
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static boolean executeUpdate(String sql,Object[] values){
		Connection conn=null;
		PreparedStatement ps=null;
		
		try {
			conn=BaseDao.getConnection();
			
			ps=conn.prepareStatement(sql);
			for(int i=0;i<values.length;i++){
				ps.setObject(i+1, values[i]);
				
			}
			int row=ps.executeUpdate();
			return row>=0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			BaseDao.closeAll(conn, ps, null);
		}
		return false;
		
	}

}
