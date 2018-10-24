require('minitest/autorun')
require_relative('../wand.rb')

class WandTest < MiniTest::Test

  def setup
    @elder_wand = Wand.new('holly', 'phoenix feather')
  end

  def test_wand_has_wood
    assert_equal('holly', @elder_wand.wood )
  end

  def test_wand_has_core
    assert_equal('phoenix feather', @elder_wand.core )
  end


end
