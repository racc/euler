#!/usr/bin/python2.7

from fractions import Fraction

lower = Fraction(1, 3)
upper = Fraction(1, 2)
num_start = 4001
den = 12000
count = 0

while den > 1:
	num = num_start
	while Fraction(num - 1, den) > lower:
		num -= 1	

	num_start = num
	frac = Fraction(num, den)
	while frac < upper:
		if frac.denominator == den:
			count += 1
		num += 1
		frac = Fraction(num, den)

	den -= 1

print(count)
