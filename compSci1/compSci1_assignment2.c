#include <stdio.h>
#include <stdbool.h>

int main(void) {

/*

// bool test
 bool yes = true;
 if (yes) {
   printf("true is %d\n", yes);
  }

  if (!yes) {
    printf("false is %d\n", yes);
  }

// if statments with <, > or any combo
 int c = 5, d = 7;
 

 if (c < d) {
   printf("c is less then d");
 } else {
   printf("d is less then c");
 }


// if statements with && and ||
 int a = 5;
 int b = 6;
 
 if (a == 5 && b == 5) {
  printf("both a and b are 5\n");
 } else if (a == 5 || b == 5) {
  printf("a or b is 5\n");
 } else {
  printf("no variables are 5\n");
 }


// in class assignments


*/




 // prob 1
   // initilization
      int pris1, pris2, pris3, max, min, median;
   // prompt user
    printf("You have the chance to save three people...\n\nWe can't tell you which numbers represent\nwhich prisoner but please enter three numbers:\n\n\n");
   // scanf
        printf("prisoner one\t--> ");
    scanf("%d", &pris1);
        printf("prisoner two\t--> ");
    scanf("%d", &pris2);
        printf("prisoner three\t--> ");
    scanf("%d", &pris3);
    
    //printf("%d %d %d\n", pris1, pris2, pris3);
   // math
    // find min
     if(pris1 < pris2 && pris1 < pris3) {
       min = pris1;
     } else if (pris2 < pris1 && pris2 < pris3) {
       min = pris2;
     } else if (pris3 < pris1 && pris3 < pris2) {
       min = pris3;
     }
    // find max
      if(pris1 > pris2 && pris1 > pris3) {
       max = pris1;
     } else if (pris2 > pris1 && pris2 > pris3) {
       max = pris2;
     } else if (pris3 > pris1 && pris3 > pris2) {
       max = pris3;
     }
    // find median
      if(max != pris1 && min != pris1) {
       median = pris1;
      } else if (max != pris2 && min != pris2) {
       median = pris2;
      } else if (max != pris3 && min != pris3) {
       median = pris3;
      }



   // printf median
    printf("\n\nMinimum\t\tMedian\t\tMaximum\n-------\t\t------\t\t-------\n");
    printf("%7d\t\t%6d\t\t%7d\n", min, median, max);
 // prob 2
   // initilization
      int pris4, min2, max2, median2, median3;
      float median4;
   //promt user for 4th prisoner
     printf("\nLucky you, %d is a lucky number!\nPlease pick another prisoner:\n", median);
     printf("\nprisoner four\t--> ");
   //scan for pris4
     scanf("%d", &pris4);
   // math
    // find min     
     if(pris1 < pris2 && pris1 < pris3 && pris1 < pris4) {
       min2 = pris1;
     } else if (pris2 < pris1 && pris2 < pris3 && pris2 < pris4) {
       min2 = pris2;
     } else if (pris3 < pris1 && pris3 < pris2 && pris3 < pris4) {
       min2 = pris3;
     } else if (pris4 < pris1 && pris4 < pris2 && pris4 < pris3) {
       min2 = pris4;
     }
    // find max
     if(pris1 > pris2 && pris1 > pris3 && pris1 > pris4) {
       max2 = pris1;
     } else if (pris2 > pris1 && pris2 > pris3 && pris2 > pris4) {
       max2 = pris2;
     } else if (pris3 > pris1 && pris3 > pris2 && pris3 > pris4) {
       max2 = pris3;
     } else if (pris4 > pris1 && pris4 > pris2 && pris4 > pris3) {
       max2 = pris4;
     }

    // find median
      median4 = ((float)(pris1 + pris2 + pris3 + pris4 - max2 - min2))/2;

   // printf median2
     printf("\n\nMinimum\t\tMedian\t\tMaximum\n-------\t\t------\t\t-------\n");
     printf("%7d\t\t%6.2f\t\t%7d\n", min2, median4, max2);

   // closing
    printf("\nWow, you are a very lucky person!\n%.2f is another lucky number!\n\nALL PRISONERS ARE SAVED!!!\n", median4);

// end


return 0;
}
