# LEX and YACC (Yet Another Compiler Compiler)

---

## Table Of Contents

* [Step One [Create Files]](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#step-one-create-files)
	* [Create .l file](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#create-l-file)
	* [Create .y file](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#create-y-file)
* [Step Two [Build out the files]](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#step-two-build-out-the-files)
	* [YACC](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#yacc)
		* [Given Grammer](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#given-grammer)
		* [Eggen's Grammer](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#eggens-grammer-reference)
		* [End Result](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj3#what-it-should-look-like-when-you-are-done-dont-be-stupid-do-not-copy)
	* [LEX](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#lex)
		* [Lets Begin](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#lets-begin)
		* [Part One](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#part-one)
		* [Part Two](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#part-two)
		* [Part Three](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#part-three)
		* [Part Four](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#part-four)
		* [Part Five](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#part-five)
* [Step Three [Build makefile]](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#step-three-build-makefile)
* [Step Four [Make typescript file]](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#step-four-make-typescript-file)
* [Step Five [Create documentation]](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#step-five-create-documentation)
* [Final Step [Turn in on osprey]](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#final-step-turn-in-on-osprey)

---

## **Step One** [Create Files]
Follow the steps below for project 3 found [here](https://www.unf.edu/public/cop4620/ree/Projects/prj3)

#### Create .l file

*This file holds the regular expressions used to recogonize the patterns from the .y file*

```
fileName.l
```

#### Create .y file

*This file contains the context free grammer (CFG)*

```
fileName.y
```

Note: The term "lexum" represents the grammer such as *varName,* and the term token represents the catagory such as *ID*

## **Step Two** [Build out the files]

### YACC

Find the given grammer [here](https://www.unf.edu/public/cop4620/ree/Projects/prj3) and use Eggen's reference example [here](https://www.unf.edu/public/cop4620/ree/Examples/LEXYACC_sample/WorldFamousGram/aa.y). Watch an example with this YouTube video [here](https://www.youtube.com/watch?v=ueZ9LX1xItQ).


#### *Given Grammer*

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

#### *Eggen's Grammer Reference*

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
                                                                        };
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

### LEX

Using extended **regular expression** format, build out the lexical analyser. Find a good reference website [here](https://regexr.com/) **or** watch these youtube videos, [part1](https://www.youtube.com/watch?v=7DG3kCDx53c) and [part2](https://www.youtube.com/watch?v=YTocEnDsMNw). You can also find a good video about **FLEX** [here](https://www.youtube.com/watch?v=pu0hX5lftQU).

#### Lets begin

Reference Eggen's world famous grammer [here](https://www.unf.edu/public/cop4620/ree/Examples/LEXYACC_sample/WorldFamousGram/aa.l)

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

#### Part Four

Understanding the sections is key to making a functioning LEX. Know that there are three sections, each split by `%%`. To get more information, watch this YouTube video [here](https://www.youtube.com/watch?v=pu0hX5lftQU).

```
	-== Section One ==-
%{
// C language code goes here
#include "fileName.tab.h"
extern int yylval;
void someFunction(); // funciton header
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

#### Part Five

Now that the .l file is done, we need to update section one of the .y file. Since we are passing tokens to the .y file, section one needs to reflect those tokens being passed. Find a reference YouTube video [here](https://www.youtube.com/watch?v=ueZ9LX1xItQ).

```
%{
#include <stdio.h>
#include <stdlib.h>
extern yylex();
extern yytext[];
extern FILE *yyin;
%}

%start start
%token NUM COM BRK DEL WHT RENAME AS WHERE

%%
start                       : expression                                {
                                                                        };
...
```
*Find a reference to what the full .y file should look like in the YACC section [here](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#yacc)*

> Note: this is based off of [Part Four](https://github.com/Abesuden/University-of-North-Florida/blob/master/compilers/proj3/README.md#part-four), which means there are more tokens in the actual project.

## **Step Three** [Build makefile]

create makefile or find Eggen's example [here](https://www.unf.edu/public/cop4620/ree/Examples/LEXYACC_sample/WorldFamousGram/makefile)

```
nano makefile
```

Type something similar to the following:

```
postfix: lex.yy.c postfix.tab.c
        cc postfix.tab.c -o postfix

lex.yy.c: postfix.l
        flex postfix.l

postfix.tab.c   : postfix.y
        bison postfix.y
```


## **Step Four** [Make typescript file]

A typescript file is used to log what is printed to the terminal. In order to start the typescript, you must be on a linux machine and use the following command:

```
script
```

You will now see a typescript file created in yout current directory. The next step is to execute the programs for this project. In order to end the typescript, use the following command:

```
exit
```


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

## **Final Step** [Turn in on osprey]

You will need to shar the files to compress them

```
shar makefile fileName.l fileName.y typescript doc >> outFile
```

Turn the compressed file into Eggen

```
turnin outfl ree4620_3   // final step to turn in project
turnin -c ree4620_3 	 // used to check and make sure it was turned in
ls -l outFile  	       	 // see that the file size turned in agrees with the local file size
```
