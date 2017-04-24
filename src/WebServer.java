import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public static void main(String[] args) throws IOException {

        try {
            System.out.println("Creando servidor");
            ServerSocket serverSocket = new ServerSocket();
            System.out.println("Realizando el bind (vinculo)");
                InetSocketAddress addr = new InetSocketAddress("127.0.0.1", 8080);
                serverSocket.bind(addr);

            System.out.println("Aceptando conexiones");
            Boolean temp = true;

            while(temp) {
                Socket socket = serverSocket.accept();
                Fil hp = new Fil(socket);
                hp.start();
            }
            serverSocket.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
