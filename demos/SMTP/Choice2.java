package demos.SMTP;
class Choice2  {
	public static final int _250DASH = 1, _250 = 2;
	private final int enumValue;
	public Choice2(int e){
		enumValue = e;
	}
	public Choice2(String enumString){
		int tmp = 0;
		if(enumString.equals("_250DASH")) {
			tmp = _250DASH;
		}
		if(enumString.equals("_250")) {
			tmp = _250;
		}
		enumValue = tmp;
	}
	public int getEnum() {
		return enumValue;
	}
}
