import java.io.*;
import java.net.*;
import java.util.ArrayList ;

class Client
{
    public static void Network_Scan( String address, ArrayList<Integer> ports )
	{
        for( int port : ports )
        {
            try
            {
                Socket socket = new Socket(address, port);
                System.out.println("\t[OK] -> "+address+":"+port);
            }
            catch(IOException i)
            { System.out.println("\t[NOK] -> "+address+":"+port); }

        }

    }
}

class Test{
    public static void main(String[] args) {


        ArrayList<Integer> ports = new ArrayList<Integer>();
        ports.add(80);
        ports.add(22);
        ports.add(101);
        ports.add(8000);

        Client.Network_Scan("localhost", ports) ;

    }
}