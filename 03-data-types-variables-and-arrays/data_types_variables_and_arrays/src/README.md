


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
[BoolTest.java](./examples/booleantype/BoolTest.java)

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

## Variables

The variable is the basic unit of storage in a Java program. A variable is defined
by the combination of an identifier, a type, and an optional initializer. In addition,
all variables have a scope, which defines their visibility, and a lifetime.

### Declaring a variable

In Java, all variables must be declared before they can be used. The basic form of
a variable declaration is shown here:

_type identifier [ = value ][, identifier [ = value ] ...];_

Here, _type_ is one of Java's atomic types, or the name of a class or interface. The
_identifier_ is the name of the variable. You can initialize the variable by specifying
an equal sign and a value. Keep in mind that the initialization expression must result
in a value of the same (or compatible) type as that specified for the variable. To declare
more than one variable of the specified type, use a comma-separated list.

Here are several examples of variable declarations of various types. Note that some
include initialization.

```java
int a, b, c; // declares three ints a, b and c.
int d = 3, e, f = 5; // declares three more ints, initializing d and f
byte z = 22; // initializes z
double pi = 3.14159; // declares an approximation of pi
char x = 'x'; // the variables x has the value 'x'
```

The identifiers that you choose have nothing intrinsic in their names that indicates
their type. Java allows any properly formed identifiers to have any declared type.

### Dynamic Initialization

Although the preceding examples have used only constants as initializers, Java allows
variables to be initialized dynamically, using any expression valid at the time the
variable is declared.

For example, here is a short program that computes the length of the hypotenuse of a
right triangle given the lengths of its two opposing sides:

[DynInit.java](./examples/variables/DynInit.java)

### The scope and Lifetime of Variables

Java allows variables to be declared within any block. A block is begun with an opening
curly brace and ended by a closing curly brace. A block defined a _scope_.

A scope determines what objects are visible to other parts of your program. It also
determines the lifetime of those objects.

The scope defined by a method begins with its opening curly brace. However, if that
method has parameters, they too are included within the method's scope. A method's scope
ends with its closing curly brace. This block of code is called the _method body_.

As a general rule, variables declared inside a scope are not visible (that is, accessible)
to code that is defined outside that scope. Thus, when you declare a variable within a
scope, you are localizing that variable and protecting it from unauthorized access and/or
modification. Indeed, the scope rules provide the foundation for encapsulation. A variable
declared within a block is called a _local variable_.

Scopes can be nested. For example, each time you create a block of code, you are creating
a new, nested scope. When this occurs, the outer scope encloses the inner scope. This means
that objects declared in the outer scope will be visible to code within the inner scope. However,
the reverse is not true. Objects declared within the inner scope will not be visible outside it.

To understand the effect of nested scopes, consider the following program:

[Scope.java](./examples/variables/Scope.java)

If a variable declaration includes an initializer, then that variable will be reinitialized
each time the block in which it is declared is entered. For example, consider the next program

[LifeTime.java](./examples/variables/LifeTime.java)

Although blocks can be nested, you cannot declare a variable to have the same name as one
in an outer scope.

## Type Conversion and Casting

### Java's Automatic Conversions

When one type of data is assigned to another type of variable, an _automatic type conversion_ 
will take place if the following two conditions are met:

- The two types are compatible.
- The destination type is larger than the source type.

When these two conditions are met, a _widening conversion_ takes place. For example, the **int** type is
always large enough to hold all valid **byte** values, so no explicit cast statement is required.

For widening conversions, the numeric types, including integer and floating-point types, are
compatible with each other. However, there are no automatic conversions from the numeric types
to **char** or **boolean**. Also, **char** and **boolean** are not compatible with each other.

Java also performs an automatic type conversion when storing a literal integer constant into
variables of type **byte**, **short**, **long**, or **char**.

### Casting Incompatible Types

To create a conversion between two incompatible types, you must use a cast. A _cast_ is
simply an explicit type conversion. It has this general form:

_(target type) value_

Here _target type_ specifies the desired type to convert the specified value to. For
example, the following fragment casts an **int** to a **byte**. If the integer's value
is larger than the range of a **byte**, it will be reduced modulo (the remainder of an
integer division by) the byte's range.

```java
int a;
byte b;
b = (byte) a;
```

A different type of conversion will occur when a floating-point value is assigned to an
integer type: _truncation_. As you know, integers do not have fractional components. Thus,
when a floating-point value is assigned to an integer type, the fractional component is lost.
For example, if the value 1.23 is assigned to an integer, the resulting value will simply be 1.
Of course, if the size of the whole number component is too large to fit into the target
integer type, then that value will be reduced modulo the target type's range.

The following program demonstrates some type conversions that require casts:

[Conversion.java](./examples/conversion_casting/Conversion.java)

### Automatic Type Promotion in Expressions

In addition to assignments, there is another place where certain type conversions may
occur: in expressions.

For example:

```java
byte a = 40;
byte b = 50;
byte c = 100;
int d = a * b / c;
```

The result of intermediate term **a * b** easily exceeds the range of either of its **byte**
operands. To handle this kind of problem, Java automatically promotes each **byte**, **short**,
or **char** operand to **int** when evaluating an expression.

This means that the subexpression **a * b** is performed using integers - not bytes. Thus, 2,000,
the result of the intermediate expression, is legal even though **a** and **b** are both
specified as type **byte**.

As useful as the automatic promotions are, they can cause confusing compile-time errors.
For example, this seemingly correct code causes a problem:

```java
byte b = 50;
b = b * 2; // Error! Cannot assign an int to a byte!
```

The code is attempting to store 50 * 2, a perfectly valid **byte** value, back into a 
**byte** variable. However, because the operands were automatically promoted to **int**
when the expression was evaluated, the result has also been promoted to **int**. Thus,
the result of the expression is now of type **int**, which can't be assigned to a **byte**
without the use of a cast.

In cases where you understand the consequences of overflow, you should use an explicit
cast, such as.

```java
byte b = 50;
b = (byte) (b * 2);
```

### The Type Promotion Rules

Java defines several _type promotion_ rules that apply to expressions. They are as follows:
1. All **byte**, **short**, and **char** values are promoted to **int**, as just described.
2. If one operand is a **long**, the whole expression is promoted to **long**
3. If one operand is a **float**, the entire expression is promoted to **float**
4. If any of the operands are **double**, the result is **double**

The following program demonstrates how each value in the expression gets promoted to match
the second argument to each binary operator:

[Promote.java](./examples/conversion_casting/Promote.java)

In the first subexpression, **f * b**, **b** is promoted to a **float** and the result
of the subexpression, is **float**. Next, in the subexpression **i/c**, **c** is promoted
to **int**, and the result is of type **int**. Then, in **d * s**, the value of **s** is
promoted to **double**, and the type of the subexpression is **double**. Finally, these
three intermediate values, **float**, **int** and **double**, are considered. The outcome
of **float** plus an **int** is a **float**. Then the resultant **float** minus the last **double**
is promoted to **double**, which is the type for the final result of the expression.

## Arrays

An _array_ is a group of like-typed variables that are referred to by a common name. Arrays
of any type can be created and may have one or more dimensions. A specific element in an
array is accessed by its index. Arrays offer a convenient means of grouping related information.

### One-Dimensional Arrays

A _one-dimensional array_ is, essentially, a list of like-typed variables. To create an
array, you first must create an array variable of the desired type. The general form of a
one-dimensional array declaration is

_type[] var-name;_

Here, _type_ declares the element type (also called the base type) of the array. The element
type determines the data type of each element that comprises the array. Thus, the element
type of the array determines what type of data the array will hold. For example:

_int[] month_days;_

Although this declaration establishes the fact that _month_days_ is an array variable,
no array actually exists. To link **month_days** with an actual, physical array of integers,
you must allocate one using **new** and assign it to **month_days**. **new** is a special
operator that allocates memory.

The general form of **new** as it applies to one-dimensional arrays appears as follows:

_array_var = new type [size];_

Here, _type_ specifies the type of the data being allocated, _size_ specifies the number
of elements in the array, and _array-var_ is the array variable linked to the array.
That is, to use the **new** to allocate an array, you must specify the type and number of
elements to allocate. The elements in the array allocated by **new** will automatically
be initialized to zero (for numeric types), **false** (for **boolean**), or **null** (for 
reference types, which are described in a later chapter). For example:

_month_days = new int[12];_

After this statement executes, **month_days** will refer to an array of 12 integers. Further,
all elements in the array will be initialized to zero.

Once you have allocated an array, you can access a specific element in the array by specifying
its index within square brackets. All array indexes start at zero. For example, this statement
assigns value 28 to the second element of **mont_days**:

_month_days[1] = 28;_

The next line displays the value stored at index 3:

_System.out.println(month_days[3]);_

Putting together all the pieces, here is a program that creates an array of the number of
days in each month:

[Array.java](./examples/array/Array.java)

Arrays can be initialized when they are declared. The process is much the same as that used
to initialize the simple types. An _array initializer_ is a list of comma-separated expressions
surrounded by curly braces. The commas separate the values of the array elements.

The array will automatically be created large enough to hold the number of elements you
specify in the array initializer. There is no need to use **new**. For example:

[AutoArray.java](./examples/array/AutoArray.java)

Java strictly checks to make sure you do not accidentally try to store or reference values
outside the range of the array. The Java run-time system will check that all array indexes
are in the correct range. For example, the run-time system will check the value of each
index into **month_days** to make sure that is between 0 and 11, inclusive. If you try to
access elements outside the range of the array (negative numbers or numbers greater than
the length of the array), you will cause a run-time error.

Here is one more example that uses a one-dimensional array. It finds the average of a 
set of numbers.

[Average.java](./examples/array/Average.java)

### Multidimensional Arrays

In Java, _multidimensional arrays_ are implemented as arrays of arrays. To declare a multidimensional
array variable, specify each additional index using another set of square brackets.

For example, the following declares a two-dimensional array variable called **twoD**:

