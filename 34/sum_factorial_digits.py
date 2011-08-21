#!/usr/bin/python2.7
import math

curious_nums = []

for i in range(3, 1000000):
	sum_of_facts = reduce(lambda x, y: int(x) + math.factorial(int(y)), str(i), 0)
	if sum_of_facts == i:
		curious_nums.append(i)

print(reduce(lambda x, y: x + y, curious_nums))
