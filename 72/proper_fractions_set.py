#!/usr/bin/python2.7

import os, sys
sys.path.append("../69")

from totient import *

def farey_terms(n):
	count = 0
	for i in xrange(1, n + 1):
		count += totient(i)
	return count + 1 

print(farey_terms(1000000) - 2)
