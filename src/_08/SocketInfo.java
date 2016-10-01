package _08;

import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SocketInfo {
	public static void main(String[] args) {
		String[] hosts = args.length != 0 ? args
				: new String[] { "www.oreilly.com", "www.oreilly.com", "www.elharo.com", "login.ibiblio.org" };
		for (String host : hosts)
			try (Socket s = new Socket(host, 80)) {
				System.out.println("Connected to " + s.getInetAddress() + " on port " + s.getPort() + " from port "
						+ s.getLocalPort() + " of " + s.getLocalAddress());
			} catch (UnknownHostException e) {
				System.out.println("I can't find " + host);
			} catch (SocketException e) {
				System.out.println("Could not connect to " + host);
			} catch (Exception e) {
			System.out.println(e);
			}
	}
}
