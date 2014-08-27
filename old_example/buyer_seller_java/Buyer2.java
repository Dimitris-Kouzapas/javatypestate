import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class Buyer2 {
    private BufferedReader socketBuyer1In = null;
    private PrintWriter socketBuyer1Out = null;

    private BufferedReader socketSellerIn = null;
    private PrintWriter socketSellerOut = null;

    public Buyer2() {
        // Bind the socket
        ServerSocket serverBuyer1 = null;
        try {
            serverBuyer1 = new ServerSocket(20002);
        } catch (IOException e) {
            System.out.println("Unable to listen on port 20002");
            System.exit(-1);
        }

        // Accept a client connection
        Socket socketBuyer1 = null;
        try {
            System.out.println("Accepting...");
            socketBuyer1 = serverBuyer1.accept();
        } catch (IOException e) {
            System.out.println("Accept failed");
            System.exit(-1);
        }

        // Create the read and write streams
        try {
            socketBuyer1In = new BufferedReader(new InputStreamReader(socketBuyer1.getInputStream()));
            socketBuyer1Out = new PrintWriter(socketBuyer1.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Read failed");
            System.exit(-1);
        }

        System.out.println("Accepted connection from Buyer1");

        // Must connect to the Seller
        try {
            // Create the socket
            Socket socketSeller = new Socket("localhost", 20001);

            // Create the read/write streams
            socketSellerIn = new BufferedReader(new InputStreamReader(socketSeller.getInputStream()));
            socketSellerOut = new PrintWriter(socketSeller.getOutputStream(), true);
            System.out.println("Connected to the seller");
        } catch(UnknownHostException e) {
            System.out.println("Unable to connect to the remote host");
            System.exit(-1);
        } catch(IOException e) {
            System.out.println("Input/Output error, unable to connect");
            System.exit(-1);
        }
    }

    public String receiveQuoteFromBuyer1() throws IOException {
        //System.out.println("receiving quote ... " + this.socketBuyer1In.ready());
        return this.socketBuyer1In.readLine();
    }

    public AgreementLabel sendToSellerBuyer1(String agreement) {
        this.socketBuyer1Out.println(agreement);
        this.socketSellerOut.println(agreement);

        if (agreement.equals("AGREE")) {
            //System.out.println("Buyer2 to Seller and Buyer1: I agree to pay the quote");
            return new AgreementLabel(AgreementLabel.AGREE);
        }

        //System.out.println("Buyer2 to Seller and Buyer1: I do not agree to pay the quote");
        return new AgreementLabel(AgreementLabel.QUIT);
    }

    public void transferMoneyToSeller(String money) {
        this.socketSellerOut.println(money);
        System.out.println("Bye!");
    }

    public static void main(String [] args) {
        Buyer2 buyer2 = new Buyer2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        try {
            // Waiting for the quote
            System.out.println("Waiting to receive quote from Buyer1...");
            String quote = buyer2.receiveQuoteFromBuyer1();
            System.out.println("Received quote from Buyer1 £" + quote);

            // Agreement decision for Buyer2
            //buyer2.sendToSellerBuyer1("AGREE");
            //buyer2.transferMoneyToSeller("30");
            System.out.print("Buyer2 to Seller and Buyer1: My decision is ");
            String agreement = br.readLine();
            switch (buyer2.sendToSellerBuyer1(agreement).getEnum()) {
            case AgreementLabel.AGREE:
                System.out.println("Buyer2 agrees to contribute");
                System.out.print("Buyer2 to Seller: I am transfering you £");
                String money = br.readLine();
                buyer2.transferMoneyToSeller(money);
                break;
            case AgreementLabel.QUIT:
                break;
            }
        } catch (IOException e) {
            System.out.println("Input/Output error");
            System.exit(-1);
        }
    }
}
