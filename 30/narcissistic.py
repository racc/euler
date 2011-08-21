#!/usr/bin/python2.7
import math

numbers = []
exponent = 5

for i in xrange(2, 1000000):
	sum_of_pow = reduce(lambda x, y: int(x) + math.pow(int(y), exponent), str(i), 0)
	if (sum_of_pow == i):
		numbers.append(i)

print(reduce(lambda x, y: x + y, numbers))
