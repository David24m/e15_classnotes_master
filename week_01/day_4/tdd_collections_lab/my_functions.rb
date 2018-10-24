def get_first_key( hash )
  return hash.keys().first()
end


def find_item(array, item)
  truth_value = false
  for string in array do
    truth_value = true if string == item
  end
  return truth_value
end


def sum_array(array_1)
  sum = 0
  for index_value in array_1 do
    sum = sum + index_value
  end
  return sum
end

def add_array_lengths(array_1, array_2)
  # result = array_1.length + array_2.length
  return array_1.length + array_2.length
end
