package _09;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.ws.spi.http.HttpExchange;
import javax.xml.ws.spi.http.HttpHandler;

public class SingleFileHttpServer {
	private static final Logger logger = Logger.getLogger("SingleFileHttpServer");

	private final byte[] content;
	private final byte[] header;
	private final int port;
	private final String encoding;

	public SingleFileHttpServer(String data, String encoding, String mimeType, int port)
			throws UnsupportedEncodingException {
		this(data.getBytes(encoding), encoding, mimeType, port);
	}

	public SingleFileHttpServer(byte[] data, String encoding, String mimeType, int port) {
		super();
		this.content = data;

		this.port = port;
		this.encoding = encoding;
		String header = "HTTP/1.0 200 OK\r\n" + "Server: OneFile 2.0\r\n" + "Content-length: " + this.content.length
				+ "\r\n" + "Contetn-type: " + mimeType + ";charset=" + encoding + "\r\n\r\n";
		this.header = header.getBytes(Charset.forName("US-ASCII"));
	}

	public void start() {
ExecutorService pool=Executors.newFixedThreadPool(100);
try(ServerSocket server=new ServerSocket(this.port)){
	
	logger.info("Accepting connections on port "+server.getLocalPort());
	logger.info("Data to be sent:");
	logger.info(new String(this.content,encoding));
	
			 while(true){
				try {
					Socket connection = server.accept();
					pool.submit(new HTTPHandler(connection));
				} catch (IOException e) {
					// TODO: handle exception
				}
}
	
}catch (IOException e) {
	
}
	}

	private class HTTPHandler implements Callable<Void> {
		private final Socket connection;

		public HTTPHandler(Socket connection) {
			super();
			this.connection = connection;
		}

		@Override
		public Void call() throws Exception {
			// TODO Auto-generated method stub
			try (OutputStream out = new BufferedOutputStream(connection.getOutputStream());
					InputStream in = new BufferedInputStream(connection.getInputStream())) {
				StringBuilder request = new StringBuilder(80);
				while (true) {
					int c = in.read();
					if (c == '\r' || c == '\n' || c == -1)
						break;
					request.append((char) c);
				}
				if (request.toString().indexOf("HTTP/") != -1) {
					out.write(content);
				}
				out.write(content);
				out.flush();
			} catch (Exception e) {
				logger.log(Level.WARNING, "Error writing to client", e);
			} finally {
				connection.close();
			}
			return null;
		}

	}
	public static void main(String[] args) {
		int port=args.length>1?new Integer(args[1]):80;
		String encoding=args.length>2?args[2]:"UTF-8";
		String arg=args.length!=0?args[0]:"macfaq.dialup.cloud9.net";
		Path path=Paths.get(arg);
		try {
			byte[] data=Files.readAllBytes(path);
			String contentType=URLConnection.getFileNameMap().getContentTypeFor(arg);
			SingleFileHttpServer server=new SingleFileHttpServer(data, encoding, contentType, port);
			server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
