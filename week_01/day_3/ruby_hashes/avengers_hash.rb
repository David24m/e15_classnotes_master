avengers = {
  hulk: {
    real_name: "Bruce Banner",
    attack_moves: {
      smash: 1000,
      roll: 500
    }
  },
  iron_man: {
    real_name: "Tony Stark",
    attack_moves: {
      punch: 10,
      kick: 100,
      witty_sarcasm: 1_000_000
    }
  }
}

# Getting the Hulk's real name:
puts avengers[:hulk][:real_name]

# Getting the power of the Hulk's Smash move:
puts avengers[:hulk][:attack_moves][:smash]

# Adding a Laser move to Iron Man's move list:
avengers[:iron_man][:attack_moves][:laser] = 1000
