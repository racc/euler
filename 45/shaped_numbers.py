#!/usr/bin/python2.7

import math

limit = 100000
triangle_numbers = []

def has_positive_integral_roots(a, b, c):
	sqrt_discriminant = math.sqrt(b*b - 4 * a * c)
	divisor = 2*a
	roots = [(-b + sqrt_discriminant), (-b - sqrt_discriminant)] 
	return any(i > 0 and i % divisor == 0 for i in roots)

def is_pentagonal(p):
	return has_positive_integral_roots(3, -1, -2 * p)

def is_hexagonal(h):
	return has_positive_integral_roots(2, -1, -h)

for n in range(286, limit):
	triangle_numbers.append((n * (n + 1))/2)

print [x for x in triangle_numbers if is_pentagonal(x) and is_hexagonal(x)]
