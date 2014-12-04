package store;
/**
 * Lab Section
 * @author Marcus
 *
 */
public class Lab extends SectionType{

	private static final Lab instance = new Lab();
	
	/**
	 * Singleton Pattern
	 * @return instance
	 */
	public static SectionType getInstance(){
		return instance;
	}
	
	/**
	 * return the String of type
	 * @return the String of type
	 */
	@Override
	public String getTypeStr() {
		return "Lab";
	}
	
	

}
