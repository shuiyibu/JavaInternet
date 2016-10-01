package _04;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

//name:utun0 (utun0)
//name:awdl0 (awdl0)
//name:en0 (en0)
//name:lo0 (lo0)

public class NetworkInterfaceDemo {
	public static void main(String[] args) {
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			while (interfaces.hasMoreElements()) {
				NetworkInterface ni = interfaces.nextElement();
				System.out.println(ni);
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
