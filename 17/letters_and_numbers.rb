#!/usr/bin/ruby

UNITS = {thousands: 1000, hundreds: 100, tens: 10, ones: 1}
WORDS = {0 => "", 1 => "one", 2 => "two", 3 => "three", 4 => "four", 5 => "five", 6 => "six", 7 => "seven", 8 => "eight", 9 => "nine"}
TEENS = {0 => "ten", 1 => "eleven", 2 => "twelve", 3 => "thirteen", 4 => "fourteen", 5 => "fifteen", 6 => "sixteen", 7 => "seventeen", 8 => "eighteen", 9 => "nineteen"}
TENS = {0 => "", 2 => "twenty", 3 => "thirty", 4 => "forty", 5 => "fifty", 6 => "sixty", 7 => "seventy", 8 => "eighty", 9 => "ninety"}


def to_letters(x)
	base = {}
	UNITS.each do |unit, val|
		base[unit] = x / val
		x -= val * base[unit]
	end
	
	letters = ""
	letters << WORDS[base[:thousands]] + "thousand" unless base[:thousands] == 0
	letters << WORDS[base[:hundreds]] + "hundred" unless base[:hundreds] == 0
	letters << "and" if base[:hundreds] != 0 && (base[:tens] != 0 || base[:ones] != 0)
	
	case base[:tens]
		when 1
			letters << TEENS[base[:ones]]
		else
			letters << TENS[base[:tens]]
			letters << WORDS[base[:ones]] 
	end

	letters
end

puts (1..1000).map {|x| to_letters(x)}.join.length
