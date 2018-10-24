puts "What animal are you?"
name = gets.chomp().downcase()

if (name == "jaguar")
  puts "Woah, that's pretty cool."
elsif (name == "dog")
  puts "Yeah, guess that's alright..."
elsif (name == "cat")
  puts "Yeah, not bad"
elsif (name == "fish")
  puts "Blub blub blub, that was me, doing an impression of you..."
else
  puts "Meh, that's pretty lame, be a Jaguar."
end
