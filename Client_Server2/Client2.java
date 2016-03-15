import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Client2 {

	public static void main(String args[])
	{
		ServerSocket ss = null;
		try{
			ss = new ServerSocket(2000);
		}
		catch(IOException io)
		{
			System.out.println("Error in finding port");
		}
		
		Socket sc = null;
		try {
			sc = ss.accept();
			System.out.println("Connection established " + sc);
			DataOutputStream out = new DataOutputStream(sc.getOutputStream());
			String si;
			BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Ready to send messages / exit to end");
			
			while(!(si = br.readLine()).equals("exit"))
			{
				int ln = si.length();
				for(int i = 0; i<ln;i++)
				{
					out.write((byte)si.charAt(i));
					out.write(13);
					out.write(10);
					out.flush();
				}
				out.close();
				br.close();
				ss.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
