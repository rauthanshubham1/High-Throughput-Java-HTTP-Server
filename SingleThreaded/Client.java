package SingleThreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public void run() throws UnknownHostException, IOException {

        int port = 8010;
        InetAddress address = InetAddress.getByName("localhost");

        Socket socket = new Socket(address, port);
        PrintWriter toserver = new PrintWriter(socket.getOutputStream(), true);
        toserver.println("Hello from the SingleThreaded.client");
        BufferedReader fromserver = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(fromserver.readLine());
        toserver.close();
        fromserver.close();
        socket.close();

    }

    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
