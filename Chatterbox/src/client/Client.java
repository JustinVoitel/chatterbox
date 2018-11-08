package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client extends Thread{
	private static String host = "192.168.99.1";
	private static int port = 8010; 
	public static void main(String[] args) throws UnknownHostException, IOException {
		boolean active = true;
		Scanner scanner = new Scanner(System.in);
		
	    Socket socket = new Socket(host,port);
	    System.out.println("connected to server: "+host);

	    OutputStream socketoutstr = socket.getOutputStream(); 
	    OutputStreamWriter osr = new OutputStreamWriter( socketoutstr ); 
	    BufferedWriter bw = new BufferedWriter( osr ); 

	    InputStream socketinstr = socket.getInputStream(); 
	    InputStreamReader isr = new InputStreamReader( socketinstr ); 	     
	    BufferedReader br = new BufferedReader( isr ); 
	    
	    String anfrage;
	    String antwort;
	    while(active) {
	    	
	    	anfrage = scanner.nextLine();
	    	bw.write(anfrage); 
	    	bw.newLine(); 
	    	bw.flush();
	    	
	    	antwort = br.readLine(); 
	    	System.out.println(antwort); 
	    	//System.out.println("Host = "+host); 
	    	
	    	
	    }
	    bw.close(); 
	    br.close(); 
	    socket.close();
	}

}
