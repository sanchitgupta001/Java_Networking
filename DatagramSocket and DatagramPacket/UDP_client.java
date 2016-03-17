import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP_client {

	public static void main(String []args) throws IOException
	{
		BufferedReader kybd = new BufferedReader(new InputStreamReader(System.in));
		
		InetAddress localAdrs = InetAddress.getLocalHost();
		
		InetAddress remoteAddress = localAdrs;
		
		DatagramSocket dsocket = new DatagramSocket(3457);
		
		int bufferSize = 2000;
		
		byte[] outbuffer = new byte[bufferSize];
		
		int remotePort ;
		String data;
		DatagramPacket outgram,ingram;
		
		System.out.println("Start the dialog from this client");
		
		boolean more = true;
		
		while(more)
		{
			byte[] inbuffer = new byte[bufferSize];
			ingram = new DatagramPacket(inbuffer, bufferSize);
			String send = kybd.readLine();
			outbuffer = send.getBytes();
			
			outgram = new DatagramPacket(outbuffer,outbuffer.length,remoteAddress,3456);
			dsocket.send(outgram);
			if((send.trim()).equals("exit"))
			{
				break;
			}
			
			dsocket.receive(ingram);
			data = new String(ingram.getData());
			
			data = data.trim();
			System.out.println("From Server : " + data);
			
			if(data.equals("exit"))
			{
				break;
			}
			
			dsocket.close();
		}
	}
	
}
