#!/usr/bin/ruby

triangle = 1
i	= 2

loop {
	triangle += i
	i += 1

	limit = Math.sqrt(triangle).to_i
	factors =	(1..limit).select { |x| triangle % x == 0 }.size * 2
	if factors > 500 
		puts triangle
		break
	end
}
