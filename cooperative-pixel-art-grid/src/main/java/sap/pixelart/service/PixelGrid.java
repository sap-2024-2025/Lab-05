package sap.pixelart.service;

import java.net.URL;

import sap.pixelart.service.application.PixelGridImpl;
import sap.pixelart.service.application.PixelGridRegistryAPI;
import sap.pixelart.service.infrastructure.*;

public class PixelGrid {

	private PixelGridImpl service;
	private PixelGridRegistryAPI registry;
	private RESTPixelGridController adapter;
	private URL localAddress;
	
	public PixelGrid(String pixelGridId, URL localAddress) {
    	registry = new PixelGridRegistryProxy(localAddress);
    	service = new PixelGridImpl(pixelGridId, registry);
    	this.localAddress = localAddress;
 	}
	
	public void launch() {
		adapter = new RESTPixelGridController(localAddress.getPort());	    	
    	adapter.init(service);
	}
}
