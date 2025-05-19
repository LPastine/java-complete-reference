# Chapter 4 - Operators

Java provides a rich operator environment. Most of its operators can be divided
into the following four groups:

- Arithmetic
- Bitwise
- Relational
- Logical

Java also defines some additional operators that handle certain special situations.
This chapter describes all of Java's operators except for the type comparison
operator **instanceof** and the arrow operator (->), which are described, in
other chapters.

## Arithmetic Operators

Arithmetic operators are used in mathematical expressions in the same way they
are used in algebra.

The following table lists the arithmetic operators:

| Operator | Result                          |
|----------|---------------------------------|
| +        | Addition (also unary plus)      |
| -        | Substraction (also unary minus) |
| *        | Multiplication                  |
| /        | Division                        |
| %        | Modulus                         |
| ++       | Increment                       |
| +=       | Addition Assignment             |
| -=       | Substraction Assignment         |
| *=       | Multiplication Assignment       |
| /=       | Division Assignment             |
| %=       | Modulus Assignment              |
| --       | Decrement                       |

The operands of the arithmetic operators must be of a numeric type. You cannot
use them on **boolean** types, but you can use them on **char** types, since
the **char** type in Java is, essentially, a subset of **int**.

## The Basic Arithmetic Operators

The basic arithmetic operations - addition, substraction, multiplication, and division -
all behave as you would expect for all numeric types. The unary minus operator negates
its single operand. The unary plus operator simply returns the value of its operand.

Remember that when the division operator is applied to an integer type, there will
be no fractional component attached to the result.

The following simple sample program demonstrates the arithmetic operators. It also
illustrates the difference between floating-point division and integer division.

[BasicMath.java](./arithmetic/BasicMath.java)

## The Modulus Operator

The modulus operator, %, returns the remainder of a division operation. It can be applied
to floating-point types as well as integer types. The following sample program demonstrates the
%:

[Modulus.java](./arithmetic/Modulus.java)

## Arithmetic Compound Assignment Operators

Java provides special operators that can be used to combine an arithmetic operation with an
assignment. As you probably know, statements like the following are quite common in programming:

```java
a = a + 4;
```

In Java, you can rewrite this statement as shown here:

```java
a += 4;
```

This version uses the += _compound assignment operator_. Both statements perform the same action:
they increase the value of **a** by 4.

Here is another example,

```java
a = a % 2;
```

which can be expressed as

```java
a %= 2;
```

In this case, the %= obtains the remainder of **a / 2** and puts that result back into **a**.

There are compound assignment operators for all of the arithmetic, binary operators. Thus,
any statement of the form

_var = var op expression;_

can be rewritten as

_var op = expression;_

The compound assignment operators provide two benefits:

- First, they save you a bit of typing, because they are "shorthand" for their equivalent long forms. 
- Second, in some cases, they are more efficient than are their equivalent long forms.

For these reasons, you will often see the compound assignment operators used in professionally
written Java programs.

Here is a sample program that shows several _op=_ assignments in action:

[OpEquals.java](./arithmetic/OpEquals.java)

## Increment and Decrement

The ++ and the -- are Java's increment and decrement operators, respectively.

The increment operator increases its operand by one. The decrement operator decreases its operand
by one. For example, this statement:

```java
x = x + 1;
```

can be rewritten like this by use of the increment operator:

```java
x++;
```

Similarly, this statement:

```java
x = x - 1;
```

is equivalent to:

```java
x--;
```

These operators are unique in that they can appear both in _postfix_ form, where they
follow the operand as just shown, and _prefix_ form, where they precede the operand.

In the foregoing examples, there is no difference between the prefix and postfix forms. However,
when the increment and/or decrement operators are part of a larger expression, then, a subtle
yet powerful, difference between these two forms appears.

In the prefix form, the operand is incremented or decremented before the value is obtained for
use in the expression. In postfix form, the previous value is obtained for use in the expression,
and then the operand is modified. For example,

```java
x = 42;
y = ++x;
```

In this case, **y** is set to 43 as you would expect, because the increment occurs _before_ 
**x** is assigned to **y**. Thus, the line **y == x;** is the equivalent of these two statements:

```java
x = x + 1;
y = x;
```

However, when written like this,

```java
x = 42;
y = x++;
```

the value of **x** is obtained before the increment operator is executed, so the value of **y**
is 42. Of course, in both cases **x** is set to 43. Here, the line **y = x++;** is the equivalent
of these two statements:

```java
y = x;
x = x + 1;
```

The following program demonstrates the increment operator:

[IncDec.java](./arithmetic/IncDec.java)

