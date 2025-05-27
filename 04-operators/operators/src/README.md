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

### The Basic Arithmetic Operators

The basic arithmetic operations - addition, substraction, multiplication, and division -
all behave as you would expect for all numeric types. The unary minus operator negates
its single operand. The unary plus operator simply returns the value of its operand.

Remember that when the division operator is applied to an integer type, there will
be no fractional component attached to the result.

The following simple sample program demonstrates the arithmetic operators. It also
illustrates the difference between floating-point division and integer division.

[BasicMath.java](./arithmetic/BasicMath.java)

### The Modulus Operator

The modulus operator, %, returns the remainder of a division operation. It can be applied
to floating-point types as well as integer types. The following sample program demonstrates the
%:

[Modulus.java](./arithmetic/Modulus.java)

### Arithmetic Compound Assignment Operators

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

### Increment and Decrement

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

## The Bitwise Operators

Java defines several _bitwise operators_ that can be applied to the integer types: **long**,
**int**, **short**, **char** and **byte**.

These operators act upon the individual bits of their operands. They are summarized in the
following table:

| Operator | Result                           |
|----------|----------------------------------|
| ~        | Bitwise unary NOT                |
| &        | Bitwise AND                      |
| \|       | Bitwise OR                       |
| ^        | Bitwise exclusive OR             |
| \>>      | Shift right                      |
| \>>>     | Shift right zero fill            |
| \<<      | Shift left                       |
| &=       | Bitwise AND assignment           |
| \|=      | Bitwise OR assignment            |
| ^=       | Bitwise exclusive OR assignment  |
| \>>=     | Shift right assignment           |
| \>>>=    | Shift right zero fill assignment |
| \<<=     | Shift left assignment            |

Since the bitwise operators manipulate the bits within an integer, it is important to understand
what effects such manipulations may have on a value. Specifically, it is useful to know how
Java stores integer values and how it represents negative numbers. So, before continuing, let's
briefly review these two topics.

All the integer types are represented by binary numbers or varying bit widths. For example,
the **byte** value for 42 in binary is 00101010, where each position represents a power of two,
starting with 2⁰ at the rightmost bit. The next bit position to the left would be 2¹, or 2,
continuing toward the left with 2², or 4, then 8, 16, 32, and so on. So 42 has one bit set at
positions 1, 3, and 5 (counting from 0 at the right); thus, 42 is the sum of 2¹ + 2³ + 2⁵, which
is 2 + 8 + 32.

All the integer types (except **char**) are signed integers. This means that they can represent
negative values as well as positive ones. Java uses an encoding known as _two's complement_,
which means that negative numbers are represented by inverting (changing 1's to 0's and vice
versa) all the bits in a value, then adding 1 to the result.

For example, -42 is represented by inverting all the bits in 42, or 00101010, which yields
11010101, then adding 1, which results in 11010110, or -42. To decode a negative number, first
invert all of the bits, then add 1. For example, -42, or 11010110 inverted, yields 00101001, or
41, so when you add 1 you get 42.

The reason Java (and most other computer languages) uses two's complement is easy to see when
you consider the issue of _zero crossing_.

Assuming a **byte** value, zero is represented by 00000000. In one's complement, simply inverting
all the bits creates 11111111, which creates negative zero. The trouble is that negative
zero is invalid in integer math.

This problem is solved by using two's complement to represent negative values. When using two's
complement, 1 is added to the complement, producing 100000000. This produces a 1 bit too far
to the left to fit back into the **byte** value, resulting in the desired behavior, where -0 is
the same as 0, and 11111111 is the encoding for -1. Although we used a **byte** value in the
preceding example, the same basic principle applies to all of Java's integer types.

Because Java uses two's complement to store negative numbers - and because all integers are signed
values in Java - applying the bitwise operators can easily produce unexpected results. For example,
turning on the high-order bit will cause the resulting value to be interpreted as a negative
number, whether this is what you intended or not. To avoid unpleasant surprises, just remember
that the high-order bit determines the sign of an integer no matter how that high-order bit
gets set.

### The Bitwise Logical Operators

The bitwise logical operators are **&**, **|**, **^**, and **~**. The following table shows the
outcome of each operation. In the discussion that follows, keep in mind that the bitwise operators
are applied to each bit within each operand.

| A   | B   | A \| B | A & B | A ^ B | ~A  |
|-----|-----|--------|--------|--------|-----|
| 0   | 0   |   0    |   0    |   0    |  1  |
| 1   | 0   |   1    |   0    |   1    |  0  |
| 0   | 1   |   1    |   0    |   1    |  1  |
| 1   | 1   |   1    |   1    |   0    |  0  |

#### **The Bitwise NOT** 

Also called the _bitwise complement_, the unary NOT operator, ~, inverts all the bits of its
operand. For example, the number 42, which has the following bit pattern.

00101010

becomes

11010101

after the NOT operator is applied.

### **The Bitwise AND**

The AND operator, **&**, produces a 1 bit if both operands are also 1. A zero is produced in
all other cases. Here is an example:

```java
    00101010    42
&   00001111    15
------------
    00001010    10
```

### **The Bitwise OR**

The OR operator, **|**, combines bits such that if either of the bits in the operands is a 1,
then the resultant bit is a 1, as shown here:

```java
    00101010    42
|   00001111    15
------------
    00101111    47
```

### **The Bitwise XOR**

The XOR operator ^, combines bits such that if exactly one operand is 1, then the result is 1.
Otherwise, the result is zero. The following example shows the effect of the ^. This example
also demonstrates a useful attribute of the XOR operation. Notice how the bit pattern of 42 is
inverted wherever the second operand has a 1 bit. Wherever the second operand has a 0 bit,
the first operand is unchanged. You will find this property useful when performing some types
of bit manipulations.

```java
    00101010    42
|   00001111    15
------------
    00100101    37
```

### **Using the Bitwise Logical Operators**

The following program demonstrates the bitwise logical operators:

[BitLogic.java](./bitwise/BitLogic.java)

In this example, **a** and **b** have bit patterns that present all four possibilities for
two binary digits: 0-0, 0-1, 1-0, an 1-1. You can see how the **|** and **&** operate on each
bit by the results in **c** and **d**. The values assigned to **e** and **f** are the same and
illustrate how the ^ works. The string array named **binary** holds the human-readable, binary
representation of the numbers 0 through 15. In this example, the array is indexed to show the 
binary representation of each result. The array is constructed such that the correct string
representation of a binary value **n** is stored in **binary[n]**. The value to less than 16,
so it can be printed by use of the **binary** array.

### The Left Shift

The left shift operator, <<, shifts all the bits in a value to the left a specified number
of times. It has this general form:

_value << num_

Here, _num_ specifies the number of positions to left-shift the value in _value_. That is,
the << moves all the bits in the specified value to the left by the number of bit positions
specified by _num_.

For each shift left, the high-order bit is shifted out (and lost), and a zero is brought in on
the right. This means that when a left shift is applied to an **int** operand, bits are lost
once they are shifted past bit position 31. If the operand is a **long**, then bits are lost
after bit position 63.

Java's automatic type promotions produce unexpected results when you are shifting **byte** and
**short** values. As you know, **byte** and **short** values are promoted to **int** when an
expression is evaluated.

Furthermore, the result of such an expression is also an **int**. This means that the outcome
of a left shift on a **byte** or **short** value will be an **int**, and the bits shifted left
will not be lost until they shift past bit position 31.

Furthermore, a negative **byte** or **short** value will be sign-extended when it is promoted
to **int**. Thus, the high-order bits will be filled with 1's. For these reasons, to perform
a left shift on a **byte** or **short** implies that you must discard the high-order bytes of
the **int** result. For example, if you left-shift a **byte** value, that value will first be
promoted to **int** and then shifted. This means that you must discard the top three bytes
of the result if what you want is the result of a shifted **byte** value. The easiest way to
do this is to simply cast the result back into a **byte**. The following program demonstrates
this concept:

[ByteShift.java](./bitwise/ByteShift.java)

Since **a** is promoted to **int** for the purposes of evaluation, left-shifting the value
64 (0100 0000) twice results in **i** containing the value 256 (1 0000 0000). However, the value
**b** contains 0 because after the shift, the low-order byte is now zero. Its only 1 bit has
been shifted out.

Since each left shift has the effect of doubling the original value, programmers frequently
use this fact as an efficient alternative to multiplying by 2. But you need to watch out. If you
shift a 1 bit into the high-order position (bit 31 or 63), the value will become negative.

The following program illustrates this point:

[MultByTwo.java](./bitwise/MultByTwo.java)

The starting value was carefully chosen so that after being shifted left 4 bit positions, it
would produce -32. As you can see, when a 1 bit is shifted into bit 31, the number is interpreted
as negative.

### The Right Shift

The right shift operator, >>, shifts all the bits in a value to the right a specified number
of times. Its general form is shown here:

_value >> num_

Here, _num_ specifies the number of positions to right-shift the value in _value_. That is, the
\>> moves all the bits in the specified value to the right the number of bit positions
specified by _num_.

The following code fragment shifts the value 32 to the right by two positions, resulting in 
**a** being set to **8**.

```java
int a = 32;
a = a >> 2; // a now contains 8
```
When a value has bits that are "shifted off", those bits are lost. For example, the next code
fragment shifts the value 35 to the right two positions, which causes the two low-order bits
to be lost, resulting again in **a** being set to 8.

```java
int a = 35;
a = a >> 2; // a now contains 8
```

Looking at the same operation in binary shows more clearly how this happens:

```java
00100011    35
>> 2
00001000    8
```

Each time you shift a value to the right, it divides that value by two - and discards
any remainder. In some cases, you can take advantage of this for high-performance integer
division by 2.

When you are shifting right, the top (leftmost) bits exposed by the right shift are filled in
with the previous contents of the top bit. This is called _sign extension_ and serves to preserve
the sign of negative numbers when you shift them right. For example, -8 >> 1 is -4, which,
in binary, is:

```java
11111000    -8
>> 1
11111100    -4
```

It is interesting to note that if you shift -1 right, the result always remains -1, since sign
extension keeps bringing in more ones in the high-order bits.

Sometimes it is not desirable to sign-extend values when you are shifting them to the right.
For example, the following program converts a **byte** value to its hexadecimal string representation.
Notice that the shifted value is masked by ANDing it with **0x0f** to discard any sign-extended
bits so that the value can be used as an index into the array of hexadecimal characters.

[HexByte.java](./bitwise/HexByte.java)

### The Unsigned Right Shift

As you have just seen, the >> operator automatically fills the high-order bit with its previous
contents each time a shift occurs. This preserves the sign of the value. However, sometimes
that is undesirable. For example, if you are shifting something that does not represent a 
numeric value, you may not want sign extension to take place. This situation is common when you
are working with pixel-based values and graphics. In these cases, you will generally want to
shift a zero into the high-order bit no matter what its initial value was. This is known as
_unusual shift_. To achieve this, you will use Java's unsigned, shift-right operator, >>>,
which always shifts zeros into the high-order bit.

The following code fragment demonstrates the >>>. Here, **a** is set to -1, which sets all 32
bits to 1 in binary. This value is then shifted right 24 bits, filling the top 24 bits with zeros,
ignoring normal sign extension. This sets **a** to 255.

```java
int a = -1;
a = a >>> 24;
```

Here is the same operation in binary form to further illustrate what is happening:

```java
11111111 11111111 11111111 11111111 -1 in binary as an int
>>> 24
00000000 00000000 00000000 11111111 255 in binary as an int
```

The >>> operator is often not as useful as you might like, since it is only meaningful for 32-
and 64-bit values. Remember, smaller values are automatically promoted to **int** in expressions.
This means that sign extension occurs and that the shift will take place on a 32-bit rather than
on a 8- or 16-bit value. That is, one might expect an unsigned right shift on a **byte** value
to zero-fill beginning at bit 7. But this is not the case, since it is a 32-bit value that is
actually being shifted. The following program demonstrates this effect:

[ByteUShift.java](./bitwise/ByteUShift.java)

The following output of this program shows how the >>> operator appears to do nothing when dealing
with bytes. The variable **b** is set to an arbitrary negative **byte** value for this demonstration.
Then **c** is assigned the **byte** value of **b** shifted right by four, which is 0xff because
of the expected sign extension. 

Then **d** is assigned the **byte** value of **b** unsigned shifted
right by four. 

Which you might have expected to be 0x0f but is actually 0xff because of the sign
extension that happened when **b** was promoted to **int** before the shift. 

The last expression sets **e** to the **byte** value of **b** masked to 8 bits using the AND
operator, then shifted right by four, which produces the expected value of 0x0f. Notice that the
unsigned shift right operator was not used for **d**, since the state of the sign bit after the
AND was known.

### Bitwise Operator Compound Assignments

All of the binary bitwise operators have a compound form similar to that of the algebraic operators,
which combines the assignment with the bitwise operation. For example, the following two statements,
which shift the value in **a** right by four bits, are equivalent:

```java
a = a >> 4;
a >>= 4;
```

Likewise, the following two statements, which result in **a** being assigned the bitwise expression
**a** OR **b**, are equivalent:

```java
a = a | b;
a |= b;
```

The following program creates a few integer variables and then uses compound bitwise operator
assignments to manipulate the variables:

[OpBitEquals.java](./bitwise/OpBitEquals.java)

## Relational Operators

The _relational operators_ determine the relationship that one operand has to the other.
Specifically, they determine equality and ordering. The relational operators are shown here:

