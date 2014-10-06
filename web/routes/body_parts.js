var express = require('express');

var constant = require('../util/constant');
var http_client = require('../util/http_client');
var router = express.Router();

/* GET users listing. */
router.get('/:body_part', function(req, res) {

    var url=http_client.getUrl(constant.service_ip,constant.service_port,"/little_slave/api/bodypart/"+req.params.body_part,"GET");

    http_client.request(url,function(data){

        res.render("disease",{result:JSON.parse(data)});

    })
});

/* GET users listing. */
router.get('/type/:body_part', function(req, res) {

    var url=http_client.getUrl(constant.service_ip,constant.service_port,"/little_slave/api/bodypart/type/"+req.params.body_part,"GET");

    http_client.request(url,function(data){

        res.render("disease",{result:JSON.parse(data)});

    })
});

router.get('/disease/:disease_code', function(req, res) {

    var url=http_client.getUrl(constant.service_ip,constant.service_port,"/little_slave/api/bodypart/disease/"+req.params.disease_code,"GET");

    http_client.request(url,function(data){

        res.render("disease_info",{result:JSON.parse(data)});

    })
});

router.get('/disease/detail/:disease_code/:disease', function(req, res) {

    var url=http_client.getUrl(constant.service_ip,constant.service_port,"/little_slave/api/bodypart/disease/detail/"+req.params.disease_code,"GET");

    http_client.request(url,function(data){

        res.render("disease_detail_info",{result:JSON.parse(data),disease:req.params.disease});

    })
});

module.exports = router;
