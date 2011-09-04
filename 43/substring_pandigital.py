#!/usr/bin/python2.7

def unique_digits(s):
	return len(set(s)) == len(s)

def digit_substrs(start, end, step):
	unfiltered = ["%03d" % i for i in range(start, end, step)]
	return [i for i in unfiltered if unique_digits(i)]

def flatten(it):
	for e in it:
		if isinstance(e, list):
			for f in flatten(e):
				yield f
		else:
			yield e

div_by = [2, 3, 5, 7, 11, 13, 17]
substrs = [digit_substrs(0, 999, i) for i in div_by]

def find_pandigitals(x, col_num, pandigital):
	if col_num == 0:
		return pandigital

	next_col = col_num - 1
	return [find_pandigitals(i, next_col, i[0] + pandigital) for i in substrs[next_col] if i[1:3] == x[0:2] and i[0] not in pandigital]

last_col = len(div_by) - 1 
missing_last_digit = [i for i in flatten([find_pandigitals(i, last_col, i) for i in substrs[last_col]])]

digits = set("1234567890")
def find_last_digit(x):
	return (digits - set(x)).pop()  

pandigitals = [int(find_last_digit(i) + i) for i in missing_last_digit]
print(reduce(lambda x, y: x + y, pandigitals))
