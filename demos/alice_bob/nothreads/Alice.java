package demos.alice_bob.nothreads;

import mungo.lib.Typestate;

@Typestate("AliceSession")
class Alice{
	String channel;

	public void sendStringToBob(String s) {
		channel = s;
	}
}
