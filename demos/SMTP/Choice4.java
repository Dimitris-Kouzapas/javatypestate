package demos.SMTP;
class Choice4  {
	public static final int AUTH = 1, QUIT = 2;
	private final int enumValue;
	public Choice4(int e){
		enumValue = e;
	}
	public Choice4(String enumString){
		int tmp = 0;
		if(enumString.equals("AUTH")) {
			tmp = AUTH;
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
