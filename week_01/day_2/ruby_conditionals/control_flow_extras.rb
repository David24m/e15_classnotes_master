# Guard Statements

# Traditional If statement
# if (score >= 6)
#   puts "pass"
# else
#   puts "fail"
# end

# Same thing using a Guard
score = 6

result = "fail"
result = "pass" if (score >= 6)

puts result


# -----------------------------------------------------

# Ternary Statements

# Traditional If statement
# if (score >= 6)
#   puts "pass"
# else
#   puts "fail"
# end

# Same thing using a Ternary
score = 6

result = (score >= 6) ? "pass" : "fail"
# General make-up of a Ternary
# action (condition) ? <condition_true> : <condition_false>

puts result

# -----------------------------------------------------

#    && and ||
# (AND) and (OR)

# AND operator => &&
craig_hungry = true
craig_tired = true

puts "Craig is hangry!" if (craig_hungry && craig_tired)

# OR operator => ||
craig_tired = false

puts "Craig is grumpy!" if (craig_tired || craig_hungry)
