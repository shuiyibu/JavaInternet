package _04;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

public class SourceViewer {
	public static void main(String[] args) {
		String url = "http://www.oreilly.com";

		try {
			URL u = new URL(url);
			try (InputStream in = new BufferedInputStream(u.openStream())) {
				Reader r = new InputStreamReader(in);
				int c;
				while ((c = r.read()) != -1)
					System.out.print((char) c);
			} catch (Exception e) {
				// TODO: handle exception
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
