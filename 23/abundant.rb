#!/usr/bin/ruby
require 'set'

def divisors(x)
	limit = Math.sqrt(x).ceil + 1
	initial_divisors = (1..limit).select { |d| x % d == 0 }
	divisors = Set.new(initial_divisors)
	initial_divisors.each do |d| 
  	dividend = x / d
    if (dividend != d and dividend != x)
    	divisors << dividend
		end
	end

	divisors
end

def abundant?(x)
	divisors(x).reduce(:+) > x
end

abundant_set = (4..20161).select { |x| abundant?(x)}
sum_of_two_abundants = Set.new
abundant_set.each do |x|
	abundant_set.each do |y|
		sum_of_two_abundants << x + y
	end
end

p (1..20161).select { |x| !sum_of_two_abundants.include?(x) }.reduce(:+)
