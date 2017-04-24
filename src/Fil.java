import java.net.Socket;

public class Fil extends Thread{

    private Socket socket = new Socket();

    public Fil(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            String IP = socket.getRemoteSocketAddress().toString();

            String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    " <meta charset=\"UTF-8\">\n" +
                    " <title>Mi título</title>\n" +
                    "<H3> IP: " + IP +"</b>\n" +
                    " <br>\n" +
                    " <b>Esto es un servidor WEB!</b>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "</body>\n" +
                    "</html>";

            socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
