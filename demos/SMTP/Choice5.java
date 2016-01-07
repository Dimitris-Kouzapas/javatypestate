package demos.SMTP;
class Choice5  {
	public static final int _235 = 1, _535 = 2;
	private final int enumValue;
	public Choice5(int e){
		enumValue = e;
	}
	public Choice5(String enumString){
		int tmp = 0;
		if(enumString.equals("_235")) {
			tmp = _235;
		}
		if(enumString.equals("_535")) {
			tmp = _535;
		}
		enumValue = tmp;
	}
	public int getEnum() {
		return enumValue;
	}
}