| Operator | Result                   |
|----------|--------------------------|
| ==       | Equal to                 |
| !=       | Not Equal to             |
| >        | Greater than             |
| <        | Less than                |
| >=       | Greater than or equal to |
| <=       | Less than or equal to    |

The outcome of these operations is a **boolean** value. The relational operators are most frequently
used in the expressions that control the **if** statement and various loop statements.

Any type in Java, including integers, floating-point numbers, characters, and Booleans can be
compared using the equality test, ==, and the inequality test !=. Notice that in Java equality
is denoted with two equal signs, not one. (Remember: a single equal sign is the assignment
operator.) Only numeric types can be compared using the ordering operators. That is, only integer,
floating-point, and character operands may be compared to see which is greater or less than the
other.

As stated, the result produced by a relational operator is a **boolean** value. For example,
the following code fragment is perfectly valid:

```java
int a = 4;
int b = 1;
boolean c = a < b;
```

In this case, the result of **a < b** (which is **false**) is stored in **c**.

If you are coming from a C/C++ background, please note the following. In C/C++, these types
of statements are widespread.

```C++
int done;
// ...
if(!done)... // Valid in C/C++
if(done)... // but not in Java
```

In Java, these statements must be written like this:

```Java
if(done == 0) ... // This is Java-style
if(done != 0) ...
```

The reason is that Java does not define true and false in the same way as C/C++. In C/C++, true
is any nonzero value and false is zero. In Java, **true** and **false** are nonnumerical values
that do not relate to zero or nonzero. Therefore, to test for zero or nonzero, you must explicitly
employ one or more of the relational operators.

### Boolean Logical Operators

The Boolean logical operators shown here operate only on **boolean** operands. All the
binary logical operators combine two **boolean** values to form a resultant **boolean** value.

| Operator | Result                     |
|----------|----------------------------|
| &        | Logical AND                |
| \|       | Logical OR                 |
| ^        | Logical XOR (exclusive OR) |
| \|\|     | Short-circuit OR           |
| &&       | Short-circuit AND          |
| !        | Logical unary NOT          |
| &=       | AND assignment             |
| \|=      | OR assignment              |
| ^=       | XOR assignment             |
| ==       | Equal to                   |
| !=       | Not equal to               |
| ?:       | Ternary if-then-else       |

The logical Boolean operators, **&**, **|**, and **^**, operate **boolean** values in the same
way that they operate on the bits of an integer. The logical **!** operator inverts the Boolean
state: **!true == false** and **!false == true**. The following table shows the effect of each
logical operation:

| A     | B     | A \| B | A & B | A ^ B | !A    |
|-------|-------|--------|-------|-------|-------|
| False | False | False  | False | False | True  |
| True  | False | True   | False | True  | False |
| False | True  | True   | False | True  | True  |
| True  | True  | True   | True  | False | False |

Here is a program that is almost the same as the **BitLogic** example shown earlier, but
it operates on **boolean** logical values instead of binary bits:

[BoolLogic.java](./relational/BoolLogic.java)

After running this program, you will see that the same logical rules apply to **boolean** values
as they did to bits. As you can see from its output, the string representation of a
Java **boolean** value is one of the literal values **true** or **false**.

### Short-Circuit Logical Operators

Java provides two interesting Boolean operators not found in some other computer languages.

These are secondary versions of the Boolean AND and OR operators, and are commonly known as
_short-circuit_ logical operators. As you can see from the preceeding table, the OR operator
results in **true** when **A** is **true**, no matter what **B** is.

Similarly, the AND operator results in **false** when **A** is false, no matter what **B** is.

If you use the **||** and **&&** forms rather than the **|** and **&** forms of these operators,
Java will not bother to evaluate the right-hand operand when the outcome of the expression can
be determined by the left operand alone.

This is invaluable when the right-hand operad depends on the value of the left one to
function properly.

For example, the following code fragment shows how you can take advantage of short-circuit
logical evaluation to be sure that a division operation will be valid before evaluating it:

```java
if (denom != 0 && num / denom > 10)
```

Since the short-circuit form of AND (**&&**) is used, there is no risk of causing a run-time
exception when **denom** is zero. If this line of code were written using a single **&** version
of AND, both sides would be evaluated, causing a run-time exception when **denom** is zero.

It is standard practice to use the short-circuit forms of AND and OR in cases involving
Boolean logic, leaving the single-character versions exclusively for bitwise operations.

However, there are exceptions to this rule. For example, consider the following statement:

```java
if (c == 1 & e++ < 100) d = 100;
```

Here, using a single **&** ensures that the increment operation will be applied to **e** wether
**c** is equal to 1 or not.

Note: The formal specification for Java refers to the short-circuit operators as the
_conditional-and_ and the _conditional-or_

