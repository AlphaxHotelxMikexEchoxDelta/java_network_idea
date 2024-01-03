import java.io.*;
import java.net.*;

public class Client {

    private static Client client;

    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    private Client(String address, int port) {
        try
		{
            this.socket = new Socket(address, port);
            System.out.println("Connected");

            this.input = new DataInputStream(System.in);
            this.out = new DataOutputStream(socket.getOutputStream());
        }
		catch(UnknownHostException u)
		{ System.out.println(u); } 
		catch(IOException i)
		{ System.out.println(i); }
    }
	
    public static Client getInstance(String address, int port)
	{
        if(client == null)
		{
            client = new Client(address, port);
        }
        return client;
    }

    public void startClient()
	{
        String line = "";

        while(true)
		{
            try{ out.writeUTF(input.readLine()); }
			catch(IOException i){ System.out.println(i); }
        }
    }

    public static void main(String args[])
	{
        
		Client client = Client.getInstance("localhost", 101);
        client.startClient();

    }
}
