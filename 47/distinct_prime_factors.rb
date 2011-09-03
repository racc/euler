#!/usr/bin/ruby

def factors(x)
	`factor #{x} | cut -d: -f2`.split.uniq
end

NEXT_N = 4

(125000..150000).each do |x|
	if factors(x).size == NEXT_N
		next_n = (1..(NEXT_N - 1)).all? do |n|
			y = x + n	
			factors(y).size == NEXT_N
		end

		if next_n
			puts x
			break
		end
	end
end
