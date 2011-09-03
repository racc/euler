#!/usr/bin/python2.7

def transform(x):
	return int(str(x)[::-1]) + x

def is_palindrome(x):
	x_str = str(x)
	return x_str == x_str[::-1]

def is_lychrel(x):
	pal = transform(x)
	for i in xrange(0, 50):
		if (is_palindrome(pal)):
			return False
		else:
			pal = transform(pal)

	return True

count = 0
for i in xrange(1, 10000):
	if (is_lychrel(i)):
		count += 1

print(count)
