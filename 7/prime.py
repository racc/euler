#!/usr/bin/python2.7

import math

def is_prime(x):
	lim = int(math.ceil(math.sqrt(x)))
	return all(x % i != 0 for i in xrange(2, lim + 1))

n = 1
x = 3 
while (n < 10001):
	if is_prime(x):
		print x
		n += 1
	x += 1
