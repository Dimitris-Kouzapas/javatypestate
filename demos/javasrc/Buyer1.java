import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Buyer1 {
    private BufferedReader socketSellerIn = null;
    private PrintWriter socketSellerOut = null;

    private BufferedReader socketBuyer2In = null;
    private PrintWriter socketBuyer2Out = null;

    public Buyer1() {
        // Must connect to the Seller and Buyer2
        try {
            // Create the socket
            Socket socketSeller = new Socket("localhost", 20000);
            Socket socketBuyer2 = new Socket("localhost", 20002);

            // Create the read/write streams
            socketSellerIn = new BufferedReader(new InputStreamReader(socketSeller.getInputStream()));
            socketSellerOut = new PrintWriter(socketSeller.getOutputStream(), true);
            socketBuyer2In = new BufferedReader(new InputStreamReader(socketBuyer2.getInputStream()));
            socketBuyer2Out = new PrintWriter(socketBuyer2.getOutputStream(), true);
        } catch(UnknownHostException e) {
            System.out.println("Unable to connect to the remote host");
            System.exit(-1);
        } catch(IOException e) {
            System.out.println("Input/Output error, unable to connect");
            System.exit(-1);
        }
    }

    public void sendTitleToSeller(String title) {
        this.socketSellerOut.println(title);
        // System.out.println("Buyer1 to Seller: I want to buy the book " + title);
    }

    public String receivePriceFromSeller() throws IOException {
        return this.socketSellerIn.readLine();
    }

    public void sendQuoteToBuyer2(String quote) {
        this.socketBuyer2Out.println(quote);
        //System.out.println("Buyer1 to Buyer2: Your quote to pay is " + quote + ". Do you agree?");
    }

    public AgreementLabel receiveLabelFromBuyer2() throws IOException {
        String label = this.socketBuyer2In.readLine();

        if (label.equals("AGREE")) {
            return new AgreementLabel(AgreementLabel.AGREE);
        }
        return new AgreementLabel(AgreementLabel.QUIT);
    }

    public void transferMoneyToSeller(String money) {
        this.socketSellerOut.println(money);
        System.out.println("Bye!");

    }

    public static void main(String [] args) {
        Buyer1 buyer1 = new Buyer1();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Ask the user for the name of the book
            System.out.print("Buyer1 to Seller: I would like to buy the book ");
            String title = br.readLine();
            buyer1.sendTitleToSeller(title);
          
            // Receive the price from seller
            String price  = buyer1.receivePriceFromSeller();
            System.out.println("Seller to Buyer1: Price of the book is £" + price);
            
            // Ask the user for the quote
            System.out.print("Buyer1 to Buyer2: Your quote to pay is £");
            String quote = br.readLine();
            buyer1.sendQuoteToBuyer2(quote);

            AgreementLabel label = buyer1.receiveLabelFromBuyer2();
            switch (label.getEnum()) {
                case AgreementLabel.AGREE:
                    System.out.println("Buyer2 agrees to contribute");
                    System.out.print("Buyer1 to Seller: I am transfering you £");
                    String mypart = br.readLine();
                    buyer1.transferMoneyToSeller(mypart);
                    break;
                case AgreementLabel.QUIT:
                    System.out.println("Buyer2 does not want to contribute");
                    break;
                default:
                    System.out.println("Invalid response from Buyer2");
            }
        } catch (IOException e) {
            System.out.println("Input/Output error");
            System.exit(-1);
        }
    }
}
