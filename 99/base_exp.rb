#!/usr/bin/ruby

lines = IO.readlines(File.new("base_exp.txt"))
logs = lines.map do |x| 
	split = x.strip.split(",").map { |n| n.to_i }
	Math.log(split[0]) * split[1]
end
p logs.index(logs.max) + 1
