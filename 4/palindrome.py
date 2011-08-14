#!/usr/bin/python2.7

def is_palindrome(n):
	n_str = str(n)
	n_len = len(n_str) / 2
	return all(n_str[i] == n_str[-i - 1] for i in range(0, n_len))

max_mult = 0

for i in reversed(xrange(100, 999)):
	for j in reversed(xrange(100, 999)):
		mult = i * j
		if is_palindrome(mult):
			if mult > max_mult:
				max_mult = mult

print(max_mult)
