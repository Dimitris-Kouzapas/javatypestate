package demos.alice_bob.threads;

public class Init {

//	private static Socket s = new Socket();

	public static Socket setSession() {
		return null;
	}

	public static Socket setDualSession() {
		return null;
	}

	public static void main(String[] args) {
		Broker br = new Broker();

		Session[] s = br.registerSession(100);

		AliceRunner a = new AliceRunner(s[0]);
		BobRunner b = new BobRunner(s[1]);

		new Thread(a).start();
		new Thread(b).start();
	}
}
