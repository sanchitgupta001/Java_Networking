import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server2 {

	public static void main(String []args)
	{
		Socket cls = null;
		BufferedReader br = null;
		
		try {
			cls = new Socket(InetAddress.getLocalHost(),2000);
			br = new BufferedReader(new InputStreamReader(cls.getInputStream()));
			String ip;
			while((ip = br.readLine())!=null)
			{
				System.out.println(ip);
			}
			br.close();
			cls.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
