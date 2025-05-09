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

## Integer Literals

Integers are probably the most commonly used type in the typical program. Any whole number
value is an integer literal.

Examples are 1, 2, 3 and 42. These are all decimal values, meaning they are describing a base
10 number.

Two other bases that can be used in integer literals are _octal_ (base eight) and _hexadecimal_
(base 16).

Integer literals create an **int** value, which in Java is a 32-bit integer value.

Since Java is strongly typed, you might be wondering how it is possible to assign an integer literal
to one of Java's other integer types, such as **byte** or **long**, without causing a type
mismatch error.

Fortunately, such situations are easily handled. When a literal value is assigned to a 
**byte** or **short** variable, no error is generated if the literal value is within the
range of the target type.

An integer literal can always be assigned to a **long** variable. However, to specify a **long**
literal, you will need to explicitly tell the compiler that the literal value is of
type **long**. You do this by appending an upper- or lowercase L to the literal. For example,
9223372036854775807L, is the largest **long**.

An integer can also be assigned to a **char** as long as it is within range.

You can embed one or more underscores in an integer literal. Doing so makes it easier
to read large integer literals. When the literal is compiled, the underscores are
discarded. For example:

```java
int x = 123_456_789;
```

## Floating-Point Literals

Floating-point numbers represent decimal values with a fractional component. They can
be expressed in either standard or scientific notation.

_Standard notation_ consists of a whole number component followed by a decimal point followed
by a fractional component.

For example, 2.0, 3.14159 and 0.6667 represent valid standard-notation floating-point numbers.

_Scientific notation_ uses a standard-notation floating-point number plus a suffix that
specifies a power of 10 by which the number is to be multiplied. The exponent is indicated
by an _E_ or _e_ followed by a decimal number, which can be positive or negative.

Examples include 6.022E23, 314159E-05, and 2e+100.

Floating-point literals in Java default to **double** precision. To specify a **float** literal,
you must append an _F_ or _f_ to the constant. You can also explicitly specify a **double** literal
by appending a _D_ or _d_. Doing so, of course is redundant. The default **double** type consumes
64 bits of storage, while the smaller **float** type requires only 32 bits.

## Boolean Literals

Boolean literals are simple. There are only two logical values that a **boolean** value
can have, **true** and **false**. The values of **true** and **false** do not convert into
any numerical representation. The **true** literal in Java does not equal 1, nor does the
**false** literal equal to 0. In Java, the Boolean literals can only be assigned to variables
declared as **boolean** or used in expressions with Boolean operators.

## Character Literals

Characters in Java are indices into the Unicode character set. They are 16-bit values that
can be converted into integers and manipulated with the integer operators, such as the
addition and subtraction operators.

## String Literals

String literals in Java are specified like they are in most other languages - by enclosing
a sequence of characters between a pair of double quotes.

Examples are: "Hello World" - "two\nlines" - "\"This is in quotes\""

