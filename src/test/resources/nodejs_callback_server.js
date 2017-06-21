/**
 * Created by ohun on 2017/6/16.
 */
var http = require('http');
var crypto = require('crypto');

/**
 * 加密方法
 */
var encrypt = function (key, data) {
    var cipher = crypto.createCipheriv('aes-128-ecb', key, "");
    var crypted = cipher.update(data, 'utf8', 'latin1');
    crypted += cipher.final('latin1');
    return crypted;
};

/**
 * 解密方法
 */
var decrypt = function (key, crypted) {
    var decipher = crypto.createDecipheriv('aes-128-ecb', key, "");
    var decoded = decipher.update(crypted, 'latin1', 'utf8');
    decoded += decipher.final('utf8');
    return decoded;
};

/**
 * sha1
 */
var sha1 = function (data) {
    var hash = crypto.createHash("sha1");
    hash.update(data, "utf8");
    return hash.digest('hex');
};

/**
 * 校验签名
 */
var validateSignature = function (signature4check, token, nonce, timestamp, encrypt) {
    var str = "encrypt=" + encrypt + "&nonce=" + nonce + "&timestamp=" + timestamp + "&token=" + token;
    var signature = sha1(str);
    return signature4check === signature;
};

const port = 8888;
const appSecret = "0123456789abcdef";
const appToken = "0123456789abcdef";

var server = http.createServer(function (req, res) {
    if (req.method.toUpperCase() === 'POST') {
        var postData = "";
        req.addListener("data", function (data) {
            postData += data;
        });

        req.addListener("end", function () {
            console.log(postData);

            //1.解析数据
            var eventBody = JSON.parse(postData);

            //2.校验签名
            var result = validateSignature(eventBody.signature, appToken, eventBody.nonce, eventBody.timestamp, eventBody.encryptData);
            console.log("validateJsapiSignature=" + result);

            //3.解密数据
            var rawData = decrypt(appSecret, eventBody.encryptData);
            console.log(rawData);

            //4.解析事件,
            //var callbackEvent = JSON.parse(rawData);

            //5.响应处理成功
            res.writeHead(200, {'Content-Type': 'application/json; charset=utf-8'});
            res.write(JSON.stringify({status: 0, message: "success"}));
            res.end();
        });
    }
});

server.listen(port);
console.log("Server running at port: " + port + ".");