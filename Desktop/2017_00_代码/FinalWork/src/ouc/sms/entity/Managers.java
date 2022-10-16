package ouc.sms.entity;

import java.util.Map;

import ouc.sms.dao.ProDao;

	public class Managers extends Employees{
		
		
		public Projects dealProjects(int prono,String method){
			System.out.println("Manager deal Projects");
			ProDao pd=new ProDao();
			Map<Object, Projects> map=pd.findAllPro();
			Projects pj=new Projects();
			pj=map.get(prono);
			
			/*
			 * deal : random reduce the Projects
			 */
			
			pj.setProSta(2);
			pj.setProMethod(method);
			/*
			 * xyz
			 */
			return pj;
		}
		/*
		 * manager -> supervisor
		 */
		public void checkService(){
			System.out.println("Manager check");
			check();
		}

}