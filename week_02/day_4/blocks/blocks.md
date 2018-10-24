# Blocks

## Learning Objectives

- Understand what blocks are
- Write our own blocks
- Get to know Ruby Enumerable Iterators

> ## Duration
> 2 hours

So we need to talk about blocks.

Blocks are really weird and are almost the only thing in Ruby which are NOT objects. By that I mean they CANNOT be assigned to a variable. They take a bit of getting used to, but they are super powerful once you get your head around it.

Sometimes, we write bits of code that are very very similar but we have no way to break it down more sensibly. Let's have a look at an example.

```bash
#terminal

touch app.rb app_spec.rb
```

We write a test for a function to add 1 to each item in an array of integers: 

```ruby
# app_spec.rb

require('minitest/autorun')
require_relative('app')

class TestApp < Minitest::Test
  def test_adds_one_to_each_item
    assert_equal([2,3,4], add_one([1,2,3]))
  end
end
```

And then write the function itself:

```ruby
# app.rb
def add_one(items)
  result = []
  for item in items
    result << item + 1
  end
  return result
end
```

That's great. Lets test and write another function to multiply the items by 2:

```ruby
# app_spec.rb

def test_multiplies_each_item_by_two
  assert_equal([2,4,6], multiply_by_two([1,2,3]))
end
```

```ruby
# app.rb

def multiply_by_two(items)
  result = []
  for item in items
    result << item * 2
  end
  return result
end
```

We need to copy the entire code to achieve this. The only difference between these two functions is the operation we are applying to each item.

## Enter Blocks

Blocks are very odd but very useful constructs in Ruby. They are NOT objects. They are one of the only things which are not. This means they CANNOT be assigned to a variable. Blocks allow us to pass some code into a method, to be executed by the method.

There are similar things in other languages, such as callbacks in Javascript and Funcs in C#.

We use them with the {} syntax. We have seen this before in passing, but now we are going to have a look at what is actually going on.

Lets write a test for a function that will simply run whatever code we pass it in a block.

```ruby
# app_spec.rb

def test_the_whatever_function
  assert_equal(2, run_whatever_code_i_pass_you { 1 + 1 })
end
```

And write the function itself:

```ruby
# app.rb

def run_whatever_code_i_pass_you
  return yield
end
```

Woah, what's that `yield` keyword?

`yield` is the keyword which executes the passed-in block of code inside a method. It is fantastically powerful.

We can even pass parameters to our block from inside our method by giving arguments to our yield call! Say we have a string inside our method, and we want to pass it to our block:

```ruby
# app_spec.rb
def test_doing_something_to_string
  assert_equal("Hello Alan", do_something_to_a_string { |name| "hello "+ name })
end
```

```ruby
# app.rb

def do_something_to_a_string
  name = "Alan"
  yield(name)
end
```

## The Power of Blocks

Now that we know how blocks and `yield` works, wouldn't it be nice if we could now get rid of our `add_one` and `multiply_by_two` functions and merge them into one function?

Let's amend our tests to both point at the same function. Since our original functions only had one different line between them, we can just pass the bulk of that line in as a block.

We are actually doing a very common array operation, called a map. A map, when performed on an array, returns a new array of the same length, with some operation performed on each item in the array.

```ruby
# app_spec.rb

def test_map_multiply_each_item_by_two
  assert_equal([2,4,6], map([1,2,3]){ |item| item * 2 })
end

def test_map_add_one_to_each_item
  assert_equal([2,3,4], map([1,2,3]){ |item| item + 1 })
end
```

In order for that block to be executed, we have to `yield` inside the method:

```ruby
# app.rb

def map(items)
  result = []
  for item in items
    result << yield(item)
  end
  return result
end
```

Wicked.

## Array Methods and Blocks

You may have encountered map before. Ruby already has a built-in `.map` method on arrays:

```ruby
# app_spec.rb

def test_array_map_add_one
  array = [1,2,3]
  result = test_array.map { |item| item + 1}
  assert_equal([2,3,4], result)
end
```

This is _exactly_ the same functionality, so we don't have to "reinvent the wheel" every time we want to map over an array; we can use Ruby's built-in `.map` method.

By convention, if our block contains more than one line of code, we wrap it in a `do...end` rather than `{...}`:

```ruby
# app.rb

def test_array_map_add_one_with_do
  array = [1,2,3]
  result = array.map do |item|
    item + 1
  end
  assert_equal([2,3,4], result)
end
```

# Enumeration

You may have already seen Ruby's `each` array method. While many languages (like Java) only have `for` loops, some languages like Ruby (and JavaScript) "dress up" a `for` loop in an `each` method.

Let's write a test to see what it does:

```ruby
# app_spec.rb

def test_each
  array = [1,2,3]
  result = []
  array.each do |item|
    result << item
  end
  assert_equal([1,2,3], result)
end
```

[Ruby's Array docs](https://ruby-doc.org/core-2.4.1/Array.html) have an example of using an `.each` method on an array.

...but if you read the docs, you won't see any mention of a `.map` function. So where's it coming from?

By scrolling down the page, you will see that Ruby Arrays have an "Included Module" called [Enumerable](https://ruby-doc.org/core-2.4.1/Enumerable.html). This is a collection of functionality that is available to pretty much all of the collection classes in Ruby. So our arrays can also use all of these.

Some are more useful than others, and these are probably the ones you'll use most often in Ruby:

- `each_with_index` is very similar to `each` but passes the current item and whatever position in the array it was located in
- `select` (a.k.a `find_all`) returns a new object (e.g. array) filled with only those original items where the block you gave it returned true
- `find` finds the first object that meets the condition in the block
- `map` (a.k.a `collect`) returns a new array filled with whatever gets returned by the block each time it runs.
- `inject` (a.k.a `reduce`) combines all the elements of a collection into one single object, and you define how the elements are combined (e.g. by adding them together)

## Enumerators in action

> [Task:] Hand out pet shop starting point code and quickly talk through it

Let's say we have a pet shop:

```ruby
percy = Pet.new("Sir Percy", :cat, "British Shorthair", 500)
bagdemagus = Pet.new("King Bagdemagus", :cat, "British Shorthair", 500)
lancelot = Pet.new("Sir Lancelot", :dog, "Pomsky", 1000)
arthur = Pet.new("Arthur", :dog, "Husky", 900)
tristan = Pet.new("Tristan", :dog, "Basset Hound", 800)
merlin = Pet.new( "Merlin", :cat, "Egyptian Mau", 1500)

pets = [ percy, bagdemagus, lancelot, arthur, tristan, merlin ]

@pet_shop = PetShop.new(pets)
```


See if you can use the common Enumerable Iterators to get the tests to pass: 

- get the type of the pet called "Merlin"
- get the number of pets costing at least 1000
- get the names of all the dogs

### Solution:

```ruby
def pet_type(pet_name)
  pet_found = @pets.find { |pet| pet.name == pet_name}
  return pet_found.type  
end

def get_number_of_pets_costing_at_least(amount)
  pets_found = @pets.select { |pet| pet.price >= amount }
  pets_found.count
end

def get_names_of_all_pets_of_type(pet_type)
  pets_of_type = @pets.select { |pet| pet.type == pet_type }
  pets_of_type.map { |pet| pet.name}
end
```
