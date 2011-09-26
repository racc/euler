#!/usr/bin/ruby

lower = 101010101  # 10203040506070809 ** 0.5
upper = 138902662  # 19293949596979899 ** 0.5
regex = /1\d2\d3\d4\d5\d6\d7\d8\d9/

# Squares of even numbers are even (and in fact divisible by 4)
result = lower.step(upper, 4).find do |x|
	(x ** 2).to_s.match(regex)
end

p result * 10
