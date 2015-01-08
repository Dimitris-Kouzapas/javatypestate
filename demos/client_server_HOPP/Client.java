package demos.client_server_HOPP;
import java.io.*;

// Here's how we would use this approach to implement a distributed version of the system.

public class Client implements ClientProtocol {
	private ServerStub server = new ServerStub();
	
	public Client () {
		int k = 5;
		server.request(k);
	}

	void response(String v) {
	}
}
