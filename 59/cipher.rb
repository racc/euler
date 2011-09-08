#!/usr/bin/ruby

def xor_arrays(arr1, arr2)
	arr1.zip(arr2).map { |x| (x[0] ^ x[1]).chr }
end

def xor_encrypt(str, key)
	str.each_slice(key.size).map do |slice| 
		xor_arrays(slice, key.bytes)
	end.flatten.join
end

def bins(arr, n)
	(0..n-1).map do |bin|
		bin.step(arr.size, n).map { |x| arr[x] }	
	end
end

def highest_freq(arr)
	freq = arr.inject(Hash.new(0)) { |h,v| h[v] += 1; h}
	arr.sort_by { |v| freq[v] }.last
end

f = File.new("cipher1.txt")
chars = f.readlines[0].strip.split(",").map {|x| x.to_i }
space = " ".ord
key = bins(chars, 3).map { |x| (highest_freq(x).to_i ^ space).chr }.join

decrypted = xor_encrypt(chars, key)
p decrypted
p decrypted.bytes.map { |x| x.ord }.reduce(:+)
