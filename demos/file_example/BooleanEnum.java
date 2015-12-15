package demos.file_example;
class BooleanEnum  {
	public static final int TRUE = 1;
	public static final int FALSE = 2;
	private final int enumValue;
	public BooleanEnum(int e){
		enumValue = e;
	}
	public BooleanEnum(String enumString){
		int tmp = 0;
		if(enumString.equals("TRUE")) {
			tmp = TRUE;
		}
		if(enumString.equals("FALSE")) {
			tmp = FALSE;
		}
		enumValue = tmp;
	}
	public int getEnum() {
		return enumValue;
	}
}
