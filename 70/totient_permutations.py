#!/usr/bin/python2.7

# To really make this faster, find the biggest number < 10 ** 7 which is the multiple
# of two primes, where the totient function is a permutation
#
# This is because since phi(n) = n(1-1/p1)(1-1/p2)...(1-1/pk)
# n/phi(n) = 1/((1-1/p1)(1-1/p2)...(1-1/pk))
# We want to minimise n/phi(n) by maximising (1-1/p1)(1-1/p2)...(1-1/pk)
# So to maximise it, we need to minimise the number of entries (each multiplication makes it smaller)
# But also make p as large as possible...

import os, sys
sys.path.append(os.path.dirname(os.path.abspath(__file__)) + "/../util/python/")
from totient import *

def is_permutation(a, b):
	return sorted(str(a)) == sorted(str(b)) 

min_ratio = float(1000000000)
min_n = 0

for n in xrange(10 ** 6, 10 ** 7):
	t = totient(n)
	if is_permutation(n, t):
		ratio = float(n) / float(t)  
		if ratio < min_ratio:
			min_ratio = ratio
			min_n = n

print(min_n)
