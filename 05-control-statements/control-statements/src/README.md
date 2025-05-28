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

Here's a simple example that uses a **switch** statement:

[SampleSwitch.java](./selection_statements/SampleSwitch.java)

As you can see, each time through the loop, the statements associated with the **case**
constant that matches **i** are executed. All others are bypassed. After **i** is greater
than 3, no **case** statements match, so the **default** statement is executed.

The **break** statement is optional. If you omit the **break**, execution will continue
on into the next **case**. It is sometimes desirable to have multiple **cases** without
**break** statements between them. For example, consider the following program:

[MissingBreak.java](./selection_statements/MissingBreak.java)

As you can see, execution falls through each **case** until a **break** statement (or
the end of the **switch**) is reached.

While the preceding example is, of course, contrived for the sake of illustration, omitting
the **break** statement has many practical applications in real programs. To sample its
more realistic usage, consider the following rewrite of the season example shown earlier.
This version uses a **switch** to provide a more efficient implementation.

[Switch.java](./selection_statements/Switch.java)

As mentioned, you can also use a string to control a **switch** statement. For example:

[StringSwitch.java](./selection_statements/StringSwitch.java)

Being able to use strings in a **switch** statement streamlines many situations. For example,
using a string-based **switch** is an improvement over using the equivalent sequence of
**if/else** statements. However, switching on strings can be more expensive than switching
on integers.

Therefore, it is best to switch on strings only in cases in which the controlling data
is already in string form. In other words, don't use strings in a **switch** unnecessarily.

#### Nested switch Statements

You can use a **switch** as part of the statement sequence of an outer **switch**. This is
called a _nested_ **switch**. Since a **switch** statement defines its own block, no
conflicts arise between the **case** constants in the inner **switch** and those in the
outer **switch**. For example, the following fragment is perfectly valid:

```java
switch (count) {
    case 1:
        switch (target) { // nested switch
            case 0:
                System.out.println("target is zero");
                break;
            case 1: // no conflicts with outer switch
                System.out.println("target is one");
                break;
        }
        break;
    case 2: // ...
}
```

Here the **case 1:** statement in the inner switch does not conflict with the **case 1:** 
statement in the outer switch. The **count** variable is compared only with the list of
cases at the outer level. If **count** is 1, then **target** is compared with the inner
list cases.

In summary, there are three important features of the **switch** statement to note:

1. The **switch** differs from the **if** in that **switch** can only test for equality,
whereas **if** can evaluate any type of Boolean expression. That is, the **switch**
looks only for a match between the value of the expression and one of its **case**
constants.
2. No two **case** constants in the same **switch** can have identical values. Of course,
a **switch** statement and an enclosing outer **switch** can have **case** constants in
common.
3. A **switch** statement is usually more efficient than a set of nested **if**s.

The last point is particularly interesting because it gives insight into how the Java
compiler works. When it compiles a **switch** statement, the Java compiler will inspect
each of the **case** constants and create a "jump table" that it will use for selecting
the path of execution depending on the value of the expression. Therefore, if you need
to select among a large group of values, a **switch** statement will run much faster
than the equivalent logic coded using a sequence of **if-else**s. The compiler can do
this because it knows that the **case** constants are all the same type and simply must
be compared for equality with the **switch** expression. The compiler has no such knowledge
of a long list of **if** expressions.

Note: Recently, the capabilities and features of **switch** have been substantially
expanded beyond those offered by the traditional **switch** just described. Refer to
Chapter 17 for details on the enhanced **switch**.

## Iteration Statements

Java's iteration statements are **for**, **while**, and **do-while**. These statements
create what we commonly call _loops_. As you probably know, a loop repeatedly executes
the same set of instructions until a termination condition is met. As you will see,
Java has a loop to fit any programming need.

### while

The **while** loop is Java's most fundamental loop statement. It repeats a statement or block
while its controlling expression is true. Here is its general form:

```java
while (condition) {
    // body of loop
}
```

The _condition_ can be any Boolean expression. The body of the loop will be executed as long
as the conditional expression is true. When _condition_ becomes false, control passes to the
next line of code immediately following the loop.

Here is a **while** loop that counts down from 10, printing exactly ten lines of "tick".

[While.java](./iteration_statements/While.java)

Since the **while** loop evaluates its conditional expression at the top of the loop,
the body of the loop will not execute even once if the condition is false to begin with.

For example, in the following fragment, the call to **println()** is never executed.

```java
int a = 10, b = 20;

while (a > b) {
    System.out.println("This will not be displayed")    
}
```

