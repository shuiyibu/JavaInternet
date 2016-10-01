package _08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class DictClient {
	public static final String SERVER = "dict.org";
	public static final int PORT = 2628;
	public static final int TIMEOUT = 15000;

	public static void main(String[] args) {
		try (Socket socket = new Socket(SERVER, PORT)) {
			socket.setSoTimeout(TIMEOUT);
			OutputStream out = socket.getOutputStream();
			Writer writer = new OutputStreamWriter(out, "UTF-8");
			writer = new BufferedWriter(writer);
			InputStream in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			for (String word : args) {
				define(word, writer, reader);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void define(String word, Writer writer, BufferedReader reader) throws IOException {
		writer.write("DEFINE eng-lat " + word + "\r\n");
		writer.flush();

		for (String line = reader.readLine(); line != null; line = reader.readLine()) {
			if (line.startsWith("250 "))
				return;
			else if (line.startsWith("552 ")) {
				return;
			} else if (line.matches("\\d\\d\\d .*"))
				continue;
			else if (line.trim().equals(""))
				continue;
			else
				System.out.println(line);

		}
	}
}
