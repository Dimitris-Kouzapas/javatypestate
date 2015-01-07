package demos.client_server_HOPP;
import java.io.*;

public class ServerSkeleton {
    private BufferedReader clientIn;
    private Server server = new Server();
    
    public ServerSkeleton () {
    	// initialise socket
    }

	// Wait on socket for (method, arg) data, then dispatch. No need to loop as
	// server accepts a single request and then terminates.
	void processMessage () throws IOException {
		String method = clientIn.readLine();
		if (method == "request") {
			int arg = Integer.parseInt(clientIn.readLine());
			server.request(arg);
		} else
			throw new RuntimeException("Unrecognised message.");
	}
}
