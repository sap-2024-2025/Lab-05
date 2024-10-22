package sap.pixelart.dashboard;

import java.net.URI;

import io.vertx.core.Future;
import sap.pixelart.dashboard.controller.Controller;
import sap.pixelart.library.PixelGridAsyncAPI;
import sap.pixelart.library.PixelArtServiceLib;

public class PixelArtDashboardLauncher {
	
	public final static String PIXEL_GRID_ADDRESS = "http://localhost:9100";
	
	public static void main(String[] args) throws Exception {

		var lib = PixelArtServiceLib.getInstance();
		var gridURL = new URI(PIXEL_GRID_ADDRESS).toURL();
		PixelGridAsyncAPI proxy = lib.getPixelGrid(gridURL);
		Controller controller = new Controller(proxy);
		controller.init();
		
	}
}
