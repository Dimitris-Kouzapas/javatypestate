package mySocket;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class MyServerSocket {
	private ServerSocket serverSocket;

	public MyServerSocket(int port) {
		try {
			serverSocket = new ServerSocket(port);
		}
		catch(IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public MySocket accept() {
		MySocket s = null;
		try {
			s = new MySocket(serverSocket.accept());
		}
		catch(IOException e) {
			return null;
		}
		return s;
	}
}
