require_relative('../db/sql_runner')

class PizzaOrder

  attr_accessor(:topping, :quantity)
  attr_reader(:id, :customer_id)

  def initialize( order_details )

    @customer_id = order_details['customer_id']

    @topping = order_details['topping']
    @quantity = order_details['quantity'].to_i()
    @id = order_details['id'].to_i() if order_details['id']
  end

  def customer
    sql = '
      SELECT * FROM customers
      WHERE id = $1;'
    results_array = SqlRunner.run(sql, [@customer_id])

    customer_hash = results_array[0]
    customer_object = Customer.new(customer_hash)
    return customer_object
  end

  def save()
    sql = '
      INSERT INTO pizza_orders (
        customer_id,
        topping,
        quantity
      ) VALUES (
        $1, $2, $3
      )
      RETURNING id;'
      # 'RETURNING id' or 'RETURNING *' will achieve the same thing for us in this situation
    values = [@customer_id, @topping, @quantity]
    results_array = SqlRunner.run(sql, values)

    saved_order_hash = results_array[0]
    @id = saved_order_hash['id'].to_i()
  end

  def update()
    db = PG.connect( { dbname: 'pizza_shop', host: 'localhost' } )
    sql = '
      UPDATE pizza_orders SET (
        first_name,
        last_name,
        topping,
        quantity
      ) = (
        $1, $2, $3, $4
      )
      WHERE id = $5;'
    values = [@first_name, @last_name, @topping, @quantity, @id]
    SqlRunner.run(sql, values)
  end

  def delete()
    sql = 'DELETE FROM pizza_orders WHERE id = $1;'
    SqlRunner.run(sql, [@id])
  end

  def PizzaOrder.delete_all()
    sql = 'DELETE FROM pizza_orders;'
    SqlRunner.run(sql)
  end

  def PizzaOrder.all()
    sql = 'SELECT * FROM pizza_orders;'
    orders = SqlRunner.run(sql)
    return orders.map { |order_hash| PizzaOrder.new( order_hash ) }
  end

end
