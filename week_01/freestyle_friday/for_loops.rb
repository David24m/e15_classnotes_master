letters = ['a', 'b', 'c', 'd', 'e']
string = ''

# This:
#####
counter = 0
while counter < letters.length() do
  # puts "looping. index: #{counter} - letter: #{letter}"
  letter = letters[counter]

  string += letter

  counter += 1
end
#####

# Does the same as this:
#####
for letter in letters do
  string += letter
end
#####

puts string
