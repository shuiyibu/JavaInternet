package _04;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class OReillyByName {
	public static void main(String[] args) {
		try {
			// 1.Get InetAddress ByName
			InetAddress address = InetAddress.getByName("www.oreilly.com");
			InetAddress[] addresses = InetAddress.getAllByName("www.oreilly.com");
			System.out.println(address);
			// print all items
			System.out.println(Arrays.toString(addresses));

			// 2. Get localhost
			InetAddress localhost = InetAddress.getLocalHost();
			System.out.println(localhost);

			// 3. Get InetAddress ByAddress

			// 4.
//			SecurityManager sm = new SecurityManager();
//			System.out.println();
//			sm.checkConnect("DESKTOP-1HMU86", -1);

			// 5.
			InetAddress hostName=InetAddress.getByName("192.168.0.26");
			System.out.println(hostName.getHostName());
			System.out.println(hostName.getCanonicalHostName());
			InetAddress baidu=InetAddress.getByName("180.97.33.107");
			System.out.println(baidu);
			System.out.println(baidu.getHostName());
			System.out.println(baidu.getCanonicalHostName());
			InetAddress oreilly=InetAddress.getByName("208.201.239.100");
			System.out.println(oreilly);
			System.out.println(oreilly.getHostName());
			System.out.println(oreilly.getCanonicalHostName());
			System.out.println(oreilly.isReachable(1500));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
