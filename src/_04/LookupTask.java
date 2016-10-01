package _04;

import java.net.InetAddress;
import java.util.concurrent.Callable;

import javax.print.event.PrintJobAdapter;

public class LookupTask implements Callable<String> {
	private String line;

	public LookupTask(String line) {
		super();
		this.line = line;
	}

	@Override
	public String call() throws Exception {
		try {
			int index = line.indexOf(' ');
			String address = line.substring(0, index);
			String theRest = line.substring(index);
			String hostname = InetAddress.getByName(address).getHostAddress();
			return hostname + " " + theRest;
		} catch (Exception e) {
			return line;
		}

	}

}
