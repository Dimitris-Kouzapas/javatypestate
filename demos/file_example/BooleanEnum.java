package demos.file_example;
class BooleanEnum  {
	public static final int TRUE = 1, FALSE = 2;
	private final int enumValue;
	public BooleanEnum(int e){
		enumValue = e;
	}
	public int getEnum() {
		return enumValue;
	}
}
