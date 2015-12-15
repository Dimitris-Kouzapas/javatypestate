package demos.Traversal;
class Choice implements java.io.Serializable {
	public static final int DATA = 1;
	public static final int NO_D = 2;
	public static final int END = 3;
	private final int enumValue;
	public Choice(int e){
		enumValue = e;
	}
	public Choice(String enumString){
		int tmp = 0;
		if(enumString.equals("DATA")) {
			tmp = DATA;
		}
		if(enumString.equals("NO_D")) {
			tmp = NO_D;
		}
		if(enumString.equals("END")) {
			tmp = END;
		}
		enumValue = tmp;
	}
	public int getEnum() {
		return enumValue;
	}
}
