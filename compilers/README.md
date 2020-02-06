# Steps

## **Step One** [Left Factor/Recursion]
Follow the steps below for the given C-- grammer from pages 501-502

#### *Left Factor*

```
S -> aB | aC
B -> y
C -> z
```

```
S -> aA
A -> B | C
B -> y
C -> z
```
#### *Fix Left Recursion*

```
S -> aB | S | BB | aa | Sb
B -> y
```

*use this rule to fix*

```
S  -> Aα | β
------------
S  -> βA
S' -> αA | ε
```

*apply the rule above to fix*

```
S  -> aBS' | BBS' | aaS'
S' -> S' | bS' | ε
B  -> y
```

## **Step Two** [First/Follow]

#### First Set

Traverse through the given grammer and find the terminals hit first:

*example grammer given below*

```
S  -> aBS' | BBS' | aaS'
S' -> S' | bS' | ε
B  -> y
```

*the example grammer's first set*

```
S  = {a,y}
S' = {b,ε}
B  = {y}
```

#### Follow Set

Traverse through the given grammer and find the terminals hit after:

*example grammer given below*

```
S  -> aBS' | BBS' | aaS'
S' -> S' | bS' | ε
B  -> y
```

*the example grammer's follow set*

```
S  = {$}
S' = {$,a,y,b}
B  = {y}
```

*Remember - $ always goes into the first most set*

## **Step Three** [Table]

#### Add First Set

Now it is time to make the table. The first sets will be added first:

```
   | a  | b  | y  | $  
───┼────┼────┼────┼────
 S |aBS'|    |BBS'|    
───┼────┼────┼────┼────
 S'|    | bS'|    | ε  
───┼────┼────┼────┼────
 B |    |    | y  |    
```
#### Add Follow Set

Now it is time to added the follow:

*Note adding only happens when there is an ε in the first set*

```
   | a  | b  | y  | $  
───┼────┼────┼────┼────
 S |aBS'|    |BBS'|    
───┼────┼────┼────┼────
 S'| ε  | bS'| ε  | ε   <-- notice the ε
───┼────┼────┼────┼────
 B |    |    | y  |    
```

#### Lastly

All empty boxes are **ERROR** conditions

```
   | a  | b  | y  | $  
───┼────┼────┼────┼────
 S |aBS'| err|BBS'| err
───┼────┼────┼────┼────
 S'| ε  | bS'| ε  | ε   <-- notice the ε
───┼────┼────┼────┼────
 B | err|    | y  | err
```

## **Step Four** [Parser]

#### Create Stack

A stack will be used to keep track of what and where things are being parsed.

```
                        -== Stack ==-
┌──────────────────────────────────────────────────────────
|$
└──────────────────────────────────────────────────────────
bottom                                                  top
```

*Remember: when adding to the stack, it is reversed to keep the right order at the top*

#### Start Using The Stack

This is the time to start with some type of language (ie. abbyaba). Refer to the table when working with the stack.

```
                        -== Stack ==-                        -== Language ==-
┌──────────────────────────────────────────────────────────       aybbb$
|$S
└──────────────────────────────────────────────────────────
bottom                                                  top
```

```
┌──────────────────────────────────────────────────────────       aybbb$
|$S'Ba
└──────────────────────────────────────────────────────────
  `--> S replaced with aBS' because the current token in the language is "a"
```

```
┌──────────────────────────────────────────────────────────       _ybbb$
|$S'B
└──────────────────────────────────────────────────────────
      `--> "a" was deleted because it is a terminal and it matched the current token.
```

```
┌──────────────────────────────────────────────────────────       _ybbb$
|$S'y
└──────────────────────────────────────────────────────────
    `--> B replaced with y because the current token is "y" and in the row for B and column for y, the replacement is "y"
```

```
┌──────────────────────────────────────────────────────────       --bbb$
|$S'
└──────────────────────────────────────────────────────────
```

```
┌──────────────────────────────────────────────────────────       --bbb$
|$S'b
└──────────────────────────────────────────────────────────
  `--> S' replaced with bS', but it looks like we just added b
```

```
┌──────────────────────────────────────────────────────────       ---bb$
|$S'
└──────────────────────────────────────────────────────────
  `--> Notice, we are back at the same place we were before. Loop this until you reach the end of the language (match the $'s)
```

```
┌──────────────────────────────────────────────────────────       ---bb$
|$S'b
└──────────────────────────────────────────────────────────
```

```
┌──────────────────────────────────────────────────────────       ----b$
|$S'
└──────────────────────────────────────────────────────────
```

```
┌──────────────────────────────────────────────────────────       ----b$
|$S'b
└──────────────────────────────────────────────────────────
```

```
┌──────────────────────────────────────────────────────────       -----$
|$S'
└──────────────────────────────────────────────────────────
```

```
┌──────────────────────────────────────────────────────────       -----$
|$ε
└──────────────────────────────────────────────────────────
  `--> given that the next token in the language is the "$", then ε is used to replace S'. However, ε is an empty character, thus we have an empty space in the next iteration (can skip this step in the code)
```

```
┌──────────────────────────────────────────────────────────       -----$
|$
└──────────────────────────────────────────────────────────
  `--> now we compare the language with the stack, and we get a match for the "$", which means the code can print "ACCEPT" for the parser.
```
*Note: if the program never reached this state, it would need to "REJECT" the language. Assuming you did the above steps correctly.*
