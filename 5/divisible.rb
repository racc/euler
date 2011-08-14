#!/usr/bin/ruby

a = 20
loop do
	break if (1..20).all? { |n| a % n == 0 }
	a += 20
end

puts a
