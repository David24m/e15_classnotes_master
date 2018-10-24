require_relative('./craigytest.rb')
require_relative('./functions.rb')

def test_add_5_plus_1
  result = add(5, 1)
  assert_equal(6, result)
end
test_add_5_plus_1()

# def test_should_fail
#   assert_equal(1, 2)
# end
# test_should_fail()

def test_reverse_a_string
  assert_equal("giarC", reverse_it("Craig"))
end
test_reverse_a_string()

def test_count_eggs
  # we have [1, 2, 3, 4, 5, 4, 3, 2, 1]
  # we want 25
  eggs = [1, 2, 3, 4, 5, 4, 3, 2, 1]

  result = count_eggs( eggs )

  assert_equal(25, result)

end
test_count_eggs()
