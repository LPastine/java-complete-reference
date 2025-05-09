# Chapter 3 - Data Types, Variables and Arrays

## The Primitive Types

Java defines eight _primitive_ types of data:

1. byte
2. short
3. int
4. long
5. char
6. float
7. double
8. boolean

These can be put in four groups:

- **Integers**: This group includes **byte**, **short**, **int**, and **long** which are for whole-valued signed numbers.
- **Floating-point** numbers: This group includes **float** and **double**, which represent numbers with fractional precision.
- **Characters**: This group includes **char**, which represents symbols in a character set, like letters and numbers.
- **Boolean**: This group includes **boolean**, which is a special type for representing true/false values.

You can use these types as-is or to construct arrays or your own class types. Thus, they form the basis for all other types of data that you can create.

## Integers

Java defines four integer types: **byte**, **short**, **int**, and **long**.

All of these are signed, positive and negative values.

The _width_ of an integer type should not be thought of as the amount of storage
it consumes, but rather as the _behavior_ it defines for variables and expressions of that type.

The Java run-time environment is free to use whatever size it wants, as long as the types behave 
as you declare them. The width and ranges of these integer types vary widely, as shown in this table:

| Name  | Width | Range                                                   |
|-------|-------|---------------------------------------------------------|
| long  | 64    | -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 |
| int   | 32    | -2,147,483,648 to 2,147,483,647                         |
| short | 16    | -32,768 to 32,767                                       |
| byte  | 8     | -128 to 127                                             |


### byte

Variables of type **byte** are especially useful when you're working with a stream of data from
a network of file. They are also useful when you're working with raw binary data that may not
be directly compatible with Java's other built-in types.

Byte variables are declared by use of the **byte** keyword. For example, the following declares
two **byte** variables called **b** and **c**:

```java
byte b, c;
```

### short

Example:

```java
short s;
```

### int

In addition to other uses, variables of type **int** are commonly employed to control loops and to
index arrays.

Although you may think that using a **byte** or **short** would be more efficient than using
an **int** in situations in which the larger range of an **int** is not needed, this may not
be the case.

The reason is that when **byte** and **short** values are used in an expression, they are _promoted_
to **int** when the expression is evaluated. Therefore, **int** is often the best choice when an
integer is needed.

### long

Example of long usage:
[Light.java](./examples/longtype/Light.java)

## Floating-Point Types

Floating-point numbers, also known as _real_ numbers, are used when evaluating expressions that
require fractional precision. For example, calculations such as square root, or transcendentals
such as sine and cosine, result in a value whose precision requires a floating-point type.

There are two kinds of floating-point types: **float** and **double**, which represent single- and
double-precision numbers, respectively. Their width and range are shown here:

| Name   | Width | Range                                      |
|--------|-------|--------------------------------------------|
| double | 64    | 4.9 × 10⁻³²⁴ to 1.7976931348623157 × 10³⁰⁸ |
| float  | 32    | 1.4 × 10⁻⁴⁵ to 3.4028235 × 10³⁸            |

### float

Single precision is faster on some processors and takes half as much space as double precision,
but will become imprecise when the values are either very large or very small. Variables of type
**float** are useful when you need a fractional component but don't require a large degree of 
precision. For example, **float** can be useful when representing dollars and cents.

```java
float hightemp, lowtemp;
```

### double

Double precision is actually faster than single precision on some modern processors that have
been optimized for high-speed mathematical calculations. All transcendental math functions, such
as **sin()**, **cos()**, and **sqrt()**, return **double** values. When you need to maintain
accuracy over many iterative calculations, or are manipulating large-valued numbers, **double**
is the best choice.

Example of double usage:
[Area.java](./examples/doubletype/Area.java)

## Characters

In Java, the data type used to store characters is **char**. A key point to understand
is that Java uses _Unicode_ to represent characters. Unicode defines a fully international
character set that can represent all the characters found in all human languages.

Example of char usage:
[CharDemo.java](./examples/chartype/CharDemo.java)

Although **char** is designed to hold Unicode characters, it can also be used as an integer
type on which you can perform arithmetic operations. For example, you can add two characters
together or increment the value of a character variable.

Consider the following program:
[CharDemo2.java](./examples/chartype/CharDemo2.java)

## Booleans

Java has a primitive type, called **boolean**, for logical values. It can have only one of
two possible values, **true** or **false**. This is the type returned by all relational
operators, as in the case of **a < b**. **boolean** is also the type _required_ by the conditional
expressions that govern the control statements such as **if** and **for**.

Here is a program that demonstrates the **boolean** type:
[BoolTest.java](./examples/chartype/CharDemo2.java)
