#!/usr/bin/python2.7
import os, sys
sys.path.append("../69")

from totient import *

def is_permutation(a, b):
	return sorted(str(a)) == sorted(str(b)) 

min_ratio = float(1000000000)
min_n = 0

for n in xrange(2, 10 ** 7):
	t = totient(n)
	if is_permutation(n, t):
		ratio = float(n) / float(t)  
		if ratio < min_ratio:
			min_ratio = ratio
			min_n = n

print(min_n)
