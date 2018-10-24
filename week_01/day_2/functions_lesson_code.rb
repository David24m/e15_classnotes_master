def greet(person, time_of_day)
  greeting = "Good #{time_of_day}, #{person}"
  return greeting
end

puts greet("Craig", "morning")

# This won't work
# - the greeting variable only exists in the scope of the 'greet' function

# def another_greeting()
#   return greeting + " friend"
# end
# another_greeting()

def add(first_number, second_number)
  return first_number + second_number
end

puts add(50, 35)

def population_density(population, area)
  density = population / area
  return density
end

puts population_density(5_373_000, 77_933)

# Using quotes inside strings extra examples:

# If using ' in the string, you can wrap the string in "
"It's sunny outside"
# If using " in the string, you can wrap the string in '
'They told me "Nope"'

# If using both in the string, you can "escape" the characters to make Ruby
# treat them as literal characters rather than quote-marks that would end the
# string earlier than you intend
"They told me \"Nope, it's sunny outside!\""
'They told me "Nope, it\'s sunny outside"'

# Remember that you *must* use double-quotes ("") if you're using string
# interpolation to inject the value of variables into the string using #{}
works = "is string interpolation"
puts "This #{works}"

doesnt_work = "is string interpolation"
puts 'This #{doesnt_work}'

