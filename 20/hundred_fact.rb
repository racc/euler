#!/usr/bin/ruby

puts (1..100).reduce(&:*).to_s.split(//).map(&:to_i).reduce(&:+)
