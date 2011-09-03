#!/usr/bin/ruby

DIGITS = (1..9).map(&:to_s)
def pandigital(x)
	digits = x.map(&:to_s).join
	if digits.split(//).sort! == DIGITS
		digits.to_i
	else
		nil
	end
end

max = 0
(1..10000).each do |x|
	prods = [x]	
	(2..9).each do |n|
		prods << n * x	
		p = pandigital(prods)
		max = p if p && p > max
	end
end

p max
