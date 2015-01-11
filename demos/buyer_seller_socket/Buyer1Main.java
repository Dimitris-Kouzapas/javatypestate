package demos.buyer_seller_socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
public class Buyer1Main  {
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
		Buyer1Role buyer1 = new Buyer1Role();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Buyer1 to Seller: I would like to buy the book ");
		String title = safeRead(br);
		buyer1.sendTitleToSeller(title);
		int price = buyer1.receivePriceFromSeller();
		System.out.println("Seller to Buyer1: Price of the book is £" + price);
		System.out.print("Buyer1 to Buyer2: Your quote to pay is £");
		int quote = Integer.parseInt(safeRead(br));
		buyer1.sendQuoteToBuyer2(quote);
		switch(buyer1.receiveLabelFromBuyer2().getEnum()){
			case AgreementLabel.AGREE:
			System.out.println("Buyer2 agrees to contribute");
			System.out.print("Buyer1 to Seller: I am transfering you £");
			int mypart = Integer.parseInt(safeRead(br));
			buyer1.transferMoneyToSeller(mypart);
			break;
			case AgreementLabel.QUIT:
			System.out.println("Buyer2 does not want to contribute");
			break;
		}
	}
}