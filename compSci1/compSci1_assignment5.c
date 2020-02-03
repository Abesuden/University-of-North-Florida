#include <stdio.h>

long factorial (int n); 

int main(void) {
  int numN, returnVar;
  printf("Please enter a value for n:\n--> ");
  scanf(" %d", &numN);
  returnVar = factorial (numN);
  //printf("\n\n it's: %d", returnVar);
  printf("\n\n");
  return 0;
}

long factorial (int n) {
  if (n == 0) {
    return 1;
  }
  else {
    printf(">> %d\n", n);
    return (n * factorial (n-1));
    
  } 

}