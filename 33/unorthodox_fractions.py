#!/usr/bin/python2.7
from fractions import Fraction

def replace_single(str_n, r):
	repl = str_n.replace(r, "")
	if not repl:
		repl = r 
	return repl

unorthodox_f = []
for d in xrange(12, 100):
	if "0" in str(d):
		continue
	
	for n in xrange(11, d):
		if "0" in str(n) or all(k not in str(d) for k in str(n)):
			continue

		f = Fraction(n, d)
		for k in str(n):
			str_d = str(d)
			repl_d = replace_single(str_d, k)
			repl_n = replace_single(str(n), k)

			if repl_d != str_d:
				reduced_f_str = "%s/%s" % (repl_n, repl_d)
				reduced_f = Fraction(reduced_f_str)	
				if (reduced_f == f):
					unorthodox_f.append(f)

print(reduce(lambda x, y: x * y, unorthodox_f).denominator)
