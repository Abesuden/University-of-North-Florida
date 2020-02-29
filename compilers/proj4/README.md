# Project 4

[![Progress](https://img.shields.io/badge/DocumentationProgress-2%25-1abc9c.svg)](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj4/README.md)

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
    

    // return
}

int funFour (int innerThree, int innerFour) {

    // init vars


    // return
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
    returnedOne = funThree();
    returnedTwo = funFour(argOne, argTwo);
    arrInOne[0] = funThree();
    arrInTwo[0] = funFour(argOne, argTwo);


    // return
    return 0;
}
```