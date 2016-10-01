package _08;

import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SocketChannel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DaytimeClient {
	//to do
	public static void main(String[] args) {
		String hostname = args.length > 0 ? args[0] : "time.nist.gov";
		try (Socket socket = new Socket(hostname, 13)) {
			socket.setSoTimeout(15000);
			// Channel channel=socket.getChannel();
			// SocketChannel sc=SocketChannel.open();
			// sc.connect(new InetSocketAddress(hostname, 13));
			InputStreamReader reader = new InputStreamReader(socket.getInputStream(), "ASCII");
			StringBuilder time = new StringBuilder();
			for (int c = reader.read(); c != -1; c = reader.read())
				time.append((char) c);
			System.out.println(time);
			System.out.println(parseDate(time.toString()));

			// MappedByteBuffer mBuf=
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static Date parseDate(String s) throws ParseException {
		String[] pieces = s.split(" ");
		String dateTime = pieces[1] + " " + pieces[2] + " UTC";
		DateFormat format = new SimpleDateFormat("yy-MM-dd hh:mm:ss z");
		return format.parse(dateTime);

	}
}
