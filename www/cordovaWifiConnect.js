window.wifiConnect = function(callback) {
    cordova.exec(
            function(data){callback(data);},
            function(err){callback(err);},
            "WifiConnect",
            'connect',
            []
    );
};
