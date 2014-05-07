package demos.file_example;
class Status  {
	public static final int OK = 1, ERROR = 2;
	private final int enumValue;
	public Status(int e){
		enumValue = e;
	}
	public int getEnum() {
		return enumValue;
	}
}
