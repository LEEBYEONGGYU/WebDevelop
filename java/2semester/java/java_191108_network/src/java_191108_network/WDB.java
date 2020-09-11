package java_191108_network;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WDB {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.yju.ac.kr/kr/index.do");
			URLConnection develop = url.openConnection();
			InputStream is = develop.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String inLine;
			while((inLine = br.readLine()) !=null) {
				System.out.println(inLine);
			}
			br.close();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
