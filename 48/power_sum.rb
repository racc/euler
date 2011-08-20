#!/usr/bin/ruby

puts (1..1000).map { |x| x**x }.reduce(:+).to_s[-10..-1]
