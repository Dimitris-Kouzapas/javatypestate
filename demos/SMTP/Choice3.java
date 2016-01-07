package demos.SMTP;
class Choice3  {
	public static final int STARTTLS = 1, QUIT = 2;
	private final int enumValue;
	public Choice3(int e){
		enumValue = e;
	}
	public Choice3(String enumString){
		int tmp = 0;
		if(enumString.equals("STARTTLS")) {
			tmp = STARTTLS;
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
