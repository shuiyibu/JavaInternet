package _09;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.OverlayLayout;

public class PooledDaytimeServer {
	public final static int PORT = 13;
	public final static int SIZE = 50;

public static void main(String[] args) {
	
	ExecutorService pool=Executors.newFixedThreadPool(SIZE);
	try(ServerSocket server=new ServerSocket(PORT)){
		while(true){
			Socket connection=server.accept();
			Callable<Void> task=new  DaytimeTask(connection);
		}
	}catch (Exception e) {
		
		// TODO: handle exception
	}
}

	private static class DaytimeTask implements Callable<Void> {

		private Socket connection;

		public DaytimeTask(Socket connection) {
			this.connection = connection;
		}

		@Override
		public Void call() throws Exception {
			// TODO Auto-generated method stub
			try (Writer out = new OutputStreamWriter(connection.getOutputStream())) {
				Date now = new Date();
				out.write(now.toString() + "\r\n");
				out.flush();
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					connection.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			return null;
		}

	}
}
