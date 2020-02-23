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

#### Lex

Use extended regular expression format, find a good reference website [here](https://regexr.com/) *or* watch these youtube videos, [part1](https://www.youtube.com/watch?v=7DG3kCDx53c) and [part2](https://www.youtube.com/watch?v=YTocEnDsMNw).


`Reference Eggen's world famous grammer from` [here](https://www.unf.edu/public/cop4620/ree/Examples/LEXYACC_sample/WorldFamousGram/)


#### Yacc

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

## **Step Four** [Make typescript file]

## **Step Five** [Create documentation]

Eggen expects some form of documentation that describes what is being turned in

```
nano doc
```

*inside, make it look like a man page*

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

You will need to shar the files (compress)

```
shar fileName.l fileName.y typescript doc 
```
