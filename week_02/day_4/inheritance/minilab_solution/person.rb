class Person

  attr_reader :first_name, :last_name

  def initialize(first_name, last_name, dob)
    @first_name = first_name
    @last_name = last_name
    @dob = dob
  end

  def talk()
    return "My name is #{@first_name} #{@last_name}"
  end

  def age(dob)
    age = 2017 - dob
    return "I am #{age} years old."
  end
end
