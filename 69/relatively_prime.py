#!/usr/bin/python2.7
from totient import *

max_result = 0
max_n = 2
for n in xrange(2, 1000000):
	n_on_phin = float(n) / totient(n)
	if n_on_phin > max_result:
		max_result = n_on_phin
		max_n = n

print(max_n)
