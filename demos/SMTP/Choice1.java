package demos.SMTP;
class Choice1  {
	public static final int EHLO = 1, QUIT = 2;
	private final int enumValue;
	public Choice1(int e){
		enumValue = e;
	}
	public Choice1(String enumString){
		int tmp = 0;
		if(enumString.equals("EHLO")) {
			tmp = EHLO;
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
