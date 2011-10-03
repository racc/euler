#!/usr/bin/ruby

require 'set'

def triangle(n)
	(n * (n + 1)) / 2
end

def square(n)
	n ** 2
end

def pentagonal(n)
	(n * (3 * n - 1)) / 2
end

def hexagonal(n)
	n * (2 * n -1)
end

def heptagonal(n)
  (n * (5 * n - 3)) / 2
end

def octagonal(n)
	n * (3 * n - 2)
end

def all_in_range(n, fn, range = (1000..9999), match = [])
	x = send(fn, n)
	if x < range.begin
		all_in_range(n + 1, fn, range, match)
	elsif x > range.end
		match
	else
		match << x
		all_in_range(n + 1, fn, range, match)
	end
end

def are_cyclic?(a, b)
	a.to_s[0..1] == b.to_s[2..3]
end	

def find_cyclic(nums, cyclic_set, indices)
	if indices.empty?
		if are_cyclic?(cyclic_set.first, cyclic_set.last)
			return cyclic_set
		else
			return nil
		end
	else
		indices.each do |i|
			to_append = nums[i].find_all { |x| are_cyclic?(x, cyclic_set.last) }
			to_prepend = nums[i].find_all { |x| are_cyclic?(cyclic_set.first, x) }

			map_append = to_append.map do |n|
				find_cyclic(nums, cyclic_set + [n], indices ^ [i])	
			end
		
			map_prepend =	to_prepend.map do |n|
				find_cyclic(nums, [n] + cyclic_set, indices ^ [i])	
			end
		
			return (map_append + map_prepend).find {|x| !x.nil? }
		end
	end
end

nums = [:triangle, :square, :pentagonal, :hexagonal, :heptagonal, :octagonal].map do |f|
	all_in_range(1, f)
end

indices = Set.new((0..nums.size - 1).to_a)
indices.each do |i|
	start = nums[i] 
	start.each do |t| 
		found = find_cyclic(nums, [t], indices ^ [i])
		if !found.nil?
			p found.reduce(:+)
			exit
		end
	end
end
