#!/usr/bin/ruby

last_exp = 0
count = 0

(1..1000).each do |x|
	decimal = Rational(1, (2 + last_exp))
	last_exp = decimal
	sqrt_two = 1 + decimal 
	count += 1 if sqrt_two.numerator.to_s.size > sqrt_two.denominator.to_s.size
end

p count
