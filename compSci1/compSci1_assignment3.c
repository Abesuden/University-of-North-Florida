/*

loops ----------------------------------------------
  pretests = for, while
    for is a counter
    while is a boolen (test until the test is true/false)
      eg menu options until they exit out 
  postest = do while
    do while runs through code at least once (checks test case at bottom)


*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>  
/* ^--- allows for us to in a = rand(); function to generate random #'s based
  on computers clock which will be the same number in short term? or always?
  if want to make more random, use srand(time(NULL));

 // set maximum bound
  for (int k=0; k<5; k++) {
  int prob = rand() % 10 + 1;
  printf("Random in range 1-10, %d interation: %d\n", k, prob);
  }

 // set minimum bound and maximum?)
  for (int j=0; j<5; j++) {
  int proba = rand() % (10+1-5)+5;
  printf("Random in range 1-10, %d interation: %d\n", j, proba);
  }


*/

int main(void) {

/*
// loops
 // for loop --> for ( ; ; ) {}
    printf("for loop:/n");
  for ( int i=0; i<10; i++) {
  //     ^--- makes local in the loop but can do more global and set to i=0 instead
  //               ^--- counts 1, 2, 3, 4, 5, 6, 7, 8, 9 else can do i-1; i<=10
  //                        counts 2, 3, 4, 5, 6, 7, 8, 9, 10 --> same count
  //                    ^--- can also use ++i but doesnt change anything
    printf("%d", i);
  }


 // while loop
    printf("while loop:/n");
  int i = 0;
  while (i < 10) {
    printf("%d", i);
    i=++i;
    k=i;
  }


 // do while loop
    printf("do while loop:");
  int i = 0;
  do {
    printf("%d", i);
    ++i;
  }while(i < 10);
    printf("/n");
//  */



// problem 1
 // initilization
  char c;
  int head=0, tail=0;
  srand(time(NULL));  //used to initilize better random
  int randm = rand()+1;
  //int k, j;
 // prompt screen
  printf("Welcome to Russian Roulette!\n");
  printf("----------------------------\n\n");
  printf("Rules--------------------------------------------------------\n");
  printf("|                                                           |\n");
  printf("| 1) always use 3 bullets to give a half chance of losing!  |\n");
  printf("|                                                           |\n");
  printf("| 2) On \"Heads,\" YOU LOSE!                                  |\n");
  printf("|                                                           |\n");
  printf("| 3) When you lose, I get all of your Bitcoin fortune!      |\n");
  printf("|                                                           |\n");
  printf("-------------------------------------------------------------\n");
  printf("  When you are ready, please ~enter~ the room...\n");
  scanf("%c", &c);
  printf("\n\n");
 // coin flip
  for (int k=0; k<1; k++) {
    int coinToss = rand() % 2 + 1;
    // printf("%d - %d\n", k, coinToss);
    if (coinToss == 1) {
      tail++;
    } else {
      head++;
    }
  } 

  //printf ("h: %d and t: %d", head, tail);
    if (head == 1) {
      printf ("BANG! YOU LOSE!!!");
    } else {
      printf ("You Aquired: %d Bitcoins!!!", randm);
    }
    

// 
/*
// problem 2
 // initilization
    int threeRoll=0, three = 0, firstThree = 1, rollsReqThree=0;
    srand(time(NULL));
    char r;
 // prompt user
    printf("\nRoll dice and see the fate of three...");
    scanf("%c", &r);
 // roll die
  for (int k=0; k<10000; k++) {
    int diceRoll = rand() % 12 + 1;
    //printf("%d - %d\n", k, diceRoll);
    if (diceRoll == 3) {
      threeRoll++;
    }
    if (diceRoll == 3) {
         while (firstThree < 2) {
           firstThree++;
           rollsReqThree = k;
         }
    }

  } 
 // print results
  printf("\n\n  Rolls required to get first three are %d rolls\n\n", rollsReqThree);
  printf("\n  It takes %d times to get the 3.", threeRoll/12);


// class
 // this is an acutal loop and can run but will be infinite
  //  if (; ; ;) {
  //    printf("infinite loop");
  //  }
 
  // int x;
  // printf("Please enter a number or press the EOF to stop. For osprey it is ^d");
  // while (scanf("%d", &x) != EOF) {
    // sum += x;
  // }
*/
//end
  return 0;
}