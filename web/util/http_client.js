/**
 * Created by Administrator on 2014/10/6.
 */


var http = require('http');
var Url = require('./../util/constant.js');

exports.getUrl=function get_http_GetUrl(host,port,path,type){
    var options = {
        host: host,
        port: port,
        path: path,
        method: type,
        headers: {
            'Content-Type': 'application/json'
        }
    };
    return options;
};

exports.request = function request(options, callback,params) {
    var post_data = "";
    var logInfo = "Http Request，url:" + "http://" + options.host + ":"
        + options.port + options.path;

    if(params){
        post_data = JSON.stringify(params);
        logInfo = logInfo +",params:"+post_data;
    }

    var post_req = http.request(options, function(result) {
        console.log(logInfo);
        var data = '';
        result.setEncoding("utf8");
        result.on("data", function(chunk) {
            data += chunk;
        });

        result.on('end', function() {
            console.log("Request Return Data:" + data.toString());
            callback(data);
        });
    });

    post_req.setTimeout(Url.time_out, function() {
        post_req.abort();
        callback(new Error('Request timeout'));
    });

    post_req.on('error', function(e) {
        callback(new Error("httpGet : exception " + e.message));
    });
    if(params){
        post_req.write(post_data);
    }
    post_req.end();

};


exports.getImage = function getImage(path,callback){
    // Make request to our image url
    request({url: path, encoding: null}, function (err, res, body) {
        if (!err && res.statusCode == 200) {
            // So as encoding set to null then request body became Buffer object
            var binary = body.toString('binary');
            if (typeof callback == 'function') {
                callback(binary);
            }
        } else {
            throw new Error('Can not download image');
        }
    });
};



