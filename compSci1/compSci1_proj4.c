// Project 4 - COP2220
 /* program info

  Written By:     Alexander Besuden
  Date:           7.13.18

  *   This program is to be used in to prompt the user for a text document containing grades. The program will then load the student records containint the following:
        * student identification number
        * four student test grades (numerical)
     The program will then average the grades of the four tests, and then average the class grades. Once this has been done, the output will display the student averaged grades in descending order. The highest grade at the top of the screen.

  *   Functions used are arrayIn, avgFinal, bubbleSorter, and printOut.
     
     *  arrayIn function  
            ^--- The arrayIn function is used to pull data in from a user specified grade file and store it into an array.
     *  avgFinal function  
            ^--- The avgFinal function finds the average of the exam scores for each student and places the percent into the final column.
     *  bubbleSorter function  
            ^--- The bubbleSorter function sorts the final grades column in descending order.  
     *  printOut function  
            ^--- The printOut function prints out an organized table of student numbers, their grades, and averages along with the class average, lowest and highest student averages.
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define FLUSH while (getchar() != '\n');

// function list
  void arrayIn (char* userInput, int row, int col, float gradesArray[][col]);
  void avgFinal (int row, int col, float gradesArray[row][col]);
  void bubbleSorter (int row, int col, float gradesArray[row][col]);
  void printOut (int row, int col, float gradesArray[row][col]);

// main function
  int main(void) {
    // initialize
      int row = 10, col = 6;
      float gradesArray[row][col];
      char userInput [30];
      int arrySize = 0;
      // float classAvg = 0;
    // read in file to array
      arrayIn (userInput, row, col, gradesArray);     
    // average exams to final score and returns class average 
      // classAvg = avgFinal (row, col, gradesArray);
      avgFinal (row, col, gradesArray);
    // sorts the grades in decending order
      bubbleSorter (row, col, gradesArray);
    // print out grades
      printOut (row, col, gradesArray);
    // end
      return 0;
  }

// functions 
 // arrayIn -- create grades array function
  // The arrayIn function is used to pull data in from a user specified grade file and store it into an array.
  void arrayIn (char* userInput, int row, int col, float gradesArray[][col]) {
   // this function opens and reads in the text file into an array
    // file open
     // initialize
      int current, counter = 1;
      FILE *fp;
     while (counter == 1) {
      // promt user for text file
        printf("Please enter the text file you want to look at...\n");
        printf("\t--> ");
        scanf("%s", userInput);
        //fflush(stdin);
        //FLUSH;
        //userInput = "grades.txt";
        fp = fopen(userInput, "r");
        if (fp == NULL) {
          printf("ERROR - FILE NOT FOUND\n\n------------------------------------------------\n");
        } else {
          printf("\n\n");
          printf("        Mother Russia University Top Students\n\n");
          counter = 0;
        }
     }

    // pulling data to make array
     int rowA = 0;
     int colA = 0;
     int i = 1; 
     while (fscanf(fp, "%d", &current) == 1) {
      gradesArray[rowA][colA] = current;
      colA++;
      i++;
       if (i == 6) {
         rowA++;
         colA = 0;
         i = 1;
       }
     }
    // close file 
     fclose(fp);
        /*         
         for (int i = 0; i < 10; i++) {
           for (int j = 0; j < 5; j++) {
               printf("%f\t", gradesArray[i][j]);
           }
         }
         printf("\n");
         */
  }
 // avgFinal -- average the final grade
  // The avgFinal function finds the average of the exam scores for each student and places the percent into the final column.
  void avgFinal (int row, int col, float gradesArray[row][col]) {
    // initialization
      float rowAverage = 0, rowSum = 0, classAvg = 0;
    // math
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 6; j++) {  
        if ((j > 0) && (j < 5)) {
          rowSum = rowSum + gradesArray[i][j];
          // printf(" %.2f ", gradesArray[i][j]); // test
        }
          if (j == 5) {
            rowAverage = rowSum/4;
            rowSum = 0;
            //printf(" %.2f ", rowAverage); // test
            gradesArray[i][j] = rowAverage;
          }
      }
      classAvg = classAvg + rowAverage;
      //printf("\n"); // test
    }
    classAvg = classAvg/10;
    // printf("\t\t\t     %.2f \n\n", classAvg); // test
    // return classAvg;
  }

 // bubbleSorter -- sorts by the last column (final)
  // The bubbleSorter function sorts the final grades column in descending order.
  void bubbleSorter (int row, int col, float gradesArray[row][col]) {
    // initialization
      float buffer = 0;
    // bubble sort
      for (int k = 0; k < 10; k++) {
        for (int i = 0; i < 10; i++) {
          // printf("%.2f\n", gradesArray[i][5]); // test
          if (gradesArray[i][5] < gradesArray[i+1][5]) {
            for (int j = 0; j < 5; j++) {
              buffer = gradesArray[i+1][j];
              gradesArray[i+1][j] = gradesArray[i][j];
              gradesArray[i][j] = buffer;
            }
          }
        }
      }
  }
 // printOut -- print out results function
  // The printOut function prints out an organized table of student numbers, their grades, and averages along with the class average, lowest and highest student averages.
  void printOut (int row, int col, float gradesArray[row][col]){
    // initialization
      float sum = 0, clsAvg, high = 0, low = 100;
    // display
      printf("Student ID  Exam 1  Exam 2  Exam 3  Exam 4 |   Final\n");
      printf("------------------------------------------ + =========");
      printf("\n");
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 6; j++) {
         // changes printout for average grades vs individual test grades
          if (j == 5) {
            printf(" |   %05.2f", gradesArray[i][j]);
            // math step 1
              sum = sum + gradesArray[i][j];
            // sorting high and low average grades
              if (j != 0) {
                if (gradesArray[i][j] > high) {
                  high = gradesArray[i][j];
                } else if (gradesArray[i][j] < low) {
                  low = gradesArray[i][j];
                }
              }
          } else {
            printf("   %.0f\t  ", gradesArray[i][j]);
          }
        }
      printf("\n");
    }
  // math step 2
    clsAvg = sum/10;
  // final display 
    printf("------------------------------------------------------\n");
    //printf("Class Avg: 00.00  |  Highest: 00.00  |  Lowest: 00.00\n\n");
    printf("Class Avg: %5.2f  |  Highest: %5.2f  |  Lowest: %5.2f\n\n", clsAvg, high, low);
  }






