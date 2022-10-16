package ouc.sms.util;

import java.util.Scanner;

public class InputUtil {
	public static String getOPTS(String fuGongNeng,String[]items,int choice){
		if(choice>=1 && choice<=items.length){
			return "["+fuGongNeng+"] > ["+items[choice-1]+"]";
		}
		return null;
	}
	public static int getChoice(String title,String[] items){
		StringBuffer sbf=new StringBuffer(title+"\n");
		for (int i = 0; i < items.length; i++) {
			sbf.append(i+1+"."+items[i]+"\n");
		}
		sbf.append("ÇëÑ¡Ôñ");
		return getIntInput(sbf.toString());
	}
	public static String getStringInput(String tiShi){
		Scanner input=new Scanner(System.in);
		
		System.out.print(tiShi);
		return input.next();
	}
	public static int getIntInput(String tiShi){
		Scanner input=new Scanner(System.in);
		System.out.print(tiShi);
		return input.nextInt();
	}
	public static double getDoubleInput(String tiShi){
		Scanner input=new Scanner(System.in);
		System.out.print(tiShi);
		return input.nextDouble();
	}

}
