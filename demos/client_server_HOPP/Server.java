package demos.client_server_HOPP;
import java.io.*;

public class Server /*typestate ServerProtocol*/ {
	private ClientStub client = new ClientStub();

	// Unfortunately there's no way to type this in our system, because the typestate of the
	// client field has to be consumed in the _constructor_ of Server.
	 	
	void request(int k) {
		client.response("hello");
	}
}
