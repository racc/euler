#!/usr/bin/python2.7

from math import sqrt

def expand(sq, num, sub):
	den = (sq - sub * sub) / num
	next_term = int((sqrt(sq) + sub) / den)
	next_sub = den * next_term - sub
	return (next_term, den, next_sub)

def continued_fracs(sq):
	initial_guess = int(sqrt(sq))
	if (initial_guess ** 2 == sq):
		return []
	
	term, num, sub = expand(sq, 1, initial_guess) 			
 	terms = [term]
		
	while (True):
		if (term == initial_guess * 2):
			break
		term, num, sub = expand(sq, num, sub)
		terms.append(term)

	return terms

odd_period = 0
limit = 10001
for i in xrange(1, limit):
	if (len(continued_fracs(i)) % 2 != 0):
		odd_period += 1 

print(odd_period)
