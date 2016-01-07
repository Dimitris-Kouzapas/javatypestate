package demos.SMTP;
class Choice9  {
	public static final int _250 = 1;
	private final int enumValue;
	public Choice9(int e){
		enumValue = e;
	}
	public Choice9(String enumString){
		int tmp = 0;
		if(enumString.equals("_250")) {
			tmp = _250;
		}
		enumValue = tmp;
	}
	public int getEnum() {
		return enumValue;
	}
}
