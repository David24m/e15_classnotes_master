require_relative('person')

class Agent < Person

  def talk
    return "The name's #{@last_name}, #{@first_name} #{@last_name}"
  end

  def age(dob)
    fake_dob = dob - 10
    super(fake_dob)
  end
end
