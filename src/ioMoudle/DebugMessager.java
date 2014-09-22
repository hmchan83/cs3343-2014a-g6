package ioMoudle;

public class DebugMessager {
	private static boolean enable=false;
	
	public static void enable(){
		enable = true;
	}
	public static void disable(){
		enable = false;
	}
	public static void on(){
		enable();
	}
	public static void off(){
		disable();
	}
	public static void debug(String str){
		if(enable==true)
		System.out.println("[debug] : "+str);
	}
}
