package demos.alice_bob.threads;

public class Broker {
//	private int []registry;
//	private int size;
	private Session[][] sessions;

	public Broker() {
		sessions = new Session[512][2];
		//for(int i = 0; i < 512; i++)
		//	sessions[i] = new Session[2];
	}

	public Session[] registerSession(int index) {
		Session e1 = new Session();
		Session e2 = new Session(e1);
		e1.setDual(e2);

		sessions[index][0] = e1;
		sessions[index][1] = e2;
		return sessions[index];
	}

//	public Session request(int id) {
//		int i;
//
//		for(i = 0; i < size; i++)
//			if(id == registry[i])
//				return sessions[i][1];
//
//
//		registerSession(i);
//		registry[i] = id;
//		size++;
//		return sessions[i][0];
//	}

	public static void main(String[] args) {
		Broker b = new Broker();
		Session[] s = b.registerSession(100);
		s[0].send(3);
		System.out.println(s[1].recvInt());
	}
}