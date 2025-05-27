# Chapter 5 - Control Statements

A programming language uses _control_ statements to cause the flow of execution
to advance and branch based on changes to the state of a program. 

Java's program control statements can be put into the following categories:
- selection
- iteration
- jump

_Selection_ statements allow your program to choose different paths of execution
based upon the outcome of an expression or the state of a variable.

_Iteration_ statements enable program execution to repeat one or more statements
(that is, iteration statements form loops).

_Jump_ statements allow your program to execute in a nonlinear fashion.

## Java's Selection Statements

Java supports two selection statements: **if** and **switch**. These statements
allow you to control the flow of your program's execution based upon conditions
known only during run time.

### if

The **if** statement is Java's conditional branch statement. It can be used to
route program execution through two different paths. Here is the general form
of the **if** statement:

```java
if (condition) statement1;
else statement2;
```

Here, each _statement_ may be a single statement or a compound statement enclosed
in curly braces (that is, a block). The _condition_ is any expression that returns
a **boolean** value. The **else** clause is optional.

The **if** works like this: If the _condition_ is true, then _statement_ is executed.
Otherwise, _statement2_ (if it exists) is executed. In no case will both statements
be executed. For example, consider the following:

```java
int a, b;
// ...
if (a < b) a = 0;
else b = 0;
```

Here, if **a** is less than **b**, then **a** is set to zero. Otherwise, **b** is set
to zero. In no case are they both set to zero.

Most often, the expression used to control the **if** will involve the relational
operators. However, this is not technically necessary. It is possible to control
the **if** using a single **boolean** variable, as shown in this code fragment:

```java
boolean dataAvailable;
// ...
if (dataAvailable)
    ProcessData();
else
    waitForMoreData();
```

Remember, only one statement can appear directly after the **if** or the **else**.
If you want to include more statements, you'll need to create a block, as in
this fragment:

```java
int bytesAvailable;
// ...
if (bytesAvailable > 0) {
    ProcessData();
    bytesAvailable -= n;
} else
    waitForMoreData();
```

Here, both statements within the **if** block will execute if **bytesAvailable**
is greater than zero.

#### Nested ifs

A _nested_ **if** is an **if** statement that is the target of another **if** or
**else**. Nested **ifs** are widespread in programming. When you nest **if**s,
the main thing to remember is that an **else** statement always refers to the
nearest **if** statement that is within the same block as the **else** and that
is not already associated with an **else**. Here is an example:

```java
if (i == 10) {
    if (j < 20) a = b;
    if (k > 100) c = d; // this if is
    else a = c;         // associated with this else
}
else a = d;             // this else refers to if(i == 10)
```

#### The if-else-if Ladder

A common programming construct that is based upon a sequence of nested **if**s is
the if-else-if ladder. It looks like this:

```java
if (condition)
    statement;
else if (condition)
    statement;
else if (condition)
    statement;
.
.
.
else
    statement;
```

The **if** statements are executed from the top down. As soon as one of the 
conditions controlling the **if** is **true**, the statement associated with that
**if** is executed, and the rest of the ladder is bypassed.

If none of the conditions is true, then the final **else** statement will be
executed. The final **else** acts as a default condition; that is, if all other
conditional tests fail, then the last **else** statement is performed.

If there is no final **else** and all other conditions are **false**, then
no action will take place.

Here is a program that uses an **if-else-if** ladder to determine which season
a particular month is in:

[IfElse.java](./selection_statements/IfElse.java)

### The Traditional switch

The **switch** statement is Java's multiway branch statement. It provides an easy
way to dispatch execution to different parts of your code based on the value of
an expression. As such, it often provides a better alternative than a large series
of **if-else-if** statements. Here is the general form of a traditional **switch**
statement:

```java
switch (expression) {
    case value1:
        // statement sequence
        break;
    case value2:
        // statement sequence
        break;
    case valueN:
        // statement sequence
        break;
    default:
        // default statement sequence
}
```

For versions of Java prior to JDK 7, _expression_ must resolve to type **byte**,
**short**, **int**, **char**, or an enumeration.

Today, _expression_ can also be of type **String**, and beginning with JDK 21,
in some situations, it can be an object reference.

Each value in the **case** statements must be a unique constant expression (such
as a literal value). Duplicate **case** values are not allowed. The type of each
value must be compatible with the type of _expression_.

The traditional **switch** statement works like this: The value of the expression
is compared with each of the values in the **case** statements. If a match is found,
the code sequence following that **case** statement is executed. If none of the constants
matches the value of the expression, then the **default** statement is executed.

However, the **default** statement is optional. If no **case** matches and no
**default** is present, then no further action is taken.

The **break** statement is used inside the **switch** to terminate a statement
sequence. When a **break** statement is encountered, execution branches to the
first line of code that follows the entire **switch** statement. This has the
effect of "jumping out" of the **switch**.

#### Nested switch Statements

## Iteration Statements

### while

### do-while

### for

#### Declaring Loop Control Variables Inside the for Loop

#### Some for Loop Variations

### The For-Each Version of the for Loop

#### Iterating Over Multidimensional Arrays

#### Applying the Enhanced for

### Local Variable Type Inference in a for Loop

### Nested Loops

## Jump Statements

### Using break

#### Using break to Exit a Loop

#### Using break as a Form of Goto

### Using continue

### return

