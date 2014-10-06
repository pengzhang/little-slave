/**
 * Created by Administrator on 2014/10/6.
 */
var constant = require('./constant');

var http_client = require('./http_client');

exports.getBodyPartDisease = function(req,res){

    var url=http_client.getUrl(constant.service_ip,constant.service_port,"api/bodypart/"+req.query['bodypart'],"GET");

    http_client.request(url,function(data){

        res.writeHead(200,{"Content-Type":"application/json"});

        res.end(data);

    })

}