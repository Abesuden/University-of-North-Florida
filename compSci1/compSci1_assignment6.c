#include <stdio.h>

float rounder(float passByValue);

int main(void) {
float userInput, compOutput;
while (1 == 1) {
  printf("please give me a number you would like be to round:\n\t--> ");
  scanf(" %f", &userInput);

  compOutput = rounder(userInput);

  printf("\n\nyour number rounded is:  %7.2f\n\n", compOutput);
}
  return 0;
}



float rounder(float passByValue) {
  int noDecimal;
    //printf("input:\n\t\t%f\n",passByValue);
  float output, decimalValue;
  passByValue = passByValue * 10000;
    //printf("divide by 100:\n\t\t%f\n",passByValue);
  noDecimal = (int)passByValue;
    //printf("Converting to int:\n\t\t%f %d\n",noDecimal,noDecimal);
  decimalValue = passByValue - noDecimal;
    //printf("decimal value:\n\t\t%f\n",decimalValue);
  if (decimalValue > 0.5) {
    noDecimal = noDecimal + 1;
    //printf("\nIf greater then .5\n\t\t%f %d\n",noDecimal,noDecimal);
  }

  output = ((float)noDecimal / 10000);
    //printf("output of function:\n\t\t%f\n",output);
  return output;
}