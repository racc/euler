#!/usr/bin/ruby

a = 0
(1..999).each { |x| a += x if (x % 3 == 0) || (x % 5 == 0) } 
puts a
