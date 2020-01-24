// COP2220 TR 
/*
      By: Alex Besuden
          N00850421
      Date: 5/24/18 
*/

#include <stdio.h>
#include <math.h>

int main() {

/*
Given the pseudocode below write a solution in C
Read x
Read y
Compute p = x * y
Compute s = x + y
Total = s^2 + p * ( s – x ) * (p + y)
Print total
End program
*/

double x, y, p, s, tot, totl;

// prompt users
printf("\t\t-Welcome Agent 007-\n\nPlease enter the GPS coordinates for the enriched uranium:\n");
printf("\t\t\t\t-->");
scanf("%lf %lf", &x, &y);
printf("\nLocation aquired... \nThis is your encryption key:");

// equations
p = x * y;
s = x + y; 
//printf(" \n%.2f %.2f %.2f %.2f\n ", x, y, p, s);
tot = ( s * s ) + p * ( s - x ) * (p + y);
//totl = pow(s, 2) + p * ( s - x ) * (p + y);
// the format is pow(var, power#)


// Print to user
printf("\t--> %.4lf", tot);
//printf("\n\t--> %.4f", totl);




  return 0;
}