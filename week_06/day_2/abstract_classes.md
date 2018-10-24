# Abstract Classes

## Objectives

- Understand what an abstract class is
- Understand the template method
- Understand the difference between an abstract class and an interface

## Intro

We can make a class abstract by using the 'abstract' keyword.

This means that we can't "new" up that class when it isn't appropriate. A "bear" can never have an instance, it has to be either a Polar Bear or a Grizzly Bear. Bears don't exist as a "thing" in the wild per se.

Abstract classes actually are a bit more powerful than that.

A class that is declared with the abstract keyword is known as an abstract class in Java. It can have abstract and non-abstract methods.

(Abstract methods have no body - non-abstract methods do.)

Let's see this in action


``` java
class Bear{
  public void roar(){
    System.out.println("ROOOAR");
  }
}

class PolarBear extends Bear{
}

class GrizzlyBear extends Bear{

}

class Runner{
  public static void main(String[] args){
    PolarBear polo = new PolarBear();
    GrizzlyBear grizzy = new GrizzlyBear();

    Bear bear = new Bear(); //Don't want to be able to do this

    polo.roar();
    grizzy.roar();

  }
}
```

``` java
abstract class Bear{
  public void roar(){
    System.out.println("ROOOAR");
  }

}
```

Abstract classes can define abstract methods.  These are methods that the abstract class doesn't provide an implemention for so it must be implemented by the subclass.

``` java
abstract class Bear{
  public void roar(){
    System.out.println("ROOOAR");
  }

  public abstract void getFood();
}


class PolarBear extends Bear{
  public void getFood(){
    System.out.println("Jump onto iceberg and get seal!");
  }
}

class GrizzlyBear extends Bear{
  public void getFood(){
    System.out.println("Jump in river, splash, splash, get salmon");
  }
}

```

## Why might we use this?

Model for Sql Persistence.  Say we put all our logic for our sql persistence into a super class in our week one projects. (All method save method.)

``` java
class SQLModel{
  public void save(){
  }
  public void all(){
  }
}

class Record extends SQLModel{

}
class Animal extends SQlmodel{

}

SQLModel sqlModel = new SQlModel() //Dont want this to happen
```
