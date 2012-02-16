#!/usr/bin/ruby
SUB_ARR = [
  ["DCCCC", "MC"],
  ["CCCC", "CD"],
  ["LXXXX", "XC"],
  ["XXXX", "XL"],
  ["VIIII", "IX"],
  ["IIII", "IV"],
]

def refine_roman(roman)
  refined_roman = roman
  SUB_ARR.each do |x|
    refined_roman = refined_roman.gsub(x[0], x[1]) if (refined_roman.include?(x[0]))
  end
  refined_roman 
end

def total_length(arr_of_strings)
  arr_of_strings.inject(0) { |sum, x| sum + x.length }
end

numerals = IO.readlines('roman.txt').map { |x| x.chomp }
initial_len = total_length(numerals)
reduced_nums = numerals.map { |x| refine_roman(x) }
reduced_len = total_length(reduced_nums)
p initial_len - reduced_len
