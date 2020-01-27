#include <stdio.h>

/*
void computeTriangleArea(int, int, float*);
void computeTrianglePerimeter(int, int, float*);
// dont have to put variable names in here but we do in header

int main(void) {

  int a, b;
  //float*            area, perim;   causes issues
   //treat as pointer---^     ^----treat as float
  float* area;
  float* perim;
  printf("enter in vlaues for a and b as two integers.\n");
  scanf(" %d", &a);
  scanf(" %d", &b);

  computeTriangleArea(a, b, area);
 //   pass by value---^       ^--- dont need '&' because pass by address
  //computeTrianglePerimeter(&a, &b, perim);

  printf("The area is: %lf\n", *area);

  return 0;
}


void computeTriangleArea(int aIn, int bIn, float* areaIn) {
      printf("The area is: %lf\n", *areaIn);
  *areaIn = ((aIn * bIn) * .5);
}


void computeTrianglePerimeter(int aIn, int bIn, float* perimeterIn) {

}
*/

// recursive


int sum(int n);

int main (void) {

  int numIn, sumOut;

  while (1==1) {
  printf("Enter a positive integer:\n");
  scanf(" %d", &numIn);

  sumOut = sum(numIn);
  printf("the resutls are: %d\n\n", sumOut);
  }


  return 0;
}


int sum(int num) {
  int holder = 0;
  int sumHere = 0;
  if (num != 0) {
    holder = num + sum(num - 1); // this is where we are decrementing
    printf("current value of sum: %d\n", holder);
    return holder;
  } else {
    return num; //this is when we have reached the base case
  }
}

/*  
 power point slide
 a function is called by the caller-
 functions in c are passed by value- and they are consided call by value
 call by refernce is simulated by passing the   address- ???
 in order to call by reference we need tu utilize the &- operator which exposes the address of a cariable
 a  pointer- to a type already has an address as its value
 we access the value pointed to by a pointer using the indirection- operator, which exposes the value of the variable we are pointing to
 we get the address of a variable by   &-
 */