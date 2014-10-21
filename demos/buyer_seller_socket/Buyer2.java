package demos.buyer_seller_socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
public class Buyer2  {
	private BufferedReader socketBuyer1In = null;
	private PrintWriter socketBuyer1Out = null;
	private BufferedReader socketSellerIn = null;
	private PrintWriter socketSellerOut = null;
	public Buyer2(){
		ServerSocket serverBuyer1 = null;
		try {
			serverBuyer1 = new ServerSocket(20002);
		}
		catch(IOException e) {
			System.out.println("Unable to listen on port 20002");
			System.exit(+1);
		}
		Socket socketBuyer1 = null;
		try {
			System.out.println("Accepting...");
			socketBuyer1 = serverBuyer1.accept();
		}
		catch(IOException e) {
			System.out.println("Accept failed");
			System.exit(+1);
		}
		try {
			socketBuyer1In = new BufferedReader(new InputStreamReader(socketBuyer1.getInputStream()));
			socketBuyer1Out = new PrintWriter(socketBuyer1.getOutputStream(), true);
		}
		catch(IOException e) {
			System.out.println("Read failed");
			System.exit(+1);
		}
		System.out.println("Accepted connection from Buyer1");
		try {
			Socket socketSeller = new Socket("localhost", 20001);
			socketSellerIn = new BufferedReader(new InputStreamReader(socketSeller.getInputStream()));
			socketSellerOut = new PrintWriter(socketSeller.getOutputStream(), true);
			System.out.println("Connected to the Seller");
		}
		catch(UnknownHostException e) {
			System.out.println("Unable to connect to the remote host");
			System.exit(+1);
		}
		catch(IOException e) {
			System.out.println("Input/Output error, unable to connect");
			System.exit(+1);
		}
	}
	public int receiveQuoteFromBuyer1() {
		String quote = "";
		try {
			quote = this.socketBuyer1In.readLine();
		}
		catch(IOException e) {
			System.out.println("Input/Output error, unable to get quote from buyer1");
			System.exit(+1);
		}
		return Integer.parseInt(quote);
	}
	public AgreementLabel sendToSellerBuyer1(String agreement) {
		this.socketBuyer1Out.println(agreement);
		this.socketSellerOut.println(agreement);
		if(agreement.equals("AGREE")) {
			return new AgreementLabel(AgreementLabel.AGREE);
		}
		return new AgreementLabel(AgreementLabel.QUIT);
	}
	public void transferMoneyToSeller(int money) {
		this.socketSellerOut.println(money);
		System.out.println("Bye!");
	}
	public static String safeRead(BufferedReader br) {
		String line = "";
		try {
			line = br.readLine();
		}
		catch(IOException e) {
			System.out.println("Input/Outpur error, unable to read");
			System.exit(+1);
		}
		return line;
	}
	public static void main(String[] args) {
		Buyer2 buyer2 = new Buyer2();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Waiting to receive quote from Buyer1...");
		int quote = buyer2.receiveQuoteFromBuyer1();
		System.out.println("Received quote from Buyer1 £" + quote);
		System.out.print("Buyer2 to Seller and Buyer1: AGREE [y/n]? ");
		String reply = safeRead(br);
		String agreement = reply.equals("y") ? "AGREE" : "QUIT";
		switch(buyer2.sendToSellerBuyer1(agreement).getEnum()){
			case AgreementLabel.AGREE:
			System.out.print("Buyer2 to Seller: I am transfering you £");
			int money = Integer.parseInt(safeRead(br));
			buyer2.transferMoneyToSeller(money);
			break;
			case AgreementLabel.QUIT:
			break;
		}
	}
}
