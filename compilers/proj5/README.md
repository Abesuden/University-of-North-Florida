# Project 5

You can see Dr. Eggens code examples [here](https://www.unf.edu/public/cop4620/ree/Projects/prj5)

## Example 1

```
struct inst {
    char op[6];
    char opnd1[6];
    char opnd2[6];
    char re[6];
    char re[6];
} code[100];

strncpy(code[0].op, "add"); // makes the opperation "add"
```

so we will build a two dimention array that looks like this:

```
1  func    main    void    0
2  alloc   4               x
3  alloc   4               y
4  alloc   4               z
5  alloc   4               m
6  mult    3       y       _t0   bpw = 6_ // this is the the while loop conditional
7  add     x       _t0     _t1
8  comp    _t1     5       _t2
9  BRLEQ   _t2             21    bpo = 9
10 bloc
11 div     m       z       _t3
12 add     y       _t3     _t4
13 assign  _t4             x
14 sub     x       y       _t5
15 mult    z       m       _t6
16 div     _t6     z       _t7
17 add     _t5     _t7     _t8
18 assign  _t8             m
19 end     block
20 BR                      6     val of bpw // BR = branch and is used to jump?
21 end     func    main          loc for bpo

```
> we are building quadruples and we do not need to print out the bpw or bpo.

We are saying we have a function, its name is main, has an parameter of void, and variable of 0

Reference this code for above example:

```
void main(void) {
    int x;
    int y;
    int z;
    int m;
    while(x + 3 * y > 5) {
        x = y + m / z;
        m = x - y + z * m / z;
    }
}
```

---

For the while loop, you will need to generate code to evaluate the while loop in situ. 

## Code example 2

The code:

```
int sub(int z) {
    if (x > y)
        return(z+z);
    else
        x = 5;
}
void main(void) {
    int x;
    int y;
    y = sub(x);
}
```

The quadruples:

```
1  func    sub     int     1
2  param                   z
3  alloc   4               z
5  compr   x       y       _t23
6  brle    _t23            10   bpe = 6 // branch jumps to line 10 (the if)
...
9  br                      11   bpo = 9 // branch jumps to line 11 (the else)
10 assgn           5       x    val for bpe
11 end     func    sub     val for bpo
12 func    main    void    0
...
18 end     func    main


```

## Example 3

The code:

```
void main(void) {
    int x[10];
    int y;
    y = (x[5] + 2) * y;
}
```

The quadruples:

```
1 func  main    void    0
2 alloc 40      x           // notice that thw size is 4 * the array size
3 alloc 4       y
4 disp  x       20      _t0 // need to calculate displacement off of x b/c array size?
5 add   _t0     2       _t1
6 mult  _t1     y       _t2
7 asign _t2             y
8 end   func    main
```

Or use this for integer constant vs index constant

```
1 func  main    void    0
2 alloc 40      x           // notice that thw size is 4 * the array size
3 alloc 4       y
4 mult  y       4       _t8
5 disp  x       _t8     _t0 
6 add   _t0     2       _t1
7 mult  _t1     y       _t2
8 asign _t2             y
9 end   func    main
```

## Example 4

The code:

```
void main(void) {
    int x;
    int y;
    int z;
    int m;
    if (x + x * y > 5 + y) {
        x = y + m / z;
        y = 88;
    }
    else {
        m = x - y + z * m / z;
    }
}
```

The quadruples:

```
1  func main    void    0
...
```

## Notes

 - The math will need to be expressed in the correct order
 - Assume all integers are 4 bytes big
 - bpw, bpo and bpe are set to the value of which line they are on in the array
 - you can find a demo python program [here](https://www.unf.edu/public/cop4620/ree/Examples/myparserdemo/justcodegen.py)
    * use the cod out* files with this demo in this directory [here](https://www.unf.edu/public/cop4620/ree/Examples/myparserdemo/)

 ## On Quiz

Quiz will be on Code Generation, also:

 - understand the values of the back patch variable