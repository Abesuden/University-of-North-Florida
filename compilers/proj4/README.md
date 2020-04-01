# Project 4

[![Progress](https://img.shields.io/badge/DocumentationProgress-2%25-1abc9c.svg)](https://github.com/Abesuden/University-of-North-Florida/tree/master/compilers/proj4/README.md)

I do not claim this documentation is accurate yet. This is currently initial work and thoughts.

## Reference Code

```
void funOne ( ) {
int numOne ;
int numTwo ;
int numThree ;
1 + 1 ;
int position ;
int arrOne [ 5 ] ;
int arrTwo [ 5 ] ;
numOne = 5 ;
numTwo = numOne + 1 ;
numOne = 0 ;
position = 0 ;
numThree = arrTwo [ 0 ] ;
numThree = arrTwo [ 0 ] = numTwo ;
numThree = arrTwo [ 0 ] + 1 ;
numThree = arrTwo [ 0 ] = numTwo + 1 ;
arrTwo [ 0 ] = numTwo ;
arrTwo [ 0 ] = numThree = numTwo ;
arrTwo [ 0 ] = numThree = numTwo + 14 ;
arrOne [ 0 ] = arrOne [ 1 ] = arrOne [ 2 ] = arrOne [ 3 ] = arrOne [ 4 ] = numOne ;
arrOne [ 0 ] = arrOne [ 1 ] = arrOne [ 2 ] = arrOne [ 3 ] = arrOne [ 4 ] = arrTwo [ 0 ] ;
arrOne [ 0 ] = arrOne [ 1 ] = arrOne [ 2 ] = arrOne [ 3 ] = arrOne [ 4 ] = arrTwo [ 0 ] + 1 ;
1 + 1 ;
numThree + numThree ;
numThree = 5 + 5 ;
numThree = 5 + 5 * 2 / 3 ;
numThree = 5 + numOne + 6 * arrOne [ 0 ] / 2 ;

}
void funTwo ( int innerOne , int innerTwo ) {
innerOne = innerOne + 5 ;
innerTwo = innerOne ;
funOne ( ) ;

}
void funSix ( ) {

}
int funThree ( ) {
int innerVarOne ;
int innerVarTwo ;
int innerVarThree ;
int innerVarFour ;
int innerReturnVar ;
{
int innerVarThree ;
}
return innerReturnVar ;

}
int funFour ( int innerThree , int innerFour ) {
int innerVarOne ;
int innerVarTwo ;
int innerReturnVar ;
innerVarOne = innerVarTwo = 5 ;
innerThree = innerVarOne + innerThree ;
innerThree = innerVarTwo - 1 + innerFour ;
innerReturnVar = innerThree + innerFour ;
return innerReturnVar + 1 ;

}
int funFive ( int innerFive ) {
int tempVar ;
tempVar = funFour ( 5 , 4 ) ;
return innerFive + 6 / 4 - tempVar + 7 / tempVar ;

}
int main ( void ) {
int returnedOne ;
int returnedTwo ;
int argOne ;
int argTwo ;
int arrInOne [ 1 ] ;
int arrInTwo [ 1 ] ;
funOne ( ) ;
funTwo ( argOne , argTwo ) ;

returnedOne = funThree ( ) ;
returnedTwo = funFour ( argOne , argTwo ) ;
returnedTwo = funFour ( argOne , 4 ) ;
arrInOne [ 0 ] = funThree ( ) ;
arrInTwo [ 1 ] = funFour ( argOne , argTwo ) ;
arrInTwo [ 2 ] = funFour ( 2 , 3 ) ;
{
int localScope ;
localScope = 8 ;
localScope = returnedOne + returnedTwo ;
localScope = 5 + arrInOne [ 0 ] ;

}
while ( 3 < 5 ) {
int localScope ;
localScope = 8 ;
localScope = returnedOne + returnedTwo ;
localScope = 5 + arrInOne [ 0 ] ;

}
if ( 7 == 9 ) {
int localScope ;
localScope = 8 ;
localScope = returnedOne + returnedTwo ;
localScope = 5 + arrInOne [ 0 ] ;

}
else {
int localScope ;
localScope = 8 ;
localScope = returnedOne + returnedTwo ;
localScope = 5 + arrInOne [ 0 ] ;

}
if ( 1 ) {
int localScope ;
localScope = 8 ;
localScope = returnedOne + returnedTwo ;
localScope = 5 + arrInOne [ 0 ] ;

}
else {
int localScope ;
localScope = 8 ;
localScope = returnedOne + returnedTwo ;
localScope = 5 + arrInOne [ 0 ] ;

}
return 0 ;

}
```

> Type comparisions only need to happen when storing a value that is returned from a function. This is because, we can return both `int` and `void` types from a funciton, while only being able to initilize variables as type `int`. So, we want to REJECT any cases where `varName = funReturnsVoid();`.