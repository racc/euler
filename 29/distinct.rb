#!/usr/bin/ruby

require 'set'

distinct = Set.new

(2..100).each do |a|
	(2..100).each do |b|
		distinct << a ** b
	end
end

puts distinct.size
