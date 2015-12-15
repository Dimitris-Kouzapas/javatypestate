package demos.SMTP;
class Choice6  {
	public static final int MAIL = 1, QUIT = 2;
	private final int enumValue;
	public Choice6(int e){
		enumValue = e;
	}
	public Choice6(String enumString){
		int tmp = 0;
		if(enumString.equals("MAIL")) {
			tmp = MAIL;
		}
		if(enumString.equals("QUIT")) {
			tmp = QUIT;
		}
		enumValue = tmp;
	}
	public int getEnum() {
		return enumValue;
	}
}
