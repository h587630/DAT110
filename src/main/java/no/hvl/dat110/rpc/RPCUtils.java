package no.hvl.dat110.rpc;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {
	
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		
		byte[] rpcmsg = new byte[payload.length+1];
		// Encapsulate the rpcid and payload in a byte array according to the RPC message syntax / format
		rpcmsg[0]= rpcid;
		
		for (int i=0; i<rpcmsg.length; i++) {
			rpcmsg[i+1]=payload[i];
		}
		
		return rpcmsg;
	}
	
	
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		
		byte[] payload = new byte[rpcmsg.length-1];
		
		// Decapsulate the rpcid and payload in a byte array according to the RPC message syntax
		for (int i=0; i<rpcmsg.length; i++) {
			payload[i]=rpcmsg[i+1];
		}
		
		return payload;
		
	}

	// convert String to byte array
	public static byte[] marshallString(String str){
		
		byte[] encoded= str.getBytes();
		return encoded;
		
		
		
	}

	// convert byte array to a String
	public static String unmarshallString(byte[] data) {
		
		return new String(data);
		 
		
	}
	
	//?
	public static byte[] marshallVoid() {
		
		byte[] encoded = null;
		
		
		
		return encoded;
		
	}
	//?
	public static void unmarshallVoid(byte[] data) {
		
	
	}

	// convert boolean to a byte array representation
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}

	// convert byte array to a boolean representation
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
		
	}

	// integer to byte array representation
	public static byte[] marshallInteger(int x) {
		
		 ByteBuffer encoded = ByteBuffer.allocate(4); 
		    encoded.putInt(x); 
		    return encoded.array();
	}
	
	
	// byte array representation to integer
	public static int unmarshallInteger(byte[] data) {
		
		  ByteBuffer decoded = ByteBuffer.wrap(data);
		    return decoded.getInt();
		
		
		
	}
}
