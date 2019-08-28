## Performance testing using Apache Bench tool
OTMS application /trip.html endpoint was subjected to load testing using Apache Bench tool (ab).

### Load test parameters:-

- Total Number of requests:      10000
- Number of Concurrent requests:   100

### Load test results:-

- Complete requests:      10000
- Failed requests:        0
- Time per request:       857.534 [ms] (mean)

### Detailed load test report

```
[senthilraja_gcp@s2 ~]$ ab -n 10000 -c 100 -H "Cookie: JSESSIONID=8E69001ACB49E9065FBAC4F2803D16E4" http://34.93.165.49:8080/trips.html
This is ApacheBench, Version 2.3 <$Revision: 1430300 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking 34.93.165.49 (be patient)
Completed 1000 requests
Completed 2000 requests
Completed 3000 requests
Completed 4000 requests
Completed 5000 requests
Completed 6000 requests
Completed 7000 requests
Completed 8000 requests
Completed 9000 requests
Completed 10000 requests
Finished 10000 requests


Server Software:        
Server Hostname:        34.93.165.49
Server Port:            8080

Document Path:          /trips.html
Document Length:        3289 bytes

Concurrency Level:      100
Time taken for tests:   85.753 seconds
Complete requests:      10000
Failed requests:        0
Write errors:           0
Total transferred:      36080000 bytes
HTML transferred:       32890000 bytes
Requests per second:    116.61 [#/sec] (mean)
Time per request:       857.534 [ms] (mean)
Time per request:       8.575 [ms] (mean, across all concurrent requests)
Transfer rate:          410.88 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    4   7.2      1     109
Processing:    23  851 694.0    762    7259
Waiting:       23  849 693.0    761    7259
Total:         23  855 694.2    767    7264

Percentage of the requests served within a certain time (ms)
  50%    767
  66%    919
  75%   1069
  80%   1236
  90%   1648
  95%   2076
  98%   2707
  99%   3411
 100%   7264 (longest request)
```