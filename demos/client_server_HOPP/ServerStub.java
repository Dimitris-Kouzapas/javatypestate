package demos.client_server_HOPP;
import java.io.*;

public class ServerStub implements ServerProtocol {
    private PrintWriter serverOut;
    
    public ServerStub () {
    	// initialise socket
    }
    
	// For each server operation, package up call and send over serverOut. 
	void request(int k) {
		serverOut.println("request");
		serverOut.println(k);
	}
}
