def add(items)
  result = []
  for item in items
    result << item + 1
  end
  return result
end

def multiply(items)
  result = []
  for item in items
    result << item * 2
  end
  return result
end

def map(items)
  result = []
  for item in items
    result << yield(item)
  end
  return result
end

def run_whatever_code_i_pass_you
  yield
end

def do_something_to_a_string
  name = "Valerie"
  yield(name)
end