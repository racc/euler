#!/usr/bin/ruby

require File.dirname(File.expand_path(__FILE__)) + '/../util/ruby/primes'
require 'set'

LIMIT = 50_000_000
PRIMES = Primes::sieve((LIMIT ** (0.5)).to_i)

def prime_power(power)
	PRIMES.map { |x| x ** power }.select { |x| x < LIMIT }
end

prime_squares = prime_power(2)
prime_cubes = prime_power(3)
prime_fourth = prime_power(4)
numbers = Set.new

prime_squares.each do |s| 
	prime_cubes.each do |c|
		prime_fourth.each do |f|
			sum = s + c + f
			numbers << sum if sum < LIMIT
		end
	end
end

p numbers.size

