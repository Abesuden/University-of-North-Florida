# LEX and YACC (Yet Another Compiler Compiler)

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

### Yacc

Find the given grammer [here](https://www.unf.edu/public/cop4620/ree/Projects/prj3) and use Eggen's reference example [here](https://www.unf.edu/public/cop4620/ree/Examples/LEXYACC_sample/WorldFamousGram/aa.y)


*Given Grammer*

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

*Eggen's Grammer Reference*

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

*What it should look like when you are done* (don't be stupid... **DO NOT COPY!**)

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

### Lex

Using extended regular expression format, build out the lexical analyser. Find a good reference website [here](https://regexr.com/) **or** watch these youtube videos, [part1](https://www.youtube.com/watch?v=7DG3kCDx53c) and [part2](https://www.youtube.com/watch?v=YTocEnDsMNw).

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

Now, lets find what regular expressions we want to look for. Lets reference the earlier CFG and find the desired tokens (**I have bolded them**). To understand, what qualifies as a token, we need to know the following:
 * keywords in SQL are all UPPERCASE
 * what are the special characters in the CFG (*i.e. '(', '\[', '{', ect.*)
 * are there identifiers
 
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

## **Step Four** [Make typescript file]

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
