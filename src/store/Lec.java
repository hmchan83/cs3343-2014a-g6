package store;

public class Lec extends SectionType{

	private static final Lec instance = new Lec();
	
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
		return "Lec";
	}

}
