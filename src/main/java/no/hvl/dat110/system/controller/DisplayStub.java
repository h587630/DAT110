package no.hvl.dat110.system.controller;


import no.hvl.dat110.rpc.*;
import no.hvl.dat110.rpc.RPCUtils;

public class DisplayStub extends RPCLocalStub {
	
	
	public DisplayStub(RPCClient rpcclient) {
		super(rpcclient);
	}
	
	public void write (String message) {
		
		//not sure check with the assistant
				byte[] request;
				
					request = RPCUtils.marshallString(message);
					byte[] response = rpcclient.call((byte)Common.WRITE_RPCID, request);
					
					RPCUtils.unmarshallVoid(response);
				
				
		
		
	
}}
