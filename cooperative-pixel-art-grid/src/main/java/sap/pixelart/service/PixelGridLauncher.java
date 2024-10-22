package sap.pixelart.service;

import java.net.URI;

public class PixelGridLauncher {
		
	public static final String SERVICE_ADDRESS = "http://localhost:9100"; 
	
    public static void main(String[] args) throws Exception {

    	var gridId = "my-grid-00";
    	var localAddress = new URI(SERVICE_ADDRESS).toURL();    	

    	PixelGrid service = new PixelGrid(gridId, localAddress);
    	service.launch();
    }
}
