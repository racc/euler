#!/usr/bin/python2.7
# See http://en.wikipedia.org/wiki/Partition_function_(number_theory)

cache = {}
def i(k, n):
	'''Number of partitions n, only using natural numbers at least as large as k'''
	if k > n:
		return 0
	elif k == n:
		return 1
	else:
		if (k, n) in cache:
			return cache[(k, n)]
		else:
			cached = i(k + 1, n) + i(k, n - k)
			cache[(k, n)] = cached
			return cached

def p(n):
  return reduce(lambda x, y: x + i(y, n - y), xrange(1, (n/2) + 1), 0)

print(p(100))
