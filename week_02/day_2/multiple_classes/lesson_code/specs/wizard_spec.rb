require('minitest/autorun')
require_relative('../wizard.rb')
require_relative('../wand.rb')

class WizardTest < MiniTest::Test

  def setup
    @broken_wand = Wand.new('oak', 'unicorn hair')
    @ron = Wizard.new('Ron Weasley', @broken_wand)

    @elder_wand = Wand.new('holly', 'phoenix feather')
    @harry = Wizard.new('Harry Potter', @elder_wand)
  end

  def test_wizard_has_name
    assert_equal( 'Ron Weasley', @ron.name )
  end

  def test_can_cast_spell
    result = @ron.cast_spell('stupify')
    assert_equal('stupify', result)
  end

  def test_cast_strong_spell
    actual = @harry.cast_spell('expecto patronum')
    assert_equal('EXPECTO PATRONUM', actual)
  end



end
