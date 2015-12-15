package demos.SMTP;
class Choice8  {
	public static final int RCPT = 1, DATA = 2;
	private final int enumValue;
	public Choice8(int e){
		enumValue = e;
	}
	public Choice8(String enumString){
		int tmp = 0;
		if(enumString.equals("RCPT")) {
			tmp = RCPT;
		}
		if(enumString.equals("DATA")) {
			tmp = DATA;
		}
		enumValue = tmp;
	}
	public int getEnum() {
		return enumValue;
	}
}
