#!/usr/bin/python2.7
# See http://www.blindrut.ca/~neitsch/math/talks/m496pres1.nb.pdf
a = [1, 2, 5, 10, 20, 50, 100, 200]

def fn(n, k):
	if k < 0 or n < 0:
		return 0
	elif n == 0:
		return 1
	else:
		return fn(n, k - 1) + fn(n - a[k], k)

print(fn(200, 7))
