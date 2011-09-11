#!/usr/bin/ruby
require 'ruby-poker'

hands = IO.readlines(File.new("poker.txt")).map do |line|
	stripped = line.strip
	[stripped[0..13], stripped[15..30]].map { |hand| PokerHand.new(hand) }
end

p hands.select { |x| x[0] > x[1] }.size
