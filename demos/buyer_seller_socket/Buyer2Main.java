package demos.buyer_seller_socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
public class Buyer2Main  {
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
		Buyer2Role buyer2 = new Buyer2Role();
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
