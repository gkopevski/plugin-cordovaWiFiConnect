package org.apache.cordova.wificonnect;

import java.math.BigInteger;
import java.net.InetAddress;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

public class WifiConnect extends CordovaPlugin {
    
	public WifiConnect() {
	}
	
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("connectTo")) {
			Context context = cordova.getActivity().getApplicationContext();
			PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, connect("PolarCape"));
			pluginResult.setKeepCallback(true);
			callbackContext.sendPluginResult(pluginResult);
			return true;
		}
		return false;
	}
    
    boolean connect (String ssidName) {
	    boolean result = false;
	    WifiManager wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
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
