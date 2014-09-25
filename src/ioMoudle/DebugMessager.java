package ioMoudle;
/**
 * to output the debug message, use DebugMessager.enable() or DebugMessager.disable() to turn this on / off
 * @author Marcus
 *
 */
public class DebugMessager {
	private static boolean enable=false;
	/**
	 * Turn on the showing of debug message
	 */
	public static void enable(){
		enable = true;
	}
	/**
	 * Turn off the showing of debug message
	 */
	public static void disable(){
		enable = false;
	}
	/**
	 * Turn on the showing of debug message
	 */
	public static void on(){
		enable();
	}
	/**
	 * Turn off the showing of debug message
	 */
	public static void off(){
		disable();
	}
	/**
	 * method to output the debug message
	 * @param str debug message
	 */
	public static void debug(String str){
		if(enable==false) return;
		System.out.println("\t[debug] : "+str);
	}
}
