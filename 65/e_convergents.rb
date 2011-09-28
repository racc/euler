#!/usr/bin/ruby

def terms(x)
	t = Array.new(x - 1, 1)
	1.step(x - 1, 3).each_with_index do |i, index|
		t[i] = (index + 1) * 2 unless t[i].nil?
	end	
	([2] + t).reverse
end

def continued_fraction(terms)
	if (terms.size == 1)
		terms.pop	
	else
		terms.pop + Rational(1, continued_fraction(terms))
	end
end

p continued_fraction(terms(100)).numerator.to_s.split(//).map(&:to_i).reduce(:+)
