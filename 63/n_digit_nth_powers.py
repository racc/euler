#!/usr/bin/python2.7
import math
a = [10 - math.ceil((10 ** (n - 1)) ** (1.0 / n)) for n in xrange(1, 23)]
print(int(reduce(lambda x, y: x + y, a)))
