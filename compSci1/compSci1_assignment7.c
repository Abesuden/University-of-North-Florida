#include <stdio.h>

// part one 
  //void numberBreaker (float numIn, float* fractionPart, int* wholeNumber);
// part Two
 void moneyBreakdown (float moneyTot, int* dollars, int* quarters, int* dime, int* nickel, int* pennies);

int main(void) {
 // lesson
  /*
  int value = 5;
  int* address = &value;
  printf("usage of variable\n");
  printf("value: %d\n", *address);
  printf("address: %d\n");
  printf("\n");
  */
 // problem 1
  /*
  // initialization
    int wholeNumber = 0;
    float fractionPart = 0.0, numberFromUser;
  // prompt user and store variable
    printf("--Welcome to number break--\n  please enter a number...\n\n>>> ");
    scanf(" %f", &numberFromUser);
  // function call
  numberBreaker(numberFromUser, &fractionPart, &wholeNumber);
  // output data to user
  printf    (     "\n\nHere is the breakdown:"        );
  printf    (     "\nPart One: %d",     wholeNumber   );
  printf    (     "\nPart Two: %.2f",     fractionPart  );
  */

 // problem 2
  // initialization
    float moneyTot = 0;
    int dollars, quarters, dime, nickel, pennies;
  // prompt and get data 
    printf("--Welcome to your money breakdown--\n");
    printf("  Please enter your money total...\n");
    printf(">>> ");
    scanf(" %f", &moneyTot);
//function call
    moneyBreakdown(moneyTot, &dollars, &quarters, &dime, &nickel, &pennies);
  // print result
    printf(   "\n\nYour breakdown is:"  );
    printf(   "dollars %d\n", dollars     );
    printf(   "quarters: %d\n", quarters);
    printf(   "dime: %d\n", dime);
    printf(   "nickel: %d\n", nickel);
    printf(   "pennies: %d\n", pennies);

  return 0;
}

// functions
  // part one 
    /*
    void numberBreaker (float numIn, float* fractionPart, int* wholeNumber) {
      // initialization
        int partOne;
        float partTwo;
      // breaking 
      partOne = numIn;
      partTwo = numIn - partOne;
      *fractionPart = partTwo;
      *wholeNumber = partOne;
    }
    */
  // part Two
     void moneyBreakdown (float moneyTot, int* dollars, int* quarters, int* dime, int* nickel, int* pennies) {
    printf("stp0\n");
    int total = moneyTot * 100;
      *dollars  =  total / 100;
      total = total - (*dollars * 100);
      *quarters  =  total / 25;
      total = total - (*quarters * 25);
      *dime  =  total / 10;
      total = total - (*dime * 10);
      *nickel  =  total / 5;
      total = total - (*nickel * 5);
      *pennies = total;
      }