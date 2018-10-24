puts "What score did you get?"
score = gets.chomp().to_i()

case (score)
  when 10
    puts "Genius!"
  when 8..9
    puts "Yeah, nice."
  when 5..7
    puts "Pass."
  when 4
    puts "YOU WILL NOW RESIT!"
  else
    puts "Fail!"
end
