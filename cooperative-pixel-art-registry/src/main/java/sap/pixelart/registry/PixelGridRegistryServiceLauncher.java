package sap.pixelart.registry;

import java.net.URI;

public class PixelGridRegistryServiceLauncher {
		
	public static final String REGISTRY_ADDRESS = "http://localhost:9000"; 
	
    public static void main(String[] args) throws Exception {

    	var localAddress = new URI(REGISTRY_ADDRESS).toURL();    	

    	PixelGridRegistryService service = new PixelGridRegistryService(localAddress);
    	service.launch();
    }
}
