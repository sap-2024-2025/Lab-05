package sap.pixelart.registry;

import java.net.URL;

import sap.pixelart.registry.domain.PixelGridRegistry;
import sap.pixelart.registry.domain.PixelGridRegistryAPI;
import sap.pixelart.registry.infrastructure.RESTPixelGridRegistryController;

public class PixelGridRegistryService {

	private PixelGridRegistryAPI registry;
	private RESTPixelGridRegistryController restBasedAdapter;
	private URL localAddress;
	
	public PixelGridRegistryService(URL localAddress) {
		registry = new PixelGridRegistry("reg");
    	this.localAddress = localAddress;
	}
	
	public void launch() {
		restBasedAdapter = new RESTPixelGridRegistryController(localAddress.getPort());	    	
    	restBasedAdapter.init(registry);
	}
}
