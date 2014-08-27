import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Seller {
    private BufferedReader socketBuyer1In = null;
    private PrintWriter socketBuyer1Out = null;

    private BufferedReader socketBuyer2In = null;
    private PrintWriter socketBuyer2Out = null;

    public Seller() {
        // Bind the socket
        ServerSocket serverBuyer1 = null;
        ServerSocket serverBuyer2 = null;
        try {
            serverBuyer1 = new ServerSocket(20000);
            serverBuyer2 = new ServerSocket(20001);
        } catch (IOException e) {
            System.out.println("Unable to listen on port 20000 or 20001");
            System.exit(-1);
        }

        // Accept a client connection
        Socket socketBuyer1 = null;
        Socket socketBuyer2 = null;
        try {
            System.out.println("Accepting...");
            socketBuyer1 = serverBuyer1.accept();
            System.out.println("Accepted connection from Buyer1");
            socketBuyer2 = serverBuyer2.accept();
            System.out.println("Accepted connection from Buyer2");
        } catch (IOException e) {
            System.out.println("Accept failed");
            System.exit(-1);
        }

        // Create the read and write streams
        try {
            socketBuyer1In = new BufferedReader(new InputStreamReader(socketBuyer1.getInputStream()));
            socketBuyer1Out = new PrintWriter(socketBuyer1.getOutputStream(), true);
            socketBuyer2In = new BufferedReader(new InputStreamReader(socketBuyer2.getInputStream()));
            socketBuyer2Out = new PrintWriter(socketBuyer2.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Read failed");
            System.exit(-1);
        }
    }

    public String receiveTitleFromBuyer1() throws IOException {
        return this.socketBuyer1In.readLine();
    }

    public void sendPriceToBuyer1(String price) {
        this.socketBuyer1Out.println(price);
    }

    public AgreementLabel receiveLabelFromBuyer2() throws IOException {
        String label = this.socketBuyer2In.readLine();

        if (label.equals("AGREE")) {
            return new AgreementLabel(AgreementLabel.AGREE);
        }
        return new AgreementLabel(AgreementLabel.QUIT);
    }

    public int receiveMoneyFromBothBuyers() throws IOException {
        String fromBuyer1 = this.socketBuyer1In.readLine();
        String fromBuyer2 = this.socketBuyer2In.readLine();

        return Integer.parseInt(fromBuyer1) + Integer.parseInt(fromBuyer2);

    }

    public static void main(String [] args) {
        Seller seller = new Seller();
        BufferedReader sl = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Waiting for title of the book
            System.out.println("Waiting to receive title from Buyer1...");
            String title = seller.receiveTitleFromBuyer1();
            System.out.println("Buyer1 to Seller: I would like to buy the book " + title);

            // Ask user for the price
            System.out.print("Seller to Buyer1: The price of the book is £");
            String price = sl.readLine();
            seller.sendPriceToBuyer1(price);

            AgreementLabel label = seller.receiveLabelFromBuyer2();
            switch (label.getEnum()) {
                case AgreementLabel.AGREE:
                    System.out.println("Buyer2 agrees to contribute");
                    System.out.print("Seller to Buyer1 and Buyer2: I am receiveing the amount of ");
                    int total = seller.receiveMoneyFromBothBuyers();
                    System.out.println(total);
                    System.out.println("Thanks! Bye!");
                    break;
                case AgreementLabel.QUIT:
                    System.out.println("Buyer2 does not want to contribute");
                    break;
                default:
                    System.out.println("Invalid response from Buyer2");
            }
        } catch (IOException e ) {
            System.out.println("Input/Output error");
            System.exit(-1);
        }
    }
}
