package ouc.sms.dao;

import java.util.HashMap;
import java.util.Map;

import ouc.sms.entity.Departments;

public class DeptDao {
	 public static Map<Integer,Departments> map = new HashMap<Integer,Departments>();
		static{
			map.put(1, new Departments(1,"web","MNG001"));
			map.put(2, new Departments(2,"java","MNG002"));
		}
		public boolean saveDep(Departments Dep){
			for(Departments dt:map.values()){
				if(Dep.getDepNo()==(dt.getDepNo())){
					System.out.println("ALREADY USED");
					return false;
				}
			}
			map.put(Dep.getDepNo(),Dep);
			System.out.println("save success");
			return true;
		}
		public boolean updateDep(Departments Dep){
			map.put(Dep.getDepNo(), Dep);
			return true;
		}
		public Departments findOneDep(int eno){
			for(Departments dt:map.values()){
				if(dt.getDepNo()== eno){
					return dt;
				}
			}
			return null;
		}
		public Map<Integer, Departments> findAllDep(){
			return map;
		}

		
		
		

}
