package demos.SMTP;
class Choice7  {
	public static final int _501 = 1, _250 = 2;
	private final int enumValue;
	public Choice7(int e){
		enumValue = e;
	}
	public Choice7(String enumString){
		int tmp = 0;
		if(enumString.equals("_501")) {
			tmp = _501;
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
