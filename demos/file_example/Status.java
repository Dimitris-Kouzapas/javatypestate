package demos.file_example;
class Status  {
	public static final int OK = 1;
	public static final int ERROR = 2;
	private final int enumValue;
	public Status(int e){
		enumValue = e;
	}
	public Status(String enumString){
		int tmp = 0;
		if(enumString.equals("OK")) {
			tmp = OK;
		}
		if(enumString.equals("ERROR")) {
			tmp = ERROR;
		}
		enumValue = tmp;
	}
	public int getEnum() {
		return enumValue;
	}
}
