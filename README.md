# spray-test
A reproducible (I hope) example of spray's strange memory consumption.

Zero CPU activity aftet a bit of warmup with Apache Bench: `ab -n 1000 -c 40 "http://127.0.0.1:1111/"` After that no requests were made

As you can see, the memory keeps growing.

Run: `sbt "run-main TestServer"`

And observe: ![](https://www.dropbox.com/s/tn27tj07pr1k94u/Screenshot%202016-04-21%2012.08.11.png?dl=1)
