require_relative('../db/sql_runner')

class Customer

  attr_accessor(:name)
  attr_reader(:id)

  def initialize(params)
    @id = params['id'].to_i() if params['id']
    @name = params['name']
  end

  def pizza_orders
    sql = '
      SELECT * FROM pizza_orders
      WHERE customer_id = $1;'
    order_hashes = SqlRunner.run(sql, [@id])

    pizza_orders = order_hashes.map do |order_hash|
      PizzaOrder.new(order_hash)
    end

    return pizza_orders
  end

  def Customer.all
    sql = 'SELECT * FROM customers;'
    results = SqlRunner.run(sql)
    # with map
    customers = results.map {|customer_hash| Customer.new(customer_hash)}
    # without map
    customers = []
    for result_hash in results do
      customer_object = Customer.new(result_hash)
      customers.push(customer_object)
    end

    return customers
  end

  def save
    sql = '
      INSERT INTO customers (
        name
      ) VALUES (
        $1
      )
      RETURNING *;'
    returned_data = SqlRunner.run(sql, [@name])

    returned_hash = returned_data[0]
    id = returned_hash['id']
    @id = id.to_i()
    # or all at once:
    # @id = returned_data[0]['id'].to_i()
    # or even more all at once:
    # @id = SqlRunner.run(sql, [@name])[0]['id'].to_i()
  end

  def Customer.delete_all
    sql = 'DELETE FROM customers;'
    SqlRunner.run(sql)
  end

end
