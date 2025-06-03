# Chapter 6 - Classes

## Table of contents:

- [Class Fundamentals](#class-fundamentals)
    - [The General Form of a Class](#the-general-form-of-a-class)
    - [A Simple Class](#a-simple-class)
- [Declaring Objects](#declaring-objects)
    - [A Closer Look at new](#a-closer-look-at-new)
    - [Assigning Object Reference Variables](#assigning-object-reference-variables)
- [Introducing Methods](#introducing-methods)
    - [Adding a Method to the Box Class](#adding-a-method-to-the-box-class)
    - [Returning a Value](#returning-a-value)
    - [Adding a Method That Takes Parameters](#adding-a-method-that-takes-parameters)
- [Constructors](#constructors)
    - [Parameterized Constructors](#parameterized-constructors)
    - [The this Keyword](#the-this-keyword)
    - [Instance Variable Hiding](#instance-variable-hiding)
- [Garbage Collection](#garbage-collection)
    - [A Stack Class](#a-stack-class)


## Class Fundamentals

The class is at the core of Java. It is the logical construct upon which the
entire Java language is built because it defines the shape and nature of an object.

As such, the class forms the basis for object-oriented programming in Java. Any
concept you wish to implement in a Java program must be encapsulated within a class.

Because the class is so fundamental to Java, this and the next few chapters will be
devoted to it. Here, you will be introduced to the basic elements of a class and
learn how a class can be used to create objects. You will also learn about methods,
constructors, and the **this** keyword.

Perhaps the most important thing to understand about a class is that it defines
a new data type. Once defined, this new type can be used to create objects of that
type. 

Thus, a class is a _template_ for an object, and an object is an _instance_
of a class. 

Because an object is an instance of a class, you will often see the 
two words _object_ and _instance_ used interchangeably.

### The General Form of a Class

When you define a class, you declare its exact form and nature. You do this by specifying the
data that it contains and the code that operates on that data. While very simple classes may
contain only code or only data, most real-world classes contain both. As you will see, a class's
code defines the interface to its data.

A class is declared by use of the **class** keyword. The classes that have been used up to this
point are actually very limited examples of its complete form.

Classes can (and usually do) get much more complex. A simplified general form of a **class**
definition is shown here:

```java
class Classname {
    type instanceVariable1;
    type instanceVariable2;
    // ..
    type instanceVariableN;
    
    type methodName1(parameterList) {
        // body of method
    }

    type methodName2(parameterList) {
        // body of method
    }

    type methodNameN(parameterList) {
        // body of method
    }
}
```

The data or variables, defined within a **class** are called _instance variables_.

The code is contained within _methods_. Collectively, the methods and variables defined within
a class are called _members_ of the class. 

In most classes, the instance variables are acted upon and accessed by the methods defined for
that class. Thus, as a general rule, it is the methods that determine how a class's data can
be used.

Variables defined within a class are called instance variables because each instance of the
class (that is, each object of the class) contains its own copy of these variables.

Thus, the data for one object is separate and unique from the data for another.

All methods have the same general form as **main()**, which we have been using thus far. However,
most methods will not be specified as **static** or **public**.

Notice that the general form of a class does not specify a **main()** method. Java classes do not
need to have a **main()** method. You only specify one if that class is the starting point for
your program. Further, some kinds of Java applications don't require a **main()** method at all.

### A Simple Class

Here is a class called **Box** that defines three instance variables: **width**, **height**, and
**depth**.

Currently, **Box** does not contain any methods (but some will be added soon).

```java
class Box {
    double width;
    double height;
    double depth;
}
```

As stated, a class defines a new type of data. In this case, the new data type is called **Box**.
You will use this name to declare objects of type **Box**. It is important to remember that a class
declaration only creates a template; it does not create an actual object. Thus, the preceding
code does not cause any objects of type **Box** to come into existence.

To actually create a **Box** object, you will use a statement like the following:

```java
Box myBox = new Box(); // create a Box object called mybox
```

After this statement executes, **mybox** will refer to an instance of **Box**. Thus, it will have
"physical" reality. For the moment, don't worry about the details of this statement.

As mentioned earlier, each time you create an instance of a class, you are creating an object
that contains its own copy of each instance variable defined by the class. Thus, every **Box**
object will contain its own copies of the instance variables **width**, **height**, and
**depth**.

To access these variables, you will use the _dot_ (.) operator. The dot operator links the name
of the object with the name of an instance variable. For example, to assign the **width** variable
of **mybox** the value 100, you would use the following statement:

```java
mybox.width = 100;
```

This statement tells the compiler to assign the copy of **width** that is contained within the
**mybox** object the value of 100. In general, you use the dot operator to access both the
instance variables and the methods within an object.

One other point: Although commonly referred to as the dot _operator_, the formal specification
for Java categorizes the . as a separator. However, since the use of the term "dot operator" is
widespread, it is used in this book.

Here is a complete program that uses the **Box** class:

[BoxDemo.java](./fundamentals/BoxDemo.java)

As stated earlier, each object has its own copies of the instance variables. This means that
if you have two **Box** objects, each has its own copy of **depth**, **width**, and **height**.

It is important to understand that changes to the instance variables of one object have no
effect on the instance variables of another.

For example, the following program declares two **Box** objects:

[BoxDemoTwo.java](./fundamentals/BoxDemoTwo.java)


## Declaring Objects

### A Closer Look at new

### Assigning Object Reference Variables

## Introducing Methods

### Adding a Method to the Box Class

### Returning a Value

### Adding a Method That Takes Parameters

## Constructors

### Parameterized Constructors

### The this Keyword

### Instance Variable Hiding

## Garbage Collection

### A Stack Class

