# Enumeration

## Intro

```bash
touch enumeration.js
subl .
```

Looping through arrays is something we find ourselves needing to do quite a lot.

We can do it like this:

```js
var numbers = [1, 2, 3, 4, 5];
for (var number of numbers) {
  console.log('the number is:', number);
}
```

In ruby, we had methods on the `Array` class like `.each` and `.map`. They're
methods which handle looping through the array for us.

```ruby
# irb
numbers = [1, 2, 3, 4, 5]
numbers.each { |number| puts number }
```

We pass these methods a 'block' `{ |number| puts number }`, and the `.each` 
method passes each array element in to our 'block', so we can do whatever we 
need to with them in our block.

Javascript also allows us to do this using methods that take callback functions.
It's works similarly to how the enumerable / block methods work in Ruby, but in 
JS we pass a function instead of a 'block'.

```js
var numbers = [1, 2, 3, 4, 5];
numbers.forEach(function (number) {
    console.log('the number is:', number);
  });
```

`forEach` is a method defined on Arrays in JS. It lives on `Array.prototype`

It takes the function that we pass it, and calls it for each element in the 
array. It handles looping through the array for us, and passes our callback the 
current item in the array as an argument.

`forEach` is considered a 'higher order function' because it take a function as 
an argument.

We can pull out the function to a variable and pass that in as an argument to 
`forEach` if we want to

```js
var numbers = [1, 2, 3, 4, 5];
var printNumber = function (number) {
  console.log('the number is:', number);
}
numbers.forEach(printNumber);
```

This is doing the exact same thing as the previous example in the exact same 
way. You will often see an anonymous function being defined and passed straight 
in to a higher order function's arguments. If extracting it to a variable before 
passing it in makes it more clear what's going on, it's totally fine as well.

## Writing our own forEach
> Let class do as exercise if going well.

To really understand what a forEach is doing, we can write our own. Ours will 
work a little differently because it won't be a method on `Array`.

Let's make our version take an array as it's first argument and the callback 
function to invoke for each element as the second argument.

```js
var ourForEach = function (array, callbackForItem) {
  for (var item of array) {
    callbackForItem(item);
  }
};

var numbers = [1, 2, 3, 4, 5];

ourForEach(numbers, function (number) {
  console.log('the number is:', number);
});
```


## Enumerable methods

Using enumerable methods rather than looping is becoming more and more popular 
in the Javascript community.

You can read about the different enumerable methods that are available on the 
[Array documentation](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array)

You might want to take a look at these methods in particular:

`.forEach`
`.map`
`.filter`
`.find`
`.some`
`.every`
`.reduce`

We're going to practice using these methods to solve problems by adding more 
functionality to our Bank.
