# LEX and YACC (Yet Another Compiler Compiler)

## **Step One** [Create Files]
Follow the steps below for the given C-- grammer from pages 501-502

#### Create .l file

*This file holds the regular expressions to recogonize the patterns from the .y file*

```
fileName.l
```

#### Create .y file

*This file holds the regular expressions to recogonize the patterns from the .y file*

```
fileName.y
```

Note: lexum is *main* and token is *ID*

## **Step Two** [Build out the files]

#### Lex

Use extended regular expression format, find a good reference website [here](https://regexr.com/) *or* watch these youtube videos, [part1](https://www.youtube.com/watch?v=7DG3kCDx53c) and [part2](https://www.youtube.com/watch?v=YTocEnDsMNw).


`Reference Eggen's world famous grammer from` [here](https://www.unf.edu/public/cop4620/ree/Examples/LEXYACC_sample/WorldFamousGram/)


#### Yacc

Find the given grammer [here](https://www.unf.edu/public/cop4620/ree/Projects/prj3) and use Eggen's reference example [here](https://www.unf.edu/public/cop4620/ree/Examples/LEXYACC_sample/WorldFamousGram/aa.y)

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

## **Step Three** [Build makefile]

create makefile or find Eggan's example [here](https://www.unf.edu/public/cop4620/ree/Examples/LEXYACC_sample/WorldFamousGram/makefile)

```
nano makefile
```

type something similar to the following:

```
postfix: lex.yy.c postfix.tab.c
        cc postfix.tab.c -o postfix

lex.yy.c: postfix.l
        flex postfix.l

postfix.tab.c   : postfix.y
        bison postfix.y
```

## **Step Four** [Make typescript file]



## **Final Step** [Turn in on osprey]

You will need to shar the files (compress)

```
sh 
```
