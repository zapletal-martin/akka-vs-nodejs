var http = require('http');
var url = require('url');
var calc = require('./factorial');

http.createServer(function (request, response) {
  var requestDetails = url.parse(request.url, true)

  console.log(requestDetails.pathname)
  console.log(requestDetails.query)

  if(requestDetails.pathname === '/factorial') {
    response.writeHead(200, {'Content-Type': 'text/plain'});
    response.end(calc.factorial(parseInt(requestDetails.query.param)).toString());
  }
}).listen(1337, '127.0.0.1');

console.log('Server running at http://127.0.0.1:1337/');
