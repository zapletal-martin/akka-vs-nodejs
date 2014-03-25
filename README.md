akka-vs-nodejs
==============

Simple implementation of http server responsding on one resource '/factorial?param=x'

One implementation is in node.js and another one in scala/akka and using socko web server

This is used for comparison of code, productivity and performance.

Results of trivial performance competition. Just really simple test using ab (in this case ab -n 10000 -c 1000 http://localhost:1337/factorial?param=50)

Akka
-----------------------------------------------------------------------------------
Server Software:        
Server Hostname:        localhost
Server Port:            1338

Document Path:          /factorial?param=50
Document Length:        1 bytes

Concurrency Level:      1000
Time taken for tests:   1.765 seconds
Complete requests:      10000
Failed requests:        0
Write errors:           0
Total transferred:      980000 bytes
HTML transferred:       10000 bytes
Requests per second:    5664.63 [#/sec] (mean)
Time per request:       176.534 [ms] (mean)
Time per request:       0.177 [ms] (mean, across all concurrent requests)
Transfer rate:          542.12 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0   58 231.1      0    1005
Processing:     0   14  27.1      9     245
Waiting:        0   14  26.9      9     245
Total:          0   73 245.5     10    1245

Percentage of the requests served within a certain time (ms)
  50%     10
  66%     13
  75%     15
  80%     17
  90%     46
  95%   1011
  98%   1030
  99%   1229
 100%   1245 (longest request)


Node.js
-------------------------------------------------------------------------------------------------
Server Software:        
Server Hostname:        localhost
Server Port:            1337

Document Path:          /factorial?param=50
Document Length:        22 bytes

Concurrency Level:      1000
Time taken for tests:   2.460 seconds
Complete requests:      10000
Failed requests:        0
Write errors:           0
Total transferred:      970000 bytes
HTML transferred:       220000 bytes
Requests per second:    4065.22 [#/sec] (mean)
Time per request:       245.989 [ms] (mean)
Time per request:       0.246 [ms] (mean, across all concurrent requests)
Transfer rate:          385.08 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0   78 264.1      0    1002
Processing:    17   40  39.2     28     469
Waiting:       16   40  39.2     28     469
Total:         26  118 271.2     28    1467

Percentage of the requests served within a certain time (ms)
  50%     28
  66%     31
  75%     34
  80%     39
  90%    194
  95%   1031
  98%   1040
  99%   1048
 100%   1467 (longest request)
