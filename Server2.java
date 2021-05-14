

import java.net.*; 
import java.io.*; 

public class Server2 
{ 
	private Socket socket;
	private ServerSocket server;
	private DataInputStream in;
	private static Server2 server2;
	
	public Server2(int port) 
	{ 
		
		try
		{ 
			
			server = new ServerSocket(port); 
			System.out.println("Server started"); 

			System.out.println("Waiting for a client ..."); 

			socket = server.accept(); 
			System.out.println("Client accepted");
			

			in = new DataInputStream( 
				new BufferedInputStream(socket.getInputStream())); 

			String line = ""; 

			while (!line.equals("Stop")) 
			{ 
				try
				{ 
					line = in.readUTF(); 
					System.out.println(line); 

				} 
				catch(IOException i) 
				{ 
					System.out.println(i); 
				} 
			} 
			System.out.println("Closing connection"); 
			socket.close(); 
			in.close(); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	} 

	public static void main(String args[]) 
	{ 
		setServer2(new Server2(6666)); 
	}

	public static Server2 getServer2() {
		return server2;
	}

	public static void setServer2(Server2 server2) {
		Server2.server2 = server2;
	} 
} 