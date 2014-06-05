window.wifiConnect = function(callback,args) {
    cordova.exec(
            function(data){callback(data);},
            function(err){callback(err);},
            "WifiConnect",
            'connectTo',
            args
    );
};
