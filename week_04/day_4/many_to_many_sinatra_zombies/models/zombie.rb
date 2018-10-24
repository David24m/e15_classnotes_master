require_relative( '../db/sql_runner' )

class Zombie

  attr_reader( :name, :type, :id )

  def initialize( options )
    @id = options['id'].to_i if options['id']
    @name = options['name']
    @type = options['type']
  end

  def save()
    sql = "INSERT INTO zombies 
    (
      name, 
      type
    ) 
    VALUES 
    (
      $1, $2
    ) 
    RETURNING id"
    values = [@name, @type]
    results = SqlRunner.run(sql, values)
    @id = results.first()['id'].to_i
  end

  def self.all()
    sql = "SELECT * FROM zombies"
    values = []
    results = SqlRunner.run( sql, values )
    return results.map { |hash| Zombie.new( hash ) }
  end

  def self.find( id )
    sql = "SELECT * FROM zombies 
    WHERE id = $1"
    values = [id]
    results = SqlRunner.run( sql, values )
    return Zombie.new( results.first )
  end

  def self.delete_all
    sql = "DELETE FROM zombies"
    values = []
    SqlRunner.run( sql, values )
  end

end
