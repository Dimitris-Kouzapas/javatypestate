package demos.alice_bob.threads;

public class BobRunner implements Runnable {
	private Session s;

	public BobRunner(Session s) {
		this.s = s;
	}

	public void run() {
		Bob b = new Bob(s);

		System.out.println(b.receiveStringFromAlice());
		b.sendStringToAlice("Hi Alice! How are you?");
	}
}
