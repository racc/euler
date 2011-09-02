#!/usr/bin/ruby

Factorial = Hash[1,1,0,1]
(2..101).each do |x|
	Factorial[x] = Factorial[x-1] * x
end

def c(n, r)
	n_r = Factorial[n - r]
	Factorial[n] / (Factorial[r] * n_r)
end

count = 0
(1..100).each do |n|
	(1..n).each do |r|
		if c(n, r) > 1000000
			count += 1	
		end
	end
end

p count
