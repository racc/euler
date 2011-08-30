#!/usr/bin/ruby

require 'set'

def sieve(x)
	limit = Math.sqrt(x).ceil
	primes = Set.new((2..x))
	(2..limit).each do |d| 
		primes.select! { |p| p == d || p % d != 0 }
	end
	primes
end

PRIMES = sieve(800000)
NON_TRUNCATABLE = [2, 3, 5, 7]

def is_truncatable_prime?(p)
	return false if NON_TRUNCATABLE.include? p
	str = p.to_s
	limit = str.size
	truncs = (0..limit).map do |x| 
	[str[0..limit - x], str[x..limit]]
	end.flatten.uniq.reject { |x| x.empty? }
	truncs.all? {|x| PRIMES.include? x.to_i }
end

p PRIMES.select { |x| is_truncatable_prime?(x) }.reduce(:+)
