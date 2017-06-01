package demos.alice_bob.nothreads;

import mungo.lib.Typestate;

@Typestate("BobSession")
class Bob{
	String channel;

	public String receiveStringFromAlice() {
		return channel;
	}
}
