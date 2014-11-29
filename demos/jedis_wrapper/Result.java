package demos.jedis_wrapper;
class Result  {
	public static final int OK = 1, FAIL = 2;
	private final int enumValue;
	public Result(int e){
		enumValue = e;
	}
	public int getEnum() {
		return enumValue;
	}
}
