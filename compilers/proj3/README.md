# LEX and YACC (Yet Another Compiler Compiler)

---

## Table Of Contents

* [Step One [Create Files]](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#step-one-create-files)
	* [Create .l file](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#create-l-file)
	* [Create .y file](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#create-y-file)
	* [Create .tab.h file](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#create-tabh-file)
* [Step Two [Build out the files]](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#step-two-build-out-the-files)
	* [YACC](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#yacc)
		* [Given grammar](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#given-grammar)
		* [Eggen's grammar](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#eggens-grammar-reference)
		* [End Result](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#what-it-should-look-like-when-you-are-done-dont-be-stupid-do-not-copy)
	* [LEX](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#lex)
		* [Lets Begin](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#lets-begin)
		* [Part One](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#part-one)
		* [Part Two](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#part-two)
		* [Part Three](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#part-three)
		* [Part Four](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#part-four)
		* [Part Five](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#part-five)
			* [Section One Update](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#section-one-update)
			* [Section Two Update](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#section-two-update)
	* [Build .tab.h file](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#build-tabh-file)
* [Step Three [Build makefile]](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#step-three-build-makefile)
* [Step Four [Make typescript file]](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#step-four-make-typescript-file)
* [Step Five [Create documentation]](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#step-five-create-documentation)
* [Final Step [Turn in on osprey]](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#final-step-turn-in-on-osprey)
* [Troubleshooting](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#trouble-shooting)
	* [make issue [alpha]](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#make-issue-alpha)
	* [make issue [beta]](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#make-issue-beta)
	* [make issue [theta]](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#make-issue-thetas)
	* [Always REJECTing](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#always-rejecting)
* [Test Cases](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#test-cases)
---

## **Step One** [Create Files]
Follow the steps below for project 3 found [here](https://www.unf.edu/public/cop4620/ree/Projects/prj3)

#### Create .l file

*This file holds the regular expressions used to recognize the patterns from the .y file*

```
fileName.l
```

#### Create .y file

*This file contains the context free grammar (CFG)*

```
fileName.y
```
Note: The term "lexum" represents the grammar such as *varName,* and the term token represents the category such as *ID*

#### Create .tab.h file

*This file is used to put the tokens into a symbol table, so that the GDB and other debuggers know about them.*

```
fileName.tab.h
```

[**T^C**](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#lex-and-yacc-yet-another-compiler-compiler)

## **Step Two** [Build out the files]

### YACC

Find the given grammar [here](https://www.unf.edu/public/cop4620/ree/Projects/prj3) and use Eggen's reference example [here](https://www.unf.edu/public/cop4620/ree/Examples/LEXYACC_sample/WorldFamousGram/aa.y). Watch an example with this YouTube video [here](https://www.YouTube.com/watch?v=ueZ9LX1xItQ).

#### *Given grammar*

```
start 
	::= expression

expression
	::= one-relation-expression | two-relation-expression

one-relation-expression
	::= renaming | restriction | projection

renaming 
	::= term RENAME attribute AS attribute

term 
	::= relation | ( expression )

restriction
	::= term WHERE comparison

projection 
	::= term | term [ attribute-commalist ]

attribute-commalist
	::= attribute | attribute , attribute-commalist

two-relation-expression
	::= projection binary-operation expression

binary-operation
	::= UNION | INTERSECT | MINUS | TIMES | JOIN | DIVIDEBY

comparison
	::= attribute compare number

compare
	::= < | > | <= | >= | = | <>

number
	::= val | val number

val 
	::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9

attribute 
	::= CNO | CITY | CNAME | SNO | PNO | TQTY | 
		  SNAME | QUOTA | PNAME | COST | AVQTY |
		  S# | STATUS | P# | COLOR | WEIGHT | QTY

relation 
	::= S | P | SP | PRDCT | CUST | ORDERS
```

[**T^C**](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#lex-and-yacc-yet-another-compiler-compiler)

#### *Eggen's grammar Reference*

```
%{
#include <stdio.h>
#include <stdlib.h>
extern yylex();
extern yytext[];
extern FILE *yyin;
%}
%start Program
%token Id Lt Pl St Mt Di Eq Sm Lp Rp 
%%
Program    : Expression Sm          { 
                                     printf("\nACCEPT\n");
                                    };
Expression : Expression Pl Term     {
                                    };
           | Expression St Term     {
                                    };
           | Term                   { 
                                    };
Term       : Term Mt Factor         {
                                    };
           | Term Di Factor         {
                                    };
           | Factor                 {
                                    };
Factor     : Lp Expression Rp       {
                                    };
           | Id                     {
                                    };
%%
int main(int argc, char *argv[])
{
   yyin = fopen(argv[1], "r");
   if (!yyin)
   {
      printf("no file\n");
      exit(0);
   }
   yyparse();
}
yyerror()
{
   printf("\nREJECT\n");
//   printf("error from yyerror\n");
   exit(0);
}
yywrap()
{
   printf("in yywarp\n");
   exit(0);
}
```

[**T^C**](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#lex-and-yacc-yet-another-compiler-compiler)

#### *What it should look like when you are done* (don't be stupid... **DO NOT COPY!**)

```
%{
#include <stdio.h>
#include <stdlib.h>
extern yylex();
extern yytext[];
extern FILE *yyin;
%}
%start start
%token Id Lt Pl St Mt Di Eq Sm Lp Rp 
%%
start                       : expression                                {
							printf("ACCEPT\n");                         };
expression                  : one-relation-expression                   {
                                                                        };
                            | two-relation-expression                   {
                                                                        };
one-relation-expression     : renaming                                  {
                                                                        };
                            | restriction                               {
                                                                        };
                            | projection                                {
                                                                        };
renaming                    : term RENAME attribute AS attribute        {
                                                                        };
term                        : relation                                  {
                                                                        };
                            | ( expression )                            {
                                                                        };
restriction                 : term WHERE comparison                     {
                                                                        };
projection                  : term                                      {
                                                                        };
                            | term [ attribute-commalist ]              {
                                                                        };
attribute-commalist         : attribute                                 {
                                                                        };
                            | attribute , attribute-commalist           {
                                                                        };
two-relation-expression     : projection binary-operation expression    {
                                                                        };
binary-operation            : UNION                                     {
                                                                        };
                            | INTERSECT                                 {
                                                                        };
                            | MINUS                                     {
                                                                        };
                            | TIMES                                     {
                                                                        };
                            | JOIN                                      {
                                                                        };
                            | DIVIDEBY                                  {
                                                                        };
comparison                  : attribute compare number                  {
                                                                        };
compare                     : <                                         {
                                                                        };
                            | >                                         {
                                                                        };
                            | <=                                        {
                                                                        };
                            | >=                                        {
                                                                        };
                            | =                                         {
                                                                        };
                            | <>                                        {
                                                                        };
number                      : val                                       {
                                                                        };
                            | val number                                {
                                                                        };
val                         : 0                                         {
                                                                        };
                            | 1                                         {
                                                                        };
                            | 2                                         {
                                                                        };
                            | 3                                         {
                                                                        };
                            | 4                                         {
                                                                        };
                            | 5                                         {
                                                                        };
                            | 6                                         {
                                                                        };
                            | 7                                         {
                                                                        };
                            | 8                                         {
                                                                        };
                            | 9                                         {
                                                                        };
attribute                   : CNO                                       {
                                                                        };
                            | CITY                                      {
                                                                        };
                            | CNAME                                     {
                                                                        };
                            | SNO                                       {
                                                                        };
                            | PNO                                       {
                                                                        };
                            | TQTY                                      {
                                                                        };
                            | SNAME                                     {
                                                                        };
                            | QUOTA                                     {
                                                                        };
                            | PNAME                                     {
                                                                        };
                            | COST                                      {
                                                                        };
                            | AVQTY                                     {
                                                                        };
                            | S#                                        {
                                                                        };
                            | STATUS                                    {
                                                                        };
                            | P#                                        {
                                                                        };
                            | COLOR                                     {
                                                                        };
                            | WEIGHT                                    {
                                                                        };
                            | QTY                                       {
                                                                        };
relation                    : S                                         {
                                                                        };
                            | P                                         {
                                                                        };
                            | SP                                        {
                                                                        };
                            | PRDCT                                     {
                                                                        };
                            | CUST                                      {
                                                                        };
                            | ORDERS                                    {
                                                                        };
%%
int main(int argc, char *argv[])
{
   yyin = fopen(argv[1], "r");
   if (!yyin)
   {
      printf("no file\n");
      exit(0);
   }
   yyparse();
}
yyerror()
{
   printf("\nREJECT\n");
//   printf("error from yyerror\n");
   exit(0);
}
yywrap()
{
   printf("in yywarp\n");
   exit(0);
}
```

[**T^C**](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#lex-and-yacc-yet-another-compiler-compiler)

### LEX

Using extended **regular expression** format, build out the lexical analyzer. Find a good reference website [here](https://regexr.com/) **or** watch these YouTube videos, [part1](https://www.YouTube.com/watch?v=7DG3kCDx53c) and [part2](https://www.YouTube.com/watch?v=YTocEnDsMNw). You can also find a good video about **FLEX** [here](https://www.YouTube.com/watch?v=pu0hX5lftQU).

#### Lets begin

Reference Eggen's world famous grammar [here](https://www.unf.edu/public/cop4620/ree/Examples/LEXYACC_sample/WorldFamousGram/aa.l)

```
%{
#include "aa.tab.h"
extern int yylval;
%}
Delimiter    [ \t]
WhiteSpace   {Delimiter}+
Letter       [A-Za-z]
Digit        [0-9]
%%
{WhiteSpace}                  ;
{Letter}({Letter}|{Digit})*   return(Id);
{Digit}+                      {
                              //printf("%s in lex\n",yytext);
			      yylval = atoi(yytext);
                              /* return(yytext); */
                               return(Lt);   
                              }
"+"                           { //printf("%s in lex \n",yytext);
                                return(Pl);
                              }
"-"                           return(St);
"*"                           return(Mt);
"/"                           return(Di);
"="                           return(Eq);
";"                           return(Sm);
"("                           return(Lp);
")"                           return(Rp);
\n                            return(0);
%%
```

[**T^C**](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#lex-and-yacc-yet-another-compiler-compiler)

#### Part One

Now, lets find what regular expressions we want LEX to look for. Lets reference the [earlier CFG](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#yacc) and find the desired tokens (**I have bolded them so that they stand out more**). To understand, what qualifies as a token, we need to know the following:
 * keywords in SQL are all UPPERCASE
 * special characters in the CFG (*i.e. '(', '\[', '{', ect.*)
 * identifiers such as numbers

---

start 
>   ::= expression

expression
>   ::= one-relation-expression | two-relation-expression

one-relation-expression
>   ::= renaming | restriction | projection

renaming 
>   ::= term **RENAME** attribute **AS** attribute

term 
>   ::= relation | ***(*** expression ***)***

restriction
>   ::= term **WHERE** comparison

projection 
>   ::= term | term ***[*** attribute-commalist ***]***

attribute-commalist
>   ::= attribute | attribute **,** attribute-commalist

two-relation-expression
>   ::= projection binary-operation expression

binary-operation
>   ::= **UNION** | **INTERSECT** | **MINUS** | **TIMES** | **JOIN** | **DIVIDEBY**

comparison
>   ::= attribute compare number

compare
>   ::= ***<*** | ***>*** | ***<=*** | ***>=*** | ***=*** | ***<>***

number
>   ::= val | val number

val 
>   ::= **0** | **1** | **2** | **3** | **4** | **5** | **6** | **7** | **8** | **9**

attribute 
>   ::= **CNO** | **CITY** | **CNAME** | **SNO** | **PNO** | **TQTY** | 
>   **SNAME** | **QUOTA** | **PNAME** | **COST** | **AVQTY** |
>   **S#** | **STATUS** | **P#** | **COLOR** | **WEIGHT** | **QTY**

relation 
>   ::= **S** | **P** | **SP** | **PRDCT** | **CUST** | **ORDERS**

---

[**T^C**](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#lex-and-yacc-yet-another-compiler-compiler)

#### Part Two

So we find that we need to generate regular expressions to find these tokens:

 * RENAME
 * AS
 * (
 * )
 * WHERE
 * [
 * ]
 * UNION
 * INTERSECTION
 * MINUS
 * TIMES
 * JOIN
 * DIVIDEBY
 * <
 * \>
 * <=
 * \>=
 * =
 * <>
 * 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
 * CNO
 * CITY
 * CNAME
 * SNO
 * PNO
 * TQTY
 * SNAME
 * QUOTA
 * PNAME
 * COST
 * AVQTY
 * S#
 * STATUS
 * P#
 * COLOR
 * WEIGHT
 * QTY
 * S
 * P
 * SP
 * PRDCT
 * CUST
 * ORDERS

[**T^C**](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#lex-and-yacc-yet-another-compiler-compiler)

#### Part Three

Regular expressions do not need to be made for each and every token, you will learn why later. Just know for now, we can make as many regular expressions as we want but we do not need to make regular expressions for all. These are some examples of useful regular expressions:

```
Digit        	[0-9]
Compare 	 	[<>|<=|>=|<|>|=]
Brackets	 	[\(|\)|,|\[|\]]
Delimiter    	[ \t]
WhiteSpace   	{Delimiter}+
```

> Notice how the RE for `Delimiter` finds a single white space, then `Delimiter` is pulled in as a "variable" `(i.e. {Delimiter})` for the RE `WhiteSpace`. The `"+"` sign is used to signify any repeating sequence of the RE `Delimiter` is considered `WhiteSpace`. The "variable" is important to understand because this concept will be used later.

[**T^C**](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#lex-and-yacc-yet-another-compiler-compiler)

#### Part Four

Understanding the sections is key to making a functioning LEX. Know that there are three sections, each split by `%%`. To get more information, watch this YouTube video [here](https://www.YouTube.com/watch?v=pu0hX5lftQU).

```
	-== Section One ==-
%{
// C language code goes here
#include "fileName.tab.h"
extern int yylval;
void someFunction(); // function header
int numVar; // there is no point to this variable, it is just an example
%}

// Regular Expressions go here
Digit        	[0-9]
Compare 	 	[<>|<=|>=|<|>|=]
Brackets	 	[\(|\)|,|\[|\]]
Delimiter    	[ \t]
WhiteSpace   	{Delimiter}+

%% <--- this is the section delimiter

	-== Section Two ==-

// return the tokens that will be passed
{Digit}			{return(NUM);}
 `-----`------------------------> notice the RE "variable" reference
{Compare}		{return(COM);}
{Brackets}		{return(BRK);}
{Delimiter}		{return(DEL);}
{WhiteSpace}	{return(WHT);}
"RENAME" 		{return(RENAME);}
"AS" 			{return(AS);}
"WHERE" 		{return(WHERE);}
.               {someFunctionHeader();} 

%% <--- this is the section delimiter

	-== Section Three ==-
	
// more C language code goes here
void someFunctionHeader() {
	printf("Reject or not to reject, that is the question.\n");
}
numVar = 5; // there is no point to this variable, it is just an example
```

> Notice how the .l file is structured above. In section two, there are many ways to `return` the `tokens`. Choose which ever works best for you. This is in no way the complete .l file, but this is an accurate structure. If you fill in the rest of the REs and the CFGs, then you should have a working .l file to pass to LEX.

[**T^C**](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#lex-and-yacc-yet-another-compiler-compiler)

#### Part Five

Now that the .l file is done, we need to update section one and two of the .y file. Since we are passing tokens to the .y file, section one needs to reflect those tokens being passed. Section two needs the tokens to be updated. Find a reference YouTube video [here](https://www.YouTube.com/watch?v=ueZ9LX1xItQ).

##### Section One Update

```
%{
#include <stdio.h>
#include <stdlib.h>
extern yylex();
extern yytext[];
extern FILE *yyin;
%}

%start start
%token NUM COM BRK DEL WHT RENAME AS WHERE <---- update this line

%%
start                       : expression                                {
                                                                        };
...
```
*Find a reference to what the full .y file should look like in the YACC section [here](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#yacc)*

> Note: this is based off of [Part Four](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#part-four), which means there are more tokens in the actual project.

##### Section Two Update

`old section two`

```
...
term                        : relation                                  {
                                                                        };
                            | ( expression )		                    {
                                                                        };
restriction                 : term WHERE comparison                     {
                                                                        };
projection                  : term                                      {
                                                                        };
                            | term [ attribute-commalist ]              {
...
```

`revised section two`

```
...
term                        : relation                                  {
                                                                        };
                            | LPAR expression RPAR                      {
                                                                        };
restriction                 : term WHERE comparison                     {
                                                                        };
projection                  : term                                      {
                                                                        };
                            | term LSQR attribute-commalist RSQR        {
...
```

> Notice that we replace the tokens `'(', ')', '[', ']'` with the RE name. Also, it is good to understand that tokens like `WHERE` are the actual tokens that we passed from the .l file into this .y file via the `%token` assignments we did in [Section One Update](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#section-one-update). 

*Yes, SQL is typically all uppercase but that is just a coincidence in this project.*

[**T^C**](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#lex-and-yacc-yet-another-compiler-compiler)

### Build .tab.h file

This file is used to put the tokens into the symbol table, so that GDB and other debuggers know about them. You can find Eggen's file reference [here](https://www.unf.edu/public/cop4620/ree/Examples/LEXYACC_sample/WorldFamousGram/aa.tab.h). We only care about changing the tokens to look like the following:

```
/* Tokens.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
   /* Put the tokens into the symbol table, so that GDB and other debuggers
      know about them.  */
   enum yytokentype {
       WHITESPACE = 258,
       LPAR 	  = 259,
       RPAR 	  = 260,
       LSQR 	  = 261,
       RSQR 	  = 262,
       LRAB 	  = 263,
       ...
       QTY    	  = 296,
       SP     	  = 297,
       PRDCT  	  = 298,
       CUST   	  = 299,
       ORDERS 	  = 300,
       S          = 301,
       P          = 302,
       DELIMITER  = 303   <---- notice there is no comma on last number
   };
#endif

#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
typedef int YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define yystype YYSTYPE /* obsolescent; will be withdrawn */
# define YYSTYPE_IS_DECLARED 1
#endif

extern YYSTYPE yylval;
```

[**T^C**](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#lex-and-yacc-yet-another-compiler-compiler)

## **Step Three** [Build makefile]

create makefile or find Eggen's example [here](https://www.unf.edu/public/cop4620/ree/Examples/LEXYACC_sample/WorldFamousGram/makefile)

```
nano makefile
```

Type something similar to the following:

```
fileName:  fileName.tab.o lex.yy.o 
	cc -o fileName lex.yy.o fileName.tab.o 

fileName.tab.o: fileName.tab.c
	cc -c fileName.tab.c

fileName.tab.c: fileName.y
	bison -d fileName.y

lex.yy.o: lex.yy.c fileName.tab.h
	cc -c lex.yy.c

lex.yy.c: fileName.l fileName.tab.c
	flex fileName.l
```

[**T^C**](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#lex-and-yacc-yet-another-compiler-compiler)

## **Step Four** [Make typescript file]

A typescript file is used to log what is printed to the terminal. In order to start the typescript, you must be on a Linux machine and use the following command:

```
script
```

You will now see a typescript file created in your current directory. The next step is to execute the programs for this project. In order to end the typescript, use the following command:

```
exit
```

[**T^C**](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#lex-and-yacc-yet-another-compiler-compiler)

## **Step Five** [Create documentation]

Eggen expects some form of documentation that describes what is being turned in

```
nano doc
```

*Make the documentation look like a man page*

```
 Project 3

Command Name
============
        p3 [fileName]


Description
===========
        The quick brown fox jumped over the sleeping dog...


How To Use
==========
        To invoke blah blah blah...


Purpose
=======
        The purpose is...


Input Files Expected
====================
        The command line argument expects a file as the first argument ("p3 fileName")


Output Created
==============
	Output will be printed to the screen...

Author
======
        firstName lastName [n00000000]
```

[**T^C**](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#lex-and-yacc-yet-another-compiler-compiler)

## **Final Step** [Turn in on osprey]

You will need to shar the files to compress them

```
shar makefile fileName.l fileName.y typescript doc > outFile
```

Turn the compressed file into Eggen

```
turnin outfl ree4620_3   // final step to turn in project
turnin -c ree4620_3 	 // used to check and make sure it was turned in
ls -l outFile  	       	 // see that the file size turned in agrees with the local file size
```

[**T^C**](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#lex-and-yacc-yet-another-compiler-compiler)

## **Troubleshooting**

---

#### *make issue [alpha]*

When using the `make` command, this is what my terminal spit out:

```
[n00850421@osprey proj3]$ make
bison -d p3.y
p3.y:17.34: invalid character: `-'
p3.y:17.43: invalid character: `-'
p3.y:19.34: invalid character: `-'
p3.y:19.43: invalid character: `-'
p3.y:21.1-3: syntax error, unexpected identifier
p3.y:21.4: invalid character: `-'
p3.y:21.13: invalid character: `-'
p3.y:23.29: syntax error, unexpected |
p3.y:25.29: syntax error, unexpected |
p3.y:37.50: invalid character: `-'
p3.y:39.1-9: syntax error, unexpected identifier
p3.y:39.10: invalid character: `-'
p3.y:41.29: syntax error, unexpected |
p3.y:41.56: invalid character: `-'
p3.y:43.1-3: syntax error, unexpected identifier
p3.y:43.4: invalid character: `-'
p3.y:43.13: invalid character: `-'
p3.y:43.48: invalid character: `-'
p3.y:45.1-6: syntax error, unexpected identifier
p3.y:45.7: invalid character: `-'
p3.y:47.29: syntax error, unexpected |
p3.y:49.29: syntax error, unexpected |
p3.y:51.29: syntax error, unexpected |
p3.y:53.29: syntax error, unexpected |
p3.y:55.29: syntax error, unexpected |
make: *** [pull.tab.c] Error 1
```

This is the place in the code it was refereeing to in my p3.y file:

```
%%
start                       : expression                                {
                            printf("\nACCEPT\n");
                                                                        };
expression                  : one-relation-expression                   {
								 ^--here--^	
								 	  `--> the issue is the '-' character is not accepted
                                                                        };
                            | two-relation-expression                   {
                                                                        };
```

> To resolve the issue, the '-' character needed to be removed. This is the exact grammar that was given to us. Therefor, many people may have this issue.

My fix:

```
%%
start                       : expression                                {
                            printf("\nACCEPT\n");
                                                                        };
expression                  : oneRelationExpression                     {
                                                                        };
                            | twoRelationExpression                     {
                                                                        };
```

---

#### *make issue [beta]*

When using the `make` command, this is what my terminal spit out:

```
bison -d p3.y
cc -c pull.tab.c
cc: pull.tab.c: No such file or directory
cc: no input files
make: *** [pull.tab.o] Error 1
```

> I had to copy Eggen's aa.tab.c file ([here](https://www.unf.edu/public/cop4620/ree/Examples/LEXYACC_sample/WorldFamousGram/aa.tab.c)) and modify it to match my tokens like in this step [here](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#build-tabh-file). I also had to find all references to `aa.tab.c` using `ctrl + f`, and replace all to my `fileName.tab.c`. It resolved the issue and I was able to get passed the `.y` file errors.

---

#### *make issue [theta]*

When using the `make` command, this is what my terminal spit out:

```
cc -c pull.tab.c
flex p3.l
p3.l:31: warning, rule cannot be matched
p3.l:32: warning, rule cannot be matched
p3.l:33: warning, rule cannot be matched
p3.l:34: warning, rule cannot be matched
cc -c lex.yy.c
cc -o p3 lex.yy.o pull.tab.o
```

This is in my `.l` file where my RE are defined:

```
	-== Section One ==-
...
lequal          [<=]
gequal          [>=]
lthen           [<]
gthen           [>]
equal           [=]
comma			[,]
...

	-== Section Two ==-
...
{lequal}            {return(LEQUAL);}
{gequal}            {return(GEQUAL);}
{lthen}             {return(LTHEN);}
{gthen}             {return(GTHEN);}
{equal}             {return(EQUAL);}
{comma}             {return(COMMA);}
```

This is the correction I made:

```
	-== Section One ==-
...
lequal          "<="
gequal          ">="
lthen           "<"
gthen           ">"
equal           "="
comma           ","
...

	-== Section Two ==-
...
{lequal}            {return(LEQUAL);}
{gequal}            {return(GEQUAL);}
{lthen}             {return(LTHEN);}
{gthen}             {return(GTHEN);}
{equal}             {return(EQUAL);}
{comma}             {return(COMMA);}
...
```

> I found out that the way I look for RE is not correct. Instead of `[]`, I needed to use `""`.

#### *Always REJECTing*

I had the issue of my project always rejecting. The reason I found was because I was passing the RE for `delimiter` and `whitespace`, such as:

```
...
%%
{delimiter}         {return(DELIMITER);}	<---.
{whitespace}        {return(WHITESPACE);}   <----`-----remove both these token passing lines
{num}               {return(NUM);}
...
```

> If you have these issues, remove the lines with the REs for `delimiter` and `whitespace` from your section two in your `.y` file. This actually fixed my p3 executable.


[**T^C**](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#lex-and-yacc-yet-another-compiler-compiler)

---

## **Test Cases**

I do not currently have any test cases for this project but [@jonathan-lemos](https://github.com/jonathan-lemos) has some good ones [here](https://github.com/jonathan-lemos/cm-test-cases/tree/master/lex_yacc).