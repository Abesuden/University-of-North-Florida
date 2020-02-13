#include <stdio.h>

// function declarations
  int add(int, int);
  void goodbye(void);
  

// main
 int main(void) {
 //initiation
  int valOne = 2, valTwo = 3;
 // prompt user
  printf("Enter two numbers to add: ");
  scanf("%d %d", &valOne, &valTwo);
 // math function call
  int result = add(valOne, valTwo); // function call
 // print results
  printf("The sum of %d and %d is %d\n", valOne, valTwo, result);
 // function call
  goodbye();
 // exit
  return 0;
 }

// FUNCs
 // function add
  int add(int a, int b) {
    int sum = a + b;
    return sum;
   }
 // function goodbye
  void goodbye(void) {
  // print goodbye
    printf("The program is now complete, Goodbye!");
  // end
    return;
  }
//