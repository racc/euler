#!/usr/bin/python2.7

from math import factorial

fac = {}
for i in xrange(0, 10):
	fac[i] = factorial(i)

def sum_factorial_digits(x):
	return sum([fac[int(i)] for i in str(x)])

known = {}
def chain(x, terms):
	if (x in known):
		return len(terms) + known[x]

	if (x in terms):
		return len(terms)
	
	terms.append(x)
	return chain(sum_factorial_digits(x), terms)

count = 0
for i in xrange(1, 1000000):
	res = chain(i, [])
	known[i] = res
	if (res == 60):
		count += 1

print(count)
