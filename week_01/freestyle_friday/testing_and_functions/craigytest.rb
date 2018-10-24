def assert_equal(expected, actual)
  if expected == actual
    puts "✅ - #{actual} is the same as #{expected}"
  else
    puts "🚫 - I expected #{expected}, but I got #{actual}"
  end
end
