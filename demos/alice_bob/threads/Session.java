package demos.alice_bob.threads;

import java.util.LinkedList;

public class Session {
	private LinkedList endpoint;
	private Session dual;

	public Session() {
		endpoint = new LinkedList();
		dual = null;
	}

	public Session(Session dual) {
		this();
		setDual(dual);
	}

	public void setDual(Session dual) {
		this.dual = dual;
	}

	private Object recv() {
		while(true) {
			try {
				return endpoint.removeLast();
			}
			catch(Exception e) {
			}
		}
	}

	public String recvString() {
		return (String) recv();
	}

	public int recvInt() {
		return ((Integer) recv()).intValue();
	}

	private void send(Object o) {
		dual.endpoint.addFirst(o);
	}

	public void send(int i) {
		send(new Integer(i));
	}

	public void send(String s) {
		send((Object) s);
	}

}