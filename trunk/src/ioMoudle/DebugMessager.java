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
		if(enable==false) return;
		System.out.println("\t[debug] : "+str);
	}
}
