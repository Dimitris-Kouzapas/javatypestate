package mySocket;
import java.net.Socket;
import java.net.UnknownHostException;

import java.io.IOException;
import java.io.DataOutputStream;
import java.io.DataInputStream;

public class MySocket {
	Socket s;
	private DataOutputStream out;
	private DataInputStream in;

	public MySocket(int port) {
		try {
			s = new Socket("localhost", port);
			out = new DataOutputStream(s.getOutputStream());
			in = new DataInputStream(s.getInputStream());
		}
		catch(UnknownHostException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		catch(IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public MySocket(Socket s) {
		this.s = s;
		try {
			out = new DataOutputStream(s.getOutputStream());
			in = new DataInputStream(s.getInputStream());
		}
		catch(IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public void send(int i) {
		try {
			out.writeInt(i);
		}
		catch(IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public void send(String s) {
		try {
			out.writeUTF(s);
		}
		catch(IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public int recvInt() {
		try {
			return in.readInt();
		}
		catch(IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return -1;
	}

	public String recvString() {
		try {
			return in.readUTF();
		}
		catch(IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return "";
	}

}
