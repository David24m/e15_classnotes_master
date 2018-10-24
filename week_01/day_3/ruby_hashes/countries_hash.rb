countries = {
  :uk => {
    :capital => "London",
    :population => 1_000_000
  },
  :germany => {
    :capital => "Berlin",
    :population => 5_000_000
  }
}

# Getting the capital of the UK:
puts countries[:uk][:capital]

# Getting Germany's population.
puts countries[:germany][:population]
