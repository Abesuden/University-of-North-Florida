# Project 4

[![Progress](https://img.shields.io/badge/DocumentationProgress-2%25-1abc9c.svg)](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj4/README.md)

I do not claim this documentation is accurate yet. This is currently initial work and thoughts.

## Reference Code

```
// void funcitons
void funOne () {

    // init of vars
    int numOne;
    int numTwo;
    int numThree;
    int arrOne[5];
    
    // assignements
    numOne = 5;
    numTwo = numOne + 1;
    numOne = 0;
    int arrTwo[numOne]; // <------------------------------------------ ??????????
    numThree = arrTwo[0];
    numThree = arrTwo[0] = numTwo;
    numThree = arrTwo[0] + 1;
    numThree = arrTwo[0] = numTwo + 1;
    arrTwo[0] = numTwo;
    arrTwo[0] = numThree = numTwo;
    arrTwo[0] = numThree = numTwo + 1;
    arrOne[0] = arrOne[1] = arrOne[2] = arrOne[3] = arrOne[4] = numOne;
    arrOne[0] = arrOne[1] = arrOne[2] = arrOne[3] = arrOne[4] = arrTwo[0];
    arrOne[0] = arrOne[1] = arrOne[2] = arrOne[3] = arrOne[4] = arrTwo[0] + 1;


    /* does this make it past the parser <---------------------------- ??????????
    arrTwo[0] = numThree - 1 = numTwo;
    */

    // math
    numThree = 5 + 5;
    numThree = 5 + 5 * 2 / 3;
    numThree = 5 + numOne + 6 * arrOne[0] / 2;

}

void funTwo(int innerOne, int innerTwo) {

    // var assignments
    innerOne = innerOne + 5;
    innerTwo = innerOne;
    
    // fun calls
    funOne();

}

// return functions
int funThree() {

    // init vars
    int innerVarOne;
    int innerVarTwo;
    int innerVarThree;
    int innerVarFour;
    int innerReturnVar;

    // return
    return innerReturnVar;

}

int funFour (int innerThree, int innerFour) {

    // init vars
    int innerVarOne;
    int innerVarTwo;
    int innerReturnVar;

    // var assignment
    innerVarOne = innerVarTwo = 5;

    // math
    innerThree = innerVarOne + innerThree;
    innerThree = innerVarTwo - 1 + innerFour;
    innerReturnVar = innerThree + innerFour;


    // return
    return innerReturnVar + 1;
}

int funFive (int innerFive) {

    // init and assign temp var
    int tempVar;
    tempVar = funFour(5,4);     // type compare here

    // return math
    return innerFive + 6 / 4 - tempVar + 7 / tempVar;
    // return (innerFive + 6 / 4 - tempVar + 7 / tempVar); // <----------------------------------- ?????? ---- () allowed by parser?

}

// main method
int main (void) {

    // init of vars
    int returnedOne;
    int returnedTwo;
    int argOne;
    int argTwo;
    int arrInOne[1];
    int arrInTwo[1];

    // fun calls
    funOne();
    funTwo(argOne, argTwo);
    // returnedOne = funOne();                  // type compare here    <INT> vs <VOID>   <---- REJECT this line
    // returnedTwo = funTwo(argOne, argTwo);    // type compare here    <INT> vs <VOID>   <---- REJECT this line
    returnedOne = funThree();                   // type compare here    <INT> vs <INT>
    returnedTwo = funFour(argOne, argTwo);      // type compare here    <INT> vs <INT>
    returnedTwo = funFour(argOne, 4);           // type compare here    <INT> vs <INT>
    arrInOne[0] = funThree();                   // type compare here    <INT> vs <INT>
    arrInTwo[1] = funFour(argOne, argTwo);      // type compare here    <INT> vs <INT>
    arrInTwo[2] = funFour(2, 3);                // type compare here    <INT> vs <INT>

    // return
    return 0;
}
```

> Type comparisions only need to happen when storing a value that is returned from a function. This is because, we can only initilize variables of type `int`.