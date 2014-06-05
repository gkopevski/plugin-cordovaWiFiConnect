plugin-cordovaWiFiConnect
==============

* License - The MIT License
* Test on Cordova 3.4.0


Install Step (Cordova CLI)
--------------------------

### 
	cordova plugin add https://github.com/gkopevski/plugin-cordovaWiFiConnect

API
-----

### Example 
```javascript
    
    var args = [{"SSID":"Goran's iPhone"}];
    window.wifiConnect(function(data){
        console.log(data);
    },args);


```
