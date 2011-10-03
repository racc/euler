#!/usr/bin/python2.7

import fileinput

def dot(x, y):
	return float(sum([x[i] * y[i] for i in xrange(len(x))]))

def sub(x, y):
	return [x[i] - y[i] for i in xrange(len(x))]

def contains_origin(a, b, c):
	v0 = sub(a, c)
	v1 = sub(a, b)
	v2 = a

	dot00 = dot(v0, v0)
	dot01 = dot(v0, v1)
	dot02 = dot(v0, v2)
	dot11 = dot(v1, v1)
	dot12 = dot(v1, v2)

	inv = 1 / (dot00 * dot11 - dot01 * dot01)
	u = (dot11 * dot02 - dot01 * dot12) * inv
	v = (dot00 * dot12 - dot01 * dot02) * inv

	return (u > 0) and (v > 0) and (u + v < 1)	

count = 0
for line in fileinput.input("triangles.txt"):
	seq = [int(num) for num in line.split(",")]
	a, b, c = [seq[i:i+2] for i in range(0, 6, 2)]
	if contains_origin(a, b, c):
		count += 1	

print count
