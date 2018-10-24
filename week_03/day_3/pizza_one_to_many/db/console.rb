require("pry")
require_relative("../models/pizza_order")
require_relative("../models/customer")

PizzaOrder.delete_all()
Customer.delete_all()

customer1 = Customer.new({'name' => 'Craig Morton'})
customer2 = Customer.new({'name' => 'Dave'})
customer1.save()
customer2.save()

order1 = PizzaOrder.new({
  "customer_id" => customer1.id,
  "topping" => "Mushroom",
  "quantity" => "1"
})
order1.save()

order2 = PizzaOrder.new({
  "customer_id" => customer1.id,
  "topping" => "Veggie",
  "quantity" => "3"
})
order2.save()

order3 = PizzaOrder.new({
  "customer_id" => customer2.id,
  "topping" => "Pepperoni",
  "quantity" => "2"
})
order3.save()

binding.pry
nil
