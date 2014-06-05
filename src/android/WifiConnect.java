package org.apache.cordova.wificonnect;

import java.util.List;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;

public class WiFiConnect extends CordovaPlugin {
    
	public WiFiConnect() {
	}
	
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("connectTo")) {
			Context context = cordova.getActivity().getApplicationContext();
			PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, connect("PolarCape",context));
			pluginResult.setKeepCallback(true);
			callbackContext.sendPluginResult(pluginResult);
			return true;
		}
		return false;
	}
    
    boolean connect (String ssidName,Context context) {
	    boolean result = false;
	    WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
	    List<WifiConfiguration> arraylist = wifiManager.getConfiguredNetworks();
	    for (WifiConfiguration wifiConfiguration : arraylist) {
	        String wifiConfigSSID = wifiConfiguration.SSID.replace("\"", "");
	        if (wifiConfigSSID.equals(ssidName)) {
	            result = wifiManager.enableNetwork(wifiConfiguration.networkId, true);
	            return result;
	        }
	    }
	    return false;
	}
	
}
