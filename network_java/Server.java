import java.net.*;
import java.io.*;

public class Server {

    private static Server server ;

    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream in;

    private Server()
    {
        try
        {
            this.serverSocket = new ServerSocket(101);
            System.out.println("--------- Server started ---------");
            System.out.println("status:\tWaiting for a client...");

            this.socket = serverSocket.accept();
            System.out.println("status:\tClient accepted !");

            this.in = new DataInputStream( new BufferedInputStream( this.socket.getInputStream() ) );
        }
        catch(IOException i)
        { System.out.println(i); }

    }

    public static Server getInstance()
    {
        if(server == null)
        {
            server = new Server();
        }
        return server;
    }

    public void startServer()
    {
        String line = "";

        while( true )
        {
            try
            {
                line = in.readUTF();
                this.Answer(line) ;
                System.out.println(line);
            }
            catch(IOException i)
            { System.out.println(i); }
        }

        System.out.println("status:\nClosing connection !");
        try
        {
            socket.close();
            in.close();
            serverSocket.close();
        }
        catch(IOException e)
        { System.out.println(e); }

        System.out.println("--------- Server stopped ---------");
    }

    public static void main(String[] args) {

        Server server = Server.getInstance();
        server.startServer();
    
    }
}
