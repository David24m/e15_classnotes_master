def add(number_1, number_2)
  return number_1 + number_2
end

def reverse_it(string)
  return string.reverse()
end

def count_eggs(eggs_array)
  total = 0

  for egg_count in eggs_array do
    total = (total + egg_count)
  end

  return total
end
