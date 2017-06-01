package demos.alice_bob.threads;

public class AliceRunner implements Runnable {
	private Session s;

	public AliceRunner(Session s) {
		this.s = s;
	}

	public void run() {
		Alice a = new Alice(s);

		a.sendStringToBob("Hello Bob!");
		System.out.println(a.receiveStringFromBob());
	}
}
