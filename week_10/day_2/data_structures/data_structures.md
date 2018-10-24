# Data Structures

## Learning Objectives

* Know what a data structure is
* Understand how choosing different data structures can impact our code's performance
* Be able to describe common data structures: arrays, linked lists, hashes

## Introduction

When we save an object to a variable in our program, that object is stored in
our computer's memory. In the course so far we've not had to think about that
too much, but today we're going to take a slight detour into the world of
data structures. The study of data structures looks at the way we structure
the data we save in memory, and the effect that this has on how well our program
runs.

You might be thinking at this point that you don't really know what a data
structure is, but you do. You just don't realise that you do. In fact, over
the last few weeks you've all become experts in a few data structures without
even realising it.

> Ask students to name data structures they've used.

Arrays and hashes are both really common examples of data structures, which
programmers use every day. Other examples, which you might have heard of, include
queues, stacks, lists, trees, maps, sets and tables. They all solve very similar
problems in slightly different ways.

Today we're going to look at how effective these data structures are, as well
as considering a new type of structure: the linked list.

## What is a data structure?

So, without further ado, let's dive right in. What actually *is* a data structure?

It's actually really simple. A data structure is just a collection of data,
held together in a certain way. They allow the programer to think more about
the data they are storing, and less about its precise location in memory. Can
you imagine how annoying programming would be if you had to work out exactly
where in memory an object was stored before using it? (Hint: really annoying).

We can put it even more simply, though. Really a data structure is just an object
that allows us to put data in, and then later on to get data out. It's pretty
easy to see how arrays and hashes meet this criteria.

## Comparing Data Structures

The main way we will compare these data structures is using our old friend
time complexity from our lesson on algorithms. We will look at the time
complexity of a few important operations for each data structure, and in doing
this will hopefully be able to better choose between different data structures
for different use cases.

The operations we will look at are:
* retrieving an item (i.e. reading information back out of the collection)
* finding the size of the structure (i.e. how many items are in the collection)
* storing data (i.e. adding something to the collection)

There are other operations you might want to measure, such as making a copy of
the data structure, or searching to see if a value is included. We won't be
covering these today, but they are worth being aware of.

The best way to understand these different criteria are to look at an example.

## Arrays

> Quick reminder here. We are talking about arrays as a general concept, rather than a specific implementation. In particular, the information here might not pertain to Ruby's `Array` class.

We've seen arrays loads already. We've used them to death. They're about as
simple as a data structure can be. You chuck some objects into them, and they
sit there, in the order you chucked them in, until you want them back.

But what's going on under the hood when we do this? To simplify things, we'll
look at Java's arrays, i.e., the sort of array you'd get if you declared a variable
of type `String[]` or `int[]`. This is because in languages that support dynamically
sized arrays (like Ruby) some of the things we'll talk about work slightly differently.

When we create an array in Java, we do the following:

```java
int[] myNumbers = new int[5];
```

In particular here, we specify the size of the array at the time we create it.
Ever wondered why we have to do that?

> Give students some time to think about it.

Let's break it down:
* We tell Java to create a new array which will have 5 ints in it
* Int is a primitive data type Java also knows how big each of the ints are (32bit)
* So Java picks a spot in memory which is big enough to store 5 of those ints in a row

> For non primitive types, rather than the value,  Java will pass around a reference(pointer) to the object.


Now when we ask for item `0` in the array, Java knows the location where the array
starts and returns the int from this location.

Equally, if we ask for item `4`, Java knows the location where the array starts
and, vitally, how big each item of the array is, so it just adds that on to the
memory address and jumps directly to the item. This means it doesn't have to
go through the whole array one by one!

So how does this impact performance? Remember we're looking at getting data back,
finding the structure's size, and storing new data.

**Getting elements**: `O(1)` - we know the element's position in memory, so we just go
there and grab it. Simple.

**Length**: `O(1)` - the length is predetermined, so we can do this immediately.
Even in languages with dynamic arrays, the length is *normally* tracked in a
separate variable so that we don't have to recalculate it. (This is how Java's
`ArrayList` works).

**Insertion**: actually, in Java arrays, we can't insert new objects whenever
we please. We need to either replace something which is already there (which would be `O(1)`)
or use an `ArrayList`. Generally, in languages which allow for dynamically sized
arrays, appending a new item to the end of the array is `O(n)`. This is because
we first need to *find* the end of the array, before adding the new item.

> If students are curious about how `ArrayList` avoids the `O(n)` appending time complexity, it's actually pretty simple. The `ArrayList` implementation simply hides a standard Java array, and wraps some nice methods around it. Most importantly, it also resizes as necessary, which means that, when you hit the current size limit of the array and try to add a new item, it will extend the length of the current array, usually resulting in quite an expensive full copy of the entire structure.

## Linked Lists

Much like arrays, linked lists are ordered data structures. Unlike arrays (or
standard Java arrays, at least), however, they are intended to be dynamically
sized by default. This means that we never have to worry about resizing the list
when new data is added. However it also means we need to make some sacrifices
when it comes to accessing our data.

Remember when we discussed arrays, we said all their items were arranged in a
sequence in memory? Well LinkedLists scatter their objects around in memory. This
means that as well as knowing the value of an element at a given index, we also
have to maintain a pointer to the next item in the list.

This can be pretty hard to visualise just from talking, so let's try drawing it.

> Draw a linked list, with the pointer from the final node to its next element pointing to `null`.

Now, when we add an element, we can simply stick it on the front, and give it a
reference to the item that was previously at the front of the list. Easy!

