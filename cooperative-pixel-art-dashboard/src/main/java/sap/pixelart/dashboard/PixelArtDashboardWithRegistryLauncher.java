package sap.pixelart.dashboard;

import java.net.URI;

import io.vertx.core.Future;
import sap.pixelart.dashboard.controller.Controller;
import sap.pixelart.library.PixelGridAsyncAPI;
import sap.pixelart.library.PixelArtServiceLib;

public class PixelArtDashboardWithRegistryLauncher {
	
	public final static String PIXEL_GRID_REGISTRY_ADDRESS = "http://localhost:9000";
	public final static String PIXEL_GRID_ID = "my-grid-00";
	
	public static void main(String[] args) throws Exception {

		var lib = PixelArtServiceLib.getInstance();

		var registryURL = new URI(PIXEL_GRID_REGISTRY_ADDRESS).toURL();
		var registry = lib.getPixelGridRegistry(registryURL);
		
		Future<String> gridAddress = registry.lookupPixelGrid(PIXEL_GRID_ID);		
		gridAddress.onSuccess(addr -> {
			try {
				var gridURL = new URI(addr).toURL();
				PixelGridAsyncAPI proxy = lib.getPixelGrid(gridURL);
				Controller controller = new Controller(proxy);
				controller.init();
			} catch (Exception ex) {}
		});	
	}
}
