#!/usr/bin/ruby

require File.dirname(File.expand_path(__FILE__)) + '/../util/ruby/primes'

def bit_locations(selector, on = true)
	locs = []
	pos = 0
	selector.each do |d|
		if (on && d == '1')
			locs << pos
		elsif (!on && d == '0')
			locs << pos
		end
		pos += 1
	end
	locs
end

def ons_equal?(p, selector)
	locs = bit_locations(selector)
	map = locs.map { |x| p[x] }                                                
	map.all? { |x| x == p[locs[0]] }
end

def off_values(p, selector)
	bit_locations(selector, false).map { |x| p[x] }
end
		
limit = 1000000
primes = Primes::sieve(limit).map { |x| x.to_s.chars.to_a }.group_by { |x| x.size }

primes.each do |size, subset|
	series = (1..(2**size - 1)).map do |n| 
		selector = ("%0#{size}b" % n).chars
		subset.select { |p| ons_equal?(p, selector) }.group_by { |p| off_values(p, selector) }.select {|k, v| v.size == 8 }.values.flatten(1).map { |v| v.join.to_i }
	end.reject { |s| s.empty? }.flatten
	
	p series.first if (!series.empty?)
end
