require('minitest/autorun')
require_relative('fizz_buzz.rb')

class FizzBuzzSpec < MiniTest::Test

  def test_3_returns_fizz
    assert_equal( "Fizz", fizz_buzz(3) )
  end

  def test_6_returns_fizz
    actual = fizz_buzz(6)
    assert_equal("Fizz", actual)
  end

  def test_5_returns_buzz
    assert_equal( "Buzz", fizz_buzz(5) )
  end

  def test_10_returns_buzz
    assert_equal("Buzz", fizz_buzz(10))
  end

  def test_2_returns_string_2
    assert_equal("2", fizz_buzz(2))
  end

  def test_15_returns_fizzbuzz
    assert_equal("FizzBuzz", fizz_buzz(15))
  end

  def test_1_returns_string_1
    assert_equal("1", fizz_buzz(1))
  end

end
