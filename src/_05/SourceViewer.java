package _05;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class SourceViewer {
	public static void main(String[] args) {
		String url = args.length != 0 ? args[0] : "http://www.oreilly.com";

		try {
			URL u = new URL(url);
			try (InputStream in = new BufferedInputStream(u.openStream())) {

				for (int c = in.read(); c != -1; c = in.read()) {
					System.out.print((char) c);
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println();
			URL u1=new URL("http://www.ibiblo.org/javafaq/index.html");
			URL u2=new URL(u1,"mailinglists.html");
			System.out.println(u2);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
