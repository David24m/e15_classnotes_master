class Wand

  attr_reader(:wood, :core)

  def initialize(wood, core)
    @wood = wood
    @core = core
  end

  def cast(spell)
    if @wood == 'holly' && @core == 'phoenix feather'
      return spell.upcase()
    else
      return spell
    end
  end

end
