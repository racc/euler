#!/usr/bin/ruby

#!/usr/bin/ruby

num_len = 2000

def shortest_repeating(s)
	found = 0
	max_expected_reoccuring_len = 1000
	num_repeat_tests = 10
	(0..max_expected_reoccuring_len).each do |x|
		found_reoccurring = (0..num_repeat_tests).all? do |n| 
			s[n..(n+x)] == s[(n+x+1)..(n+x+x+1)]
		end
		
		if found_reoccurring
			found = x + 1
			break
		end
	end
	found
end

max = 0
maxX = 1
(1..1000).each do |x| 
	numerator = Rational(1, x).round(num_len).numerator.to_s
	size = shortest_repeating(numerator)
	if (size > max)
		max = size
		maxX = x
	end
end

puts "Rational: 1/#{maxX}, Repeating length: #{max}"
