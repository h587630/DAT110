package no.hvl.dat110.messaging;

import java.nio.charset.StandardCharsets;

import no.hvl.dat110.TODO;

public class Message {

	// the up to 127 bytes of data (payload) that a message can hold
	private byte[] data;
	
	int b = 1;

	// construction a Message with the data provided
	public Message(byte[] data) {
		if(data.length<= 127 && data!=null) {
			this.data=data;
			
		}	
		
	}

	public byte[] getData() {
		return this.data; 
	}

}