The body of the **while** (or any other of Java's loops) can be empty. This is because a 
_null statement_ (one that consists only of a semicolon) is semantically valid in Java.

For example, consider the following program:

[NoBody.java](./iteration_statements/NoBody.java)

Here is how this **while** loop works. The value of **i** is incremented, and the value of
**j** is decremented. These values are then compared with one another. If the new value
of **i** is still less than the new value of **j**, then the loop repeats. If **i** is equal
to or greater than **j**, the loop stops. Upon exit from the loop, **i** will hold a value
that is midway between the original value of **i** and **j**. (Of course, this procedure
only works when **i** is less than **j** to begin with.)

As you can see, there is no need for a loop body; all the action occurs within the
conditional expression itself. In professionally written Java code, short loops are
frequently coded without bodies when the controlling expression can handle all the
details itself.

### do-while

As you just saw, if the conditional expression controlling a **while** loop is initially
false, then the body of the loop will not be executed at all. However, sometimes it is 
desirable to execute the body of a loop at least once, even if the conditional expression
is false to begin with.

In other words, there are times when you would like to test the termination expression at
the end of the loop rather than at the beginning.

Fortunately, Java supplies a loop that does just that: the **do-while**. The **do-while**
loop always executes its body at least once, because its conditional expression is at the
bottom of the loop. Its general form is:

```java
do {
    // body of loop    
} while (condition);
```

Each iteration of the **do-while** loop first executes the body of the loop and then
evaluates the conditional expression. If this expression is true, the loop will repeat.

Otherwise, the loop terminates. As with all of Java's loops, _condition_ must be a
Boolean expression.

Here is a reworked version of the "tick" program that demonstrates the **do-while** loop.
It generates the same output as before.

[DoWhile.java](./iteration_statements/DoWhile.java)

In this example, the expression **(--n > 0)** combines the decrement of **n** and the
test for zero into one expression. Here is how it works. First, the **--n** statement executes,
decrementing **n** and returning the new value of **n**. This value is then compared with
zero. If it is greater than zero, the loop continues; otherwise, it terminates.

The **do-while** loop is especially useful when you process a menu selection, because
you will usually want the body of a menu loop to execute at least once.

Consider the following program, which implements a basic help system for Java's
selection and iteration statements:

[Menu.java](./iteration_statements/Menu.java)

In the program, the **do-while** loop is used to verify that the user has entered a valid
choice. If not, then the user is reprompted. Since the menu must be displayed at least once,
the **do-while** is the perfect loop to achieve this.

### for

There are two forms of the **for** loop.

The first is the traditional form that has been in use since the original version of Java.

The second is the newer "for-each" form, added by JDK 5. Both types of **for** loops are
discussed here, beginning with the traditional form.

Here is the general form of the traditional **for** statement:

```java
for (initialization; condition; iteration) {
    // body
}
```

The **for** loop operates as follows. 

When the loop first starts, the _initialization_
portion of the loop is executed. Generally, this is an expression that sets the value
of the _loop control variable_, which acts as a counter that controls the loop. It is
important to understand that the initialization expression is executed only once.

Next, _condition_ is evaluated. This must be a Boolean expression. It usually tests the
loop control variable against a target value. If this expression is true, then the body
of the loop is executed. If it is false, the loop terminates.

Next, the _iteration_ portion of the loop is executed. This is usually an expression
that increments or decrements the loop control variable. 

The loop then iterates, first evaluating the conditional expression, then executing the
body of the loop, and then executing the iteration expression with each pass. This process
repeats until the controlling expression is false.

Here is a version of the "tick" program that uses a **for** loop:

[ForTick.java](./iteration_statements/ForTick.java)

#### Declaring Loop Control Variables Inside the for Loop

Often the variable that controls a **for** loop is needed only for the purposes of the loop
and is not used elsewhere. When this is the case, it is possible to declare the variable
inside the initialization portion of the **for**. For example, here is the preceding program
recoded so that the loop control variable **n** is declared as an **int** inside the for.

[ForTickInside.java](./iteration_statements/ForTickInside.java)

When you declare a variable inside a **for** loop, there is one important point to remember:
the scope of that variable ends when the **for** statement does. (That is, the scope of
the variable is limited to the **for** loop.)

Outside the **for** loop, the variable will cease to exist. If you need to use the loop
control variable elsewhere in your program, you will not be able to declare it inside the
**for** loop.

When the loop control variable will not be needed elsewhere, most Java programmers declare
it inside the **for**. For example, here is a simple program that tests for prime numbers.
Notice that the loop control variable, **i**, is declared inside the **for** since it is
unnecessary elsewhere.

[FindPrime.java](./iteration_statements/FindPrime.java)

### Using the Comma

There will be times when you will want to include more than one statement in the initialization
and iteration portions of the **for** loop. For example, consider the loop in the following
program:

[Sample.java](./iteration_statements/Sample.java)

As you can see, the loop is controlled by the interaction of two variables. Since the loop
is governed by two variables, it would be useful if both could be included in the **for**
statement itself, instead of **b** being handled manually. Fortunately, Java provides a
way to achieve this. To allow two or more variables to control a **for** loop, Java
permits you to include multiple statements in both the initialization and iteration
portions of the **for**. Each statement is separated from the next by a comma.

Using the comma, the preceding **for** loop can be more efficiently coded, as shown here:

[Comma.java](./iteration_statements/Comma.java)

#### Some for Loop Variations

The **for** loop supports a number of variations that increase its power and applicability.
The reason it is so flexible is that its three parts - the initialization, the conditional
test, and the iteration - do not need to be used for only those purposes. In fact, the
three sections of the **for** can be used for any purpose you desire.

One of the most common variations involves the conditional expression. Specifically,
this expression does not need to test the loop control variable against some target value.
In fact, the condition controlling the **for** can be any Boolean expression. For example,
consider the following fragment:

```java
boolean done = false;

for (int i = 1; !done; i++) {
    // ...
    if (interrupted()) done = true;
}
```

In this example, the **for** loop continues to run until the **boolean** variable **done**
is set to **true**. It does not test the value of **i**.


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

