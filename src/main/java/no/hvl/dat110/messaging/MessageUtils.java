package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {
		
		byte[] segment =new byte[SEGMENTSIZE];
		byte[] data;
		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messaging layer
		data=message.getData();
		segment[0]=(byte) data.length;
		
		int i=0;
		for(i =0; i< data.length; i++ ) {
		segment[i+1]=data[i];
		
		}
		return segment;
		}
	
	

	public static Message decapsulate(byte[] segment) {

		byte[] data= new byte[segment[0]];
		
		int i=0;
		for(i =0; i< segment[0]; i++ ) {
			data[i]=segment[i+1];
			}
		return new Message(data);
		}
	
}//implementing methods for encapsulation and decapsulation of data according to the segment format described above.
