package old_example.buyer_seller;
class AgreementLabel  {
	public static final int AGREE = 1, QUIT = 2;
	private final int enumValue;
	public AgreementLabel(int e){
		enumValue = e;
	}
	public int getEnum() {
		return enumValue;
	}
}
