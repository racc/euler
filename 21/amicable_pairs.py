#!/usr/bin/python2.7
import math

def sum_of_divisors(x):
	limit = int(math.ceil(math.sqrt(x))) + 1
	divisors = []
	for d in filter(lambda i: x % i == 0, range(1, limit)):
		divisors.append(d)
		dividend = x / d
		if (dividend != d and dividend != x):
			divisors.append(dividend)
	
	return reduce(lambda x, y: x + y, divisors)

amicable_numbers = set([])
for a in range(4, 10000):
	b = sum_of_divisors(a)
	if (sum_of_divisors(b) == a and a != b):
		amicable_numbers.add(a)
		amicable_numbers.add(b)	
	
print(reduce(lambda x, y: x + y, amicable_numbers))
		 
