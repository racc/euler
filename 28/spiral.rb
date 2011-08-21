#!/usr/bin/ruby

diagonal_sum = 1
last = 1

(3..1001).step(2) do |x|
	delta = x - 1
	(1..4).each do |corner|
		last += delta
		diagonal_sum += last
	end
end	

puts diagonal_sum