> Draw a new item at the front of the list, pointing back to the old head.

Let's look at some implementations of a linked list, to see what's going on.

> Hand out Java or Swift linked list code. N.b. Swift code is a generic implementation of a basic linked list which might be a complete pain to explain fully. The Java implementation can only store `String`s which is obviously simpler to explain, but obviously isn't a full-featured implementation. It also exposes the `Node` implementation detail to users, which isn't ideal, but is fine for understanding.

> Point out important parts of the code. Specifically: how do we get the length of the list? How do we add new objects?

Okay, let's look at the performance of the key methods we've talked about.

**Getting elements**: `O(n)`. We need to loop through the list items to get to
a given index. Clearly the more elements we have, the more we have to loop through.

**Length**: `O(n)`. In its most basic form, we need to loop through all the items
and count them up. Technically this could be avoided by keeping track of the number
of items as we add them, which should reduce it to `O(1)`.

**Insertion**: `O(1)`. This is where linked lists really come into their own. We
can add new items at the beginning of the list, rather than the end, and thus
avoid the requirement to loop through to find the next empty space.

Although it's not one of our three measurements in this lesson, deleting items
is also easy, as we can simply point an element's `next` reference at the `next`
node of the one we want to delete.

> Why wouldn't adding items to the beginning make any difference to an array? A: we'd have to shift every item in memory which would end up being worse than just looping through to the end and adding it there.

## Hash Tables.

When we say "Hashes", we're really talking about a family of data structures.
Ruby's `Hash` is one example, as are Java's `HashMap`, Python's `Dictionary`,
Swift's `Dict`, and others. In the rest of this section we'll use the term
`Hash` to refer broadly to all of the above.

> Ask students to describe a `Hash`/`HashMap`.

We know `Hash` lets us take a value, and a key, and create a "map" between the
key and the values. (Hence the word "Map" in Java's `HashMap`). We also know
that they're unordered. That is, if we loop through a `Hash` using, for example,
Ruby's `each` method, we aren't guaranteed that elements will be in any specific
order.

### How do they work?

So how does it actually work? Well let's say we do the following in Ruby:

```ruby
phone_numbers = {}
phone_numbers[:pizza] = '07777777777'
puts phone_numbers[:pizza] # 07777777777
puts phone_numbers[:chippy] # nil
```

First things first: we create a new `Hash`. This works very similarly to creating
a new array, in that the language reserves some fixed space in memory, starting
at a known address. We don't really know how much space is reserved without looking
at the source code, so let's not worry too much about it.

So we've reserved our space. Next up we go to add an item to the `Hash`. In
Ruby we'll often use `Symbol`s for this (for performance reasons we won't go into),
though `String`s, `Int`s and even other `Hash`es (ugh) will also work.

At this point we've got:
* a `Symbol` we want to refer to the value by
* a load of memory addresses (or buckets) we know are reserved for us

#Hash Function
To complete our puzzle we need a way to get from the key to the memory location (eg index of the array). This is done using a hash function.  The hash function will take in as input the key value and return the index.

##Perfect hash function
A perfect hash function will map each key to a unique bucket. We get directly to the memory location.  This will give us constant time lookup.

##Collisions
As the number of buckets will be limited a perfect hash function is often not possible and different keys may go to the same bucket. This is called a collision.



#### Average Case

**Getting elements**: `O(1)`. You might think that the hash function would change
the performance characteristics of our get method, right? But it doesn't! Our
hash function is really just one operation per element we have to get, so it's just
constant.

**Length**: `O(1)`. This would take longer if it was recalculated every time we
needed to know the size (in which case it would clearly be `O(n)`). However, in
most `Hash` implementations this is tracked in a separate counter variable, which
is incremented and decremented as necessary.

**Insertion**: `O(1)`. This is true for exactly the same reason that getting
an element out is `O(1)`. We hash the key and are given a memory location in which
to store the value, which clearly doesn't depend on the number of key-value
pairs in the `Hash`.

#### Worst Case

The worst case is pretty different. It arises when we have to resort to
chaining, or some other method of avoiding clashes.

In these worst cases, we have the following measurements:

**Getting elements**: `O(n/m)`. We assume here that our `n` element `Hash` has `m`
available memory locations. If we have only one memory location, then clearly performance
is `O(n)` as we are retrieving the value from a linked list. And if we have two memory
locations, then we have, on average, two `O(n/2)` lists, and we will need to search through one
of them. For three memory locations, we get `O(n/3)`, and so on.

**Length**: `O(1)`. (Unchanged, as we can still track count separately).

**Insertion**: `O(1)`. Finding the memory location of the bucket is `O(1)` and so
is inserting an item into a linked list.


#Example of using hashes.

Let's store our friend's birthdays

```ruby
  birthdays = [
    ["sam", "1985/04/02"],
    ["alex", "1979/02/01"],
    ["sarah", "1991/07/27"],
  ]
```

How can we find Sarah's birthday?  What is the average time complexity of this?
O(n)

```ruby
  birthdays = [
    ["sam", "1985/04/02"],
    ["alex", "1979/02/01"],
    ["sarah", "1991/07/27"],
  ]
  for birthday in birthdays
    if( birthday[0] == "sarah")
      puts birthday[1]
    end
  end
```

How can we store them in a hash?

```ruby
  birthdays = {
    "sam" => "1985/04/02",
    "alex" => "1979/02/01",
    "sarah" => "1991/07/27",
  }

  puts birthdays["sam"]
```
What is the average time complexity of finding sarahs birthday now?
O(1)