_int[][] twoD = new int[4][5];_

This allocates a 4-by-5 array and assigns it to **twoD**. Internally, this matrix is implemented
as an _array of arrays_ of **int**.

The following program numbers each element in the array from left to right, top to bottom,
and then displays these values:

[TwoDArray.java](./examples/array/TwoDArray.java)

When you allocate memory for a multidimensional array, you need only specify the memory
for the first (leftmost) dimension. You can allocate the remaining dimensions separately.

For example, this following code allocates memory for the first dimension of **twoD** when
it is declared. It allocates the second dimension separately.

```java
int[][] twoD = new int[4][];
twoD[0] = new int[5];
twoD[1] = new int[5];
twoD[2] = new int[5];
twoD[3] = new int[5];
```

While there is no advantage to individually allocating the second dimension arrays in this
situation, there may be in others. For example, when you allocate dimensions individually,
you do not need to allocate the same number of elements for each dimension. As stated earlier,
since multidimensional arrays are actually arrays of arrays, the length of each array is
under your control.

For example, the following program creates a two-dimensional array in which the sizes of
the second dimension are unequal:

[TwoDAgain.java](./examples/array/TwoDAgain.java)

It is possible to initialize multidimensional arrays. To do so, enclose each dimension's
initializer within its own set of curly braces.

The following program creates a matrix where each element contains the product of the row
and column indexes. Also notice that you can use expressions as well as literal values
inside array initializers.

[Matrix.java](./examples/array/Matrix.java)

The following program creates a 3-by-4-by-5, three-dimensional array. It then loads each element
with the product of its indexes. Finally, it displays these products.

[ThreeDMatrix.java](./examples/array/ThreeDMatrix.java)

## Introducing Type Inference with Local Variables

First, all variables in Java must be declared prior to their use.

Second, a variable can be initialized with a value when it is declared.

Furthermore, when a variable is initialized, the type of the initializer must be the same
as (or convertible to) the declared type of the variable.

Thus, in principle, it would not be necessary to specify an explicit type for an initialized
variable because it could be inferred by the type of its initializer.

Local variable type inference offers a number of advantages. For example, it can streamline
code by eliminating the need to redundantly specify a variable's type when it can be
inferred from its initializer.

It can simplify declarations in cases in which the type name is quite lengthy, such as
can be the case with some class names.

It can also be helpful when a type is challenging to discern or cannot be denoted.

Furthermore, local variable type inference has become a common part of the contemporary
programming environment.

To use local variable type inference, the variable must be declared with **var** as the
type name, and it must include an initializer. For example, in the past you would declare
a local **double** called **avg** that is initialized with the value 10.0 as shown here:

_double avg = 10.0;_

Using type inference, this declaration can now also be written like this:

_var avg = 10.0;_

In both cases, **avg** will be of type **double**. In the first case, its type is explicitly
specified. In the second, its type is inferred as **double** because the initializer 10.0
is of type **double**.

You can also use **var** to declare an array. For example:

_var myArray = new int[10]; // this is valid_

Notice that neither **var** nor **myArray** has brackets. Instead, the type of **myArray**
is inferred to be **int[]**.

Furthermore, you _cannot_ use brackets on the left side of a **var** declaration. Thus, both
of these declarations are invalid:

```java
var[] myArray = new int[10]; // Wrong
var myArray[] = new int[10]; // Wrong
```

It is important to emphasize that **var** can be used to declare a variable only when that
variable is initialized. For example, the following statement is incorrect:

```java
var counter; // Wrong! Initializer required.
```

Also remember that **var** can be used only to declare local variables. It cannot be used
when declaring instance variables, parameters, or return types, for example.

### Some var Restrictions

In addition to those mentioned in the preceding discussion, several other restrictions
apply to the use of **var**:

- Only one variable can be declared at a time;
- A variable cannot use **null** as an initializer;
- The variable being declared cannot be used by the initializer expression.
- Although you can declare an array type using **var**, you cannot use **var** with an array initializer.

## A Few Words About Strings

As you may have noticed, in the preceding discussion of data types and arrays, there has been
no mention of strings or a string data type. This is not because Java does not support
such a type—it does. It is just that Java's string type, called **String**, is not a primitive
type. Nor is it simply an array of characters. Rather, **String** defines an object, and a
full description of it requires an understanding of several object-related features.

As such, it will be covered later in this book, after objects are described. However, so
that you can use simple strings in sample programs, the following brief introduction is in
order.

The **String** type is used to declare string variables. You can also declare arrays of
strings. A quoted string constant can be assigned to a **String** variable. A variable
of type **String** can be assigned to another variable of type **String**. You can use
an object of type **String** as an argument to **println()**. For example, consider
the following fragment:

```java
String str = "this is a test";
System.out.println(str);
```

Here, **str** is an object of type **String**. It is assigned the string "this is a test".
This string is displayed by the **println()** statement.

As you will see later, **String** objects have many special features and attributes that
make them quite powerful and easy to use. However, for the next few chapters, you will
be using them only in their simplest form.
