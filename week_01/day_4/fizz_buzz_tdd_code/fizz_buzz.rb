
def fizz_buzz(number)
  divides_by_5 = number % 5 == 0
  divides_by_3 = number % 3 == 0

  if divides_by_3 && divides_by_5
    return "FizzBuzz"
  end

  return "Buzz" if divides_by_5
  return "Fizz" if divides_by_3
  return number.to_s()
end
