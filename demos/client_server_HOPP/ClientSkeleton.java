package demos.client_server_HOPP;
import java.io.*;

public class ClientSkeleton {
    private BufferedReader serverIn;
    private Client client = new Client();
    
    public ClientSkeleton () {
    	// initialise socket
    }

	// Wait on socket for (method, arg) data, then dispatch. No need to loop as
	// client accepts a single response and then terminates.
	private void processMessage () throws IOException {
		String method = serverIn.readLine();
		if (method == "response") {
			String arg = (serverIn.readLine());
			client.response(arg);
		} else
			throw new RuntimeException("Unrecognised message.");
	}
}
