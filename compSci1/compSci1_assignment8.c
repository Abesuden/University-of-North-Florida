#include <stdio.h>
#define ARRAY_SZ 8


void swaperoo(int*, int*);
void bubble(int[], int); //the int is the size of the VLAint 

int main(){
  int n = 8;//ARRAY_SZ; //sizeof(anArray);
  int anArray[8] = {7,3,66,3,-5,22,-77,2};
  int m;
  
  printf("The unsorted array is\t");
  
  for(m = 0; m < n;m++){
    printf(" %2d ", anArray[m]);
  }
  
  printf("\n");
  bubble(anArray, n);
  printf("The sorted array is\t");
  
  for(m = 0; m < n;m++){
    printf(" %2d ", anArray[m]);
  }
  
  printf("\n");
  return 0;
}//end main
  
  void swaperoo(int* a, int* b){
    int temp = *a;
    *a = *b;
    *b = temp;
  }
  
  void bubble(int a[],int n){
  
   int j, k;
   
   for (j = 0; j < n - 1; j++) {
    for (k = n - 1; k < j; k--) {
      if (a[k - 1] > a[k]) { // where decide to assend > or decend <
        swaperoo(&a[k - 1], &a[k]);
      } 
    }
   }
  }
