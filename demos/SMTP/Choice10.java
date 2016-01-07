package demos.SMTP;
class Choice10  {
	public static final int DATALINE = 1, SUBJECT = 2, ATAD = 3;
	private final int enumValue;
	public Choice10(int e){
		enumValue = e;
	}
	public Choice10(String enumString){
		int tmp = 0;
		if(enumString.equals("DATALINE")) {
			tmp = DATALINE;
		}
		if(enumString.equals("SUBJECT")) {
			tmp = SUBJECT;
		}
		if(enumString.equals("ATAD")) {
			tmp = ATAD;
		}
		enumValue = tmp;
	}
	public int getEnum() {
		return enumValue;
	}
}
