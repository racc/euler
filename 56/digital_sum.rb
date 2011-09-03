#!/usr/bin/ruby

max = 0
(1..100).each do |a|
	(1..100).each do |b|
		sum =	(a**b).to_s.split(//).map {|x| x.to_i }.reduce(:+)	
		max = sum if sum > max
	end
end

p max
