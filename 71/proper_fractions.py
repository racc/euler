#!/usr/bin/python2.7

from fractions import Fraction

print((Fraction(3, 7) - Fraction(1, 1000000)).limit_denominator(1000000).numerator)
