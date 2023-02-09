package no.hvl.dat110.messaging;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Socket;

import no.hvl.dat110.TODO;


public class MessageConnection {

	private DataOutputStream outStream; // for writing bytes to the underlying TCP connection
	private DataInputStream inStream; // for reading bytes from the underlying TCP connection
	private Socket socket; // socket for the underlying TCP connection
	
	public MessageConnection(Socket socket) {

		try {

			this.socket = socket;

			outStream = new DataOutputStream(socket.getOutputStream());

			inStream = new DataInputStream (socket.getInputStream());

		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void send(Message message) {
		
		byte[] data =null;
		
		data=MessageUtils.encapsulate(message);
		try {
		outStream.write(data);
		}catch(IOException ex) {
			
		}}
	public Message receive() {

		Message message = null;
		byte[] data;
		data = new byte[128];
	      try { 
	    	  message=MessageUtils.decapsulate(data);
	    	  for(int i = 0; i < data.length; i++) {
	    		  data[i] = inStream.readByte();
	    	  }
	    	 message = MessageUtils.decapsulate(data);
	      } catch(Exception e) {}
	       
	    return message;
	         
	       	
	}

	// close the connection by closing streams and the underlying socket	
	public void close() {

		try {
			
			outStream.close();
			inStream.close();

			socket.close();
			
		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
//inStream.read(data);
// data=inStream.readAllBytes();
//int count = inStream.available();
 //data= new byte[count];