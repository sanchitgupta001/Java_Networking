import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_server {

	public static void main(String []args)throws IOException
	{
		BufferedReader kybd = new BufferedReader(new InputStreamReader(System.in));
		InetAddress localAddress = InetAddress.getLocalHost();
		
		InetAddress remoteAddress = null;
		
		DatagramSocket dsocket = new DatagramSocket(3456);
		
		int bufferSize = 2000;
		
		int remotePort;
		
		DatagramPacket outgram,ingram;
		
		System.out.println("Type replies \n Type exit to quit\n");
		boolean more = true;
		
		while(more)
		{
			byte[] inbuffer = new byte[bufferSize];
			ingram = new DatagramPacket(inbuffer, bufferSize);
			byte[] outbuffer = new byte[bufferSize];
			dsocket.receive(ingram);
			remoteAddress = ingram.getAddress();
			remotePort = ingram.getPort();
			String data = new String(ingram.getData());
			data = data.trim();
			
			if(data.equals("exit"))
			{
			   break;
			}
			System.out.println("From client : " + data);
			String reply = kybd.readLine();
			outbuffer = reply.getBytes();
			outgram = new DatagramPacket(outbuffer, outbuffer.length,remoteAddress,remotePort);
			dsocket.send(outgram);
			
			if(reply.equals("exit"))
			{
				break;
			}
			
		}
		
		dsocket.close();
	}
	
}
