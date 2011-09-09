#!/usr/bin/python2.7

def next_term(s):
 	return reduce(lambda x, y: int(x) + int(y) ** 2, s, "0")

def chain(start, known_arrivals, accum):
	accum.add(start)
	term = next_term(str(start))
	if term in accum:
		return None
	elif term in known_arrivals:
		return accum	
	else:
		return chain(term, known_arrivals, accum)

known_arrivals = set([89])
for i in xrange(1, 10000000):
	if i not in known_arrivals:
		chained = chain(i, known_arrivals, set([]))
		if chained != None:
			known_arrivals |= chained

print(known_arrivals)
print(len(known_arrivals))
