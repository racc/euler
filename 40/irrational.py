#!/usr/bin/python2.7

s = ""
for i in range(1, 1000000):
	s += str(i)

def nth_digit(n):
	return int(s[n-1])

print(reduce(lambda x, y: x * nth_digit(pow(10, y)), range(0, 6), 1))
