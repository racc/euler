#!/usr/bin/python2.7

f1 = 1
f2 = 1
fn = 2
n = 3
while (len(str(fn)) < 1000):
	f1 = f2
	f2 = fn
	fn = f1 + f2 
	n += 1

print(n)
