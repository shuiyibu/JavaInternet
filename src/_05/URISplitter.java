package _05;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URISplitter {
public static void main(String[] args) {
	try {
		URI absolute=new URI("http","//www.ibiblio.org",null);
		URI relative=new URI(null,"/javafaq/index.shtml","today");
		System.out.print(absolute+": ");
		System.out.println(absolute.isOpaque());
		System.out.print(relative+": ");
		System.out.println(relative.isOpaque());
		
		URI abs=new URI("http://www.example.com/");
		URI rel=new URI("images/logo.png");
		URI res=abs.resolve(rel);
		System.out.println(res);
		
	
		URI res2=abs.resolve(res);
		System.out.println(res2);
		URI res3=res.resolve(abs);
		System.out.println(res3);
		
		URI absolute2=new URI("http://www.example.com/images/logo.png");
		URI top=new URI("http://www.example.com/");
		URI relative2=top.resolve(absolute2);
		System.out.println(relative2);
		URI relative3=absolute2.resolve(top);
		System.out.println(relative3);
		
		String query=URLEncoder.encode("https://www.google.com/search?h1=en&as_q=Java&as_epq=I/O","UTF-8");
		System.out.println(query);
		System.out.println(URLDecoder.decode(query,"UTF-8"));
		
		String url="https://www.google.com/search?";
		url+=URLEncoder.encode("h1","UTF-8");
		url+="=";
		url+=URLEncoder.encode("en","UTF-8");
		url+="&";
		url+=URLEncoder.encode("as_q","UTF-8");
		url+="=";
		url+=URLEncoder.encode("Java","UTF-8");
		url+="&";
		url+=URLEncoder.encode("as_epq","UTF-8");
		url+="=";
		url+=URLEncoder.encode("I/O","UTF-8");
		
		System.out.println(url);
		String output=URLDecoder.decode(url,"UTF-8");
		System.out.println(output);
	} catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
