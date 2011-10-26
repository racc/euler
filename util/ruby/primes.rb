module Primes
	def self.sieve(x)
		primes = (0..x).to_a
		limit = (x ** (0.5)).to_i
	
		(2..limit).each do |s|
			(2 * s).step(x, s).each { |t| primes[t] = nil }
		end
		primes[0..1] = nil
		primes.compact!
	end
end
