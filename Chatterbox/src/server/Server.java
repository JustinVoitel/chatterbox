package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server extends Thread{
	private static int port = 8010;

	public static void main(String[] args) throws IOException {
		boolean active = true;
		Scanner scanner = new Scanner(System.in);
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("Server running @: "+InetAddress.getLocalHost().getHostAddress());
		Socket clientSocket = serverSocket.accept();
		OutputStream socketoutstr = clientSocket.getOutputStream(); 
		OutputStreamWriter osr = new OutputStreamWriter( socketoutstr ); 
		BufferedWriter bw = new BufferedWriter( osr ); 
		
		InputStream socketinstr = clientSocket.getInputStream(); 
		InputStreamReader isr = new InputStreamReader( socketinstr ); 
		BufferedReader br = new BufferedReader( isr ); 
		
		String anfrage; 
		String antwort; 
		while(active) {
			
			anfrage = br.readLine();
			System.out.println(anfrage);
			
			antwort = scanner.nextLine(); 
			bw.write(antwort); 
			bw.newLine(); 
			bw.flush(); 
		}
		

		bw.close(); 
		br.close(); 
		clientSocket.close(); 
		serverSocket.close();
	}

}
