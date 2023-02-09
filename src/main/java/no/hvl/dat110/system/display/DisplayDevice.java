package no.hvl.dat110.system.display;



import no.hvl.dat110.rpc.RPCServer;
import no.hvl.dat110.system.controller.Common;
import no.hvl.dat110.system.sensor.SensorImpl;


public class DisplayDevice {
	
	public static void main(String[] args) {
		
		System.out.println("Display server starting ...");
		
		
		// implement the operation of the display RPC server
		//RPCClient displayserver = new RPCClient(null, Common.DISPLAYPORT);
		RPCServer displayserver = new RPCServer(Common.DISPLAYPORT);

		DisplayImpl display= new DisplayImpl((byte)Common.WRITE_RPCID,displayserver);
		
		displayserver.run();
		
		displayserver.stop();
		// see how this is done for the sensor RPC server in SensorDevice
		
		
		System.out.println("Display server stopping ...");
		
	}
}
