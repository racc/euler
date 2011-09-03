#!/usr/bin/python2.7

import itertools

digits = ["1","2","3","4","5","6","7","8","9"]
digits_set = set(digits)
prod_tuples = [(3, 2), (4, 1)]

def prod_is_pandigital(prod, diff):
	sorted_digits = sorted(list(str(prod)) + diff)
	return sorted_digits == digits

def iter_to_int(t):
	return int("".join(t))

prods = set([])

for tup in prod_tuples:
	for comb in itertools.combinations(digits, tup[0]):
		for perm in itertools.permutations(comb):
			diff = list(digits_set - set(perm))
			a = iter_to_int(perm)
			for comb_diff in itertools.combinations(diff, tup[1]):
				args = list(comb_diff) + list(perm)
				for perm_diff in itertools.permutations(comb_diff):
					b = iter_to_int(perm_diff)
					prod = a * b
					if (prod_is_pandigital(prod, args)):
						prods.add(prod)
	
print(reduce(lambda x, y: x + y, prods))
