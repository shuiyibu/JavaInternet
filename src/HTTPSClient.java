import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class HTTPSClient {
	public static void main(String[] args) {
		int port = 443;
		String host = args.length != 0 ? args[0] : "www.usps.com";

		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		try (SSLSocket socket = (SSLSocket) factory.createSocket(host, port)) {
			//
			String[] supportd = socket.getSupportedCipherSuites();
			socket.setEnabledCipherSuites(supportd);

			Writer out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			out.write("GET http://" + host + "/ HTTP/1.1\r\n");
			out.write("Host: " + host + "\r\n");
			out.write("\r\n");
			out.flush();

			// Read Response
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// Read Header
			String s;
			while (!(s = in.readLine()).equals("")) {
				System.out.println(s);
			}
			System.out.println();
			
			//Read Length
			String contentLength=in.readLine();
			int length=Integer.MAX_VALUE;
			try {
				length=Integer.parseInt(contentLength.trim(),16);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(contentLength);
			
			int c;
			int i=0;
			while((c=in.read())!=-1&&i++<length){
				System.out.write(c);;
			}
			
			System.out.println();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
