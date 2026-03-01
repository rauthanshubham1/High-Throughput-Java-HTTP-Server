package ThreadPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;


public class Server {
    public static void main(String[] args) {
        try{
            Server.run();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void run() throws IOException {
        int port = 8010;
        int THREAD_POOL_SIZE = 10;

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        ServerSocket connection = new ServerSocket(port);
        System.out.println("Server is listening on port: "+ port);

        while (true) {
            Socket clientsocket = connection.accept();
            executorService.submit(() -> getConsumer().accept(clientsocket));
        }
    }
    public static Consumer<Socket> getConsumer(){

        return (clientsocket)->{
            try {
                PrintWriter toclient= new PrintWriter(clientsocket.getOutputStream());
                BufferedReader fromclient= new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
                System.out.println(fromclient.readLine());
                toclient.println(" Hello");
                toclient.close();
                clientsocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }
}
