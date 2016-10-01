package _04;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ByName {

	// www.baidu.com/180.97.33.107
	// --------
	// www.baidu.com/180.97.33.107
	// www.baidu.com/180.97.33.108
	// --------
	// LangDylandeMacBook-Pro.local/172.28.125.33
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress address = InetAddress.getByName("www.baidu.com");
			System.out.println(address);

			System.out.println("--------");

			InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");
			for (InetAddress inetAddress : addresses) {
				System.out.println(inetAddress);
			}

			System.out.println("--------");

			InetAddress localHost = InetAddress.getLocalHost();
			System.out.println(localHost);

			byte[] addressAll = { (byte) 192, 23, 0, 1 };
			for (int i = 1; i <= 255; i++) {
				addressAll[3] = (byte) i;
				InetAddress po = InetAddress.getByAddress(addressAll);
				if (po != null) {
					System.out.println(po);
				}
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
interface A{
	
}

interface B extends A{
	
}
//class C extends A{}
