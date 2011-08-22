#!/usr/bin/ruby

words = File.new("words.txt").readline.gsub('"', "").split(',')
values = words.map do |word|
	word.bytes.map { |b| b - 64 }.reduce(:+)
end

require 'set'
# Maximum in the words is 192, so generate triangle numbers until 210
triangle_numbers = Set.new((1..20).map { |n| (n * (n + 1)) / 2 })
puts values.select { |v| triangle_numbers.include?(v) }.size
