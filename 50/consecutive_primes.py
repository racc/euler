#!/usr/bin/python2.7
from math import ceil, sqrt

def sieve(until):
	primes = range(2, until + 1)
	limit = int(ceil(sqrt(until)))

	for i in xrange(2, limit):
		primes[:] = [r for r in primes if r % i != 0 or r == i]

	return primes

num_primes = 1000000
primes = sieve(num_primes)
primes_len = len(primes)
prime_set = set(primes)

max_count = 0
max_sum = 2
sums = [primes[0]]

for i in xrange(1, primes_len):
	sums.append(sums[i - 1] + primes[i])

def max_vals(i, correction_factor):
	for j in reversed(xrange(i+1, primes_len)):
		count = j - i
		prime_sum = sums[j] - correction_factor	
		if prime_sum in prime_set: 
			return [count, prime_sum]
	return None

for i in xrange(0, primes_len):
	correction_factor = 0
	if i != 0:
		correction_factor = sums[i - 1] 

	vals = max_vals(i, correction_factor)	
	if vals:
		if vals[0] > max_count:
			max_count = vals[0]	
			max_sum = vals[1]

print(max_sum)
