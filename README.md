akka-vs-nodejs
==============

Simple implementation of http server responsding on one resource '/factorial?param=x'

One implementation is in node.js and another one in scala/akka and using socko web server

This is used for comparison of code, productivity and performance.

Results of trivial performance competition. Just really simple test using ab (in this case ab -n 10000 -c 1000 http://localhost:1337/factorial?param=50). The results should be kind of fair - same requests, responses, calculations done, same computer.

Akka
-----------------------------------------------------------------------------------
Server Software:
Server Hostname:        localhost
Server Port:            1338

Document Path:          /factorial?param=50
Document Length:        65 bytes

Concurrency Level:      1000
Time taken for tests:   13.960 seconds
Complete requests:      100000
Failed requests:        0
Write errors:           0
Total transferred:      16200000 bytes
HTML transferred:       6500000 bytes
Requests per second:    7163.22 [#/sec] (mean)
Time per request:       139.602 [ms] (mean)
Time per request:       0.140 [ms] (mean, across all concurrent requests)
Transfer rate:          1133.24 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0  117 451.1      0    7013
Processing:     0   16  36.7     10     908
Waiting:        0   15  36.6     10     908
Total:          0  133 461.5     11    7257

Percentage of the requests served within a certain time (ms)
  50%     11
  66%     14
  75%     18
  80%     21
  90%     69
  95%   1014
  98%   1050
  99%   1272
 100%   7257 (longest request)


Node.js
-------------------------------------------------------------------------------------------------
Server Software:
Server Hostname:        localhost
Server Port:            1337

Document Path:          /factorial?param=50
Document Length:        22 bytes

Concurrency Level:      1000
Time taken for tests:   24.624 seconds
Complete requests:      100000
Failed requests:        0
Write errors:           0
Total transferred:      9700000 bytes
HTML transferred:       2200000 bytes
Requests per second:    4061.13 [#/sec] (mean)
Time per request:       246.237 [ms] (mean)
Time per request:       0.246 [ms] (mean, across all concurrent requests)
Transfer rate:          384.70 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0  173 696.2      0   15028
Processing:    17   64  40.9     62    1776
Waiting:       16   64  40.9     62    1776
Total:         24  237 710.1     63   15095

Percentage of the requests served within a certain time (ms)
  50%     63
  66%     68
  75%     71
  80%     74
  90%   1048
  95%   1067
  98%   3059
  99%   3074
 100%  15095 (longest request)
