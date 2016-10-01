package _04;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class SpamCkeck {
	public static final String BLACKHOLE = "sbl.spamhaus.org";

	public static void main(String[] args) {
		List<String> lists = new ArrayList<>();
		lists.add("207.34.56.23");
		lists.add("125.12.32.4");
		lists.add("130.130.130.130");

		for (String name : lists) {
			if (isSpammer(name)) {
				System.out.println(name + " is a known spammer");
			} else
				System.out.println(name + " appears legitimate");
		}
	}

	public static boolean isSpammer(String name) {

		try {
			InetAddress address = InetAddress.getByName(name);
			byte[] quad = address.getAddress();
			String query = BLACKHOLE;
			for (byte octet : quad) {
				int unsignedByte = octet < 0 ? octet + 256 : octet;
				query = unsignedByte + "." + query;
			}
			InetAddress.getByName(query);
			return true;
		} catch (UnknownHostException e) {
			return false;
		}

	}
}
