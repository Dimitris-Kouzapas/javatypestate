package demos.buyer_seller_socket;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class SellerMain  {
	public static String safeRead(BufferedReader sl) {
		String line = "";
		try {
			line = sl.readLine();
		}
		catch(IOException e) {
			System.out.println("Input/Outpur error, unable to read");
			System.exit(+1);
		}
		return line;
	}
	public static void main(String[] args) {
		SellerRole seller = new SellerRole();
		BufferedReader sl = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Waiting to receive title from Buyer1...");
		String title = seller.receiveTitleFromBuyer1();
		System.out.println("Buyer1 to Seller: I would like to buy the book " + title);
		System.out.print("Seller to Buyer1: The price of the book is £");
		int price = Integer.parseInt(safeRead(sl));
		seller.sendPriceToBuyer1(price);
		switch(seller.receiveLabelFromBuyer2().getEnum()){
			case AgreementLabel.AGREE:
			System.out.println("Buyer2 agrees to contribute");
			System.out.print("Seller to Buyer1 and Buyer2: I am receiveing the amount of £");
			int total = seller.receiveMoneyFromBothBuyers();
			System.out.println(total);
			if(total != price) {
				System.out.println("I have not received the correct amount. I am sending you the money back.");
			}
			System.out.println("Bye!");
			break;
			case AgreementLabel.QUIT:
			System.out.println("Buyer2 does not want to contribute");
			break;
		}
	}
}
