# Introduction to C#

This is a short introduction to C#, best delivered soon after the Java section of the course.

## Overview

### What is C#?

C# is best thought of as a cross between C++ and Java, with a bunch of extra features added over the years.  Unlike
C++, and similar to Java, C# has automatic memory management and garbage collection.  It compiles not to native
machine code, but to a virtual machine code which targets the CLR (Common Language Runtime).  The CLR just-in-time
compiles the virtual machine code into native machine code when it is running.

C# is just one of several languages which share the CLR, and therefore have access to the same runtime libraries.
The CLR and shared libraries is known as the .NET Framework.

Others include:

 - F#, a functional programming language based on OCaml
 - VB.NET, a really ugly language based on Visual Basic, and ultimately on BASIC
 - Managed C++, basically C++, but on the CLR
 - Iron Python, based on Python
 - MSIL (Microsoft Intermediate Language), basically the assembly language for CLR instructions

It is really straightforward for software written in all these languages to interoperate.

### Development environments

If you are using C# in industry you will almost certainly be using it with Visual Studio, a very powerful commercial 
IDE.  There is also a community edition of this IDE (including one for OSX), so that you can use it for free at home.

.NET is primarily for Windows, but there is a slimmed-down version called .NET Core which is available for other
platforms.

You can get the .NET Core SDK (Software Development Kit) [here](https://www.microsoft.com/net/core).  This will let you
start writing C# code with just a couple of command line tools and an editor, although it is recommended that you
you use a decent IDE.


## A Whirlwind Tour

### Hello, world!

Let's start with the canonical example.

> Create a new console application in Visual Studio.  It'll automatically create the following code
> in Program.cs

```cs
using System;

namespace IntroToCSharp
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
        }
    }
}
```

Hopefully you can see it's pretty similar to Java.

### Conventions

> Call attention to the `Main` and `WriteLine` identifiers.

Conventionally, C# uses PascalCase for classes and methods, and initialCase for fields.  The curly bracket for the
start of a code block goes on a new line, rather than on the end of the preceeding line like in Java.

### Namespaces

> Point out the `namespace` and `using` keywords.

Classes etc in C# go into _namespaces_ rather than packages like in Java.  They're pretty much the same concept, just
with a different name.  You need to wrap your code in a `namespace` block, like so:

```cs
namespace NameSpaceName
{
  //...
}
```

To have access to a namespace within another file, you use the `using` statement, kind of like Java's `import`
statement.  Note however that unlike the latter, it brings in the whole namespace, rather than specific classes within
it.

### Primitives

Primitives are not a separate concept in C#.  I.e., there is no real difference between `int` and `Integer`. 
This means there is no restriction on the types that can appear in generics - in Java, you can't have
an `ArrayList<int>` for example.

### `var` keyword

C# has a special keyword, `var`, which helps cut down typing.  When you're declaring a variable, if it is obvious to
the compiler what the type is going to be, you can use the `var` keyword instead.

```cs
// it's obvious this is going to be a string
var str = "hello";
// it's not obvious what this is going to be, so you can't do this
var someVar;
// it really saves typing for something like this:
Dictionary<string, List<string>> foo = new Dictionary<string, List<string>>();
// becomes:
var foo = new Dictionary<string, List<string>>();
```


### Properties

Unlike Java, C# has properties.

> Add a new class, `Student`

```cs
// Student.cs
class Student
{
  private string name;
  public int age;

  public string Name
  {
    get
    {
      return name;
    }
    set
    {
      name = value;
    }
  }

  public int Age
  {
    get
    {
      return age;
    }
    set
    {
      age = value;
    }
  }
}
```

This defines getter and setter methods for the "backing field" `name`,
but with the advantage that the property can be assigned to and read
from like a field:

```cs
// Program.cs
static void Main(string[] args)
{
    var student = new Student();
    student.Name = "John";
    student.Age = 23;

    Console.WriteLine($"{student.Name} is {student.Age}");
}
```

Since the pattern above is so common, you can do the following:

> Delete the backing fields and refactor the properties.

```cs
class Student
{
  public string Name
  {
    get;
    set;
  }

  public string Age
  {
    get;
    set;
  }
}
```

This will automatically create a backing field and simple getters and setters for it.

What's the point - why not just use a field?  Well, you can't have fields on interfaces, only methods (and properties,
a special kind of method).  Also, later on you could decide to add logging or error checking or something to the
property getter or setter, and if it's already a property rather than a field, it's not a breaking change.


### Delegates

C# allows you to assign a function to a variable to call later, using a feature called "delegates".

Let's add a delegate property to the `Student` class so that we can be 
informed if the age is updated.

> Highlight that we need to refactor the `age` property back to not
> using an automatic backing property, and that this is only possible
> because we chose not to make it a field.

```cs
// define the delegate
delegate void AgeUpdatedDelegate(Student student);

class Student 
{
  private int age;

  public string Name
  {
    get;
    set;
  }

  // add a property for the delegate
  public AgeUpdatedDelegate AgeUpdated
  {
    get;
    set;
  }

  public int Age
  {
    get
    {
      return age;
    }
    set
    {
      // save the old value, because we want to call the delegate
      // once it has already been updated
      var previousValue = age;
      age = value;

      // if the new value is different from the old one,
      // and the delegate isn't null, call it
      if (previousValue != value && AgeUpdated != null) {
        AgeUpdated(this);
      }
    }
  }
}
```

And this is how we can use it:

```cs
class Program
{
  static void Main(string[] args)
  {
    var john = new Student();
    john.Name = "John";
    john.Age = 23;
    Console.WriteLine($"{john.Name} is {john.Age}");

    john.AgeUpdated = student_AgeUpdated;
    john.Age = 24;
  }

  static void student_AgeUpdated(Student student)
  {
    Console.WriteLine($"{student.Name} is now {student.Age}");
  }
}
```


### Events

The above - registering a delegate to call when something happens - is a
really common pattern.  If we use an `event`, we can subscribe to it
with multiple methods.

> Replace the `AgeUpdated` property with an event.

```cs
// Student.cs
class Student 
{
  /// ... snip ...

  public event AgeUpdatedDelegate AgeUpdated;
}
```

> Update Program.cs

```cs
// Program.cs
class Program
{
  static void Main(string[] args)
  {
    var john = new Student();
    john.Name = "John";
    john.Age = 23;
    Console.WriteLine($"{john.Name} is {john.Age}");

    // change the = to a +=
    john.AgeUpdated += student_AgeUpdated;
    john.Age = 24;
  }
}
```

We could add another subscriber if we wanted.

```cs
class Program
{
  static void Main(string[] args)
  {
    var john = new Student();
    john.Name = "John";
    john.Age = 23;
    Console.WriteLine($"{john.Name}, {john.Age} years old");

    john.AgeUpdated += student_AgeUpdated;
    // add this line
    john.AgeUpdated += HappyBirthday;
    john.Age = 24;
  }

  static void HappyBirthday(Student student)
  {
    Console.WriteLine($"Happy birthday {student.Name}");
  }
}
```


### Extension methods

C# allows you to define methods for a class outside the class itself.  Let's
say the `Student` class was supplied by an external library we had no
control over, and we wanted to add a method to it.  C# lets us do that.

> Create a `StudentExtensions` class

```cs
// StudentExtensions.cs
static class StudentExtensions
{
    public static void Print(this Student student)
    {
        Console.WriteLine($"{student.Name}, {student.Age} years old");
    }
}  
```

> Alter Program.cs

```cs
class Program
{
  static void Main(string[] args)
  {
    var john = new Student();
    john.Name = "John";
    john.Age = 23;
    // change this line
    john.Print();

    john.AgeUpdated += student_AgeUpdated;
    john.AgeUpdated += HappyBirthday;
    john.Age = 24;
  }
}
```

Note that the namespace that the extension class resides in must be brought into scope with a `using` statement for
the extension methods to be visible.  Also, it's possible to define these extension methods for interfaces, not just
classes.

It's probably tempting to use extension methods all over the place, but careful thought should be put into
whether an extension method is the right solution.


### Lambdas

C# provides a shortcut for defining an inline function, which is useful for functions which accept delegates.

Instead of passing a method name to a method requiring a delegate, you can
just define the method in-line:

```cs
// instead of:
MethodUsingDelegate(SomeOtherMethod);

bool SomeOtherMethod(int x)
{
  return x > 5;
}

// you can use this:
MethodUsingDelegate((x) => x > 5)
```

The `=>` operator, sometimes called a "fat arrow", is often pronounced "such that".



### `IEnumerable` extension methods

Arrays, `List`s, etc all implement the `IEnumerable<T>` interface in C#, and there are a ton of extension methods
defined for this.  Let's look at a random smattering to give you an idea.

> Update Program.cs to define a list of students and add a `PrintStudents` method.

```cs
using System.Collections.Generic;
using System.Linq;

class Program
{
  static void Main(string[] args)
  {
    // ... keep the lines from before so they have a record
    // and add these ones to the end:
    var students = new Student[] {
      new Student() { Name = "John", Age = 24 },
      new Student() { Name = "Fred", Age = 32 },
      new Student() { Name = "Barney", Age = 53 }
    };
  }

  static void PrintStudents(IEnumerable<Student> students)
  {
    foreach (var student in students)
    {
      student.Print();
    }
  }
}
```


**`Where`**

The `Where` method is for filtering, i.e., returning the only the elements
which match a given criteria, or _predicate_.

> Add the following to the `Main` method in `Program.cs`.

```cs
Console.WriteLine("Students older than 30:");
PrintStudents(students.Where((student) => student.Age > 30));
```

**`First`**

The `First` method gets the first element for which the predicate is true.

> Add to `Main` method.

```cs
Console.WriteLine("First student called John:");
students.First((student) => student.Name == "John").Print();
```

`Last` gets the last element matching the predicate.  There are also `FirstOrDefault` and `LastOrDefault`, which return
the default value for the type if there are no elements which match the predicate.

**`Select`**

The `Select` method is like the `map` function in other languages.

> Add to `Main` method.

```cs
Console.WriteLine("Ages:");
var ages = students.Select(x => x.Age).ToArray();
Console.WriteLine(String.Join(",", ages));
```

**`Aggregate`**

The `Aggregate` method is like the `reduce` function in other languages.

> Add to `Main` method.

```cs
var total = students.Aggregate(0, (sum, student) => sum + student.Age);
Console.WriteLine("Total age: {0}", total);
```

**`Sum`**

Another way to do the above is to use the `Sum` method.  For this, the
expression you pass should select the property you wish to sum.

> Add to `Main` method.

```cs
var total2 = students.Sum((student) => student.Age);
Console.WriteLine("Total age (using Sum): {0}", total2);
```

**`Max`**

`Max` takes an optional function specifying how to calculate the max value in the enumerable.

> Add to `Main` method.

```cs
var students = GetListOfStudents();
var maxAge = students.Max(x => x.Age);
```

### Linq

Linq introduces a SQL-like query language into C#.  It translates directly into `IEnumerable` method calls.

For example, if we wanted to get the names of all the students over 25:

> Add to `Main` method.

```cs
var names = from student in students
            where student.Age > 25
            select student.Name;

Console.WriteLine("Students older than 25: {0}", String.Join(",", names));
```

This translates into:

```cs
var names = students
  .Where(student => student.Age > 25)
  .Select(student => student.Name);
```

You can construct some pretty advanced queries in Linq, with `group` and `order` clauses and all sorts, but we'll
leave that as an exercise to the interested reader.

### Nuget

The .NET ecosystem has a package manager called [Nuget](https://www.nuget.org/), which allows you to easily include
open source libraries in your own code.

For example, the most popular library is [Newtonsoft.JSON](https://www.nuget.org/packages/Newtonsoft.Json/), a JSON
parsing and formatting library.  If you want to write a program that deals with JSON, for example, talking to a JSON
HTTP API, you can just use Nuget to include this package in your project, and then not have to worry about how to
parse and format JSON.
