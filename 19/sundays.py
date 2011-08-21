#!/usr/bin/python2.7
import datetime

sundays = 0

for y in xrange(1901, 2001):
	for m in xrange(1, 13):
		date = datetime.date(y, m, 1)
		if (date.weekday() == 6):
			sundays += 1

print(sundays)
