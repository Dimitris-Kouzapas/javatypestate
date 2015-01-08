package demos.client_server_HOPP;
import java.io.*;

public class ClientStub implements ClientProtocol {
    private PrintWriter clientOut;
    
    public ClientStub () {
    	// initialise socket
    }
    
	// For each client operation, package up call and send over clientOut. 
	void response(String v) {
		clientOut.println("response");
		clientOut.println(v);
	}
}
