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

PRIMES = sieve(10000).select { |x| x > 1000 }
grouped = PRIMES.group_by { |x| x.to_s.chars.sort }.values.reject {|v| v.size < 3 }

vals = grouped.map do |g|
	diffs_map = g.combination(2).to_a.map do |x| 
		Hash[(x[0] - x[1]).abs, x] 
	end.reduce({}) do |h, x| 
		h.merge(x) { |k, old, new| (old + new).sort.uniq }
	end
	diffs_map.values.select { |x| x.size == 3 }
end.reject { |x| x.empty? }

p vals[1][0].map { |x| x.to_s }.join("").to_i
