package ouc.sms.entity;

import java.util.Map;

import ouc.sms.dao.ProDao;

/**
 * ¼à¹ÜÈËÀà
 * @author xuyizhou
 *
 */
public class Supervisors extends Employees{
	Managers mng =new Managers();
//	public void auditLoop(int prono){
//		
//		System.out.println("----Manager deal first time---");
//		mng.dealProjects(prono);
//		mng.checkService();
//		
//		int loopNum=1;
//		while(!audit(prono)){
//			System.out.println("----Manager deal the no."+(loopNum+1)+" time---");
//			loopNum++;
//			if(loopNum>10){
//				System.out.println("Manager deals more than 10 times!!");
//				break;
//			}
//		}
//		
//		System.out.println("looptime:"+loopNum);
//		System.out.println("********audit loop out*******");
//	}
//	public boolean audit(int prono){
//		System.out.println("Supervisors audit");
//		ProDao pd=new ProDao();
//		
//		Map<Object, Projects> map=pd.findAllPro();
//		
//		Projects pj=pd.findOnePro(prono);
//		if(pj.getProScore()<5){
//		return true;
//		}else{
//     		mng.dealProjects(prono);
//			return false;
//		}
//	}
	public void checkService(){
		System.out.println("supervisor check");
		check();
	}

}
