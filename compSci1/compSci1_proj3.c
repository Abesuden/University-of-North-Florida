// Project 3 - COP2220
 /*

  Written By:     Alexander Besuden
  Date:           6.7.18

 *   This program is to be used in an engineering firm to measure the performance of new vehicle designs. The engineer, user, will be entering data into this program which will perform computations on and will spit back out the following:
        * distance covered in meters (based on initial velocity)
        * rate of acceleration 
        * time of acceleration or travel 

 *   Functions used are printInstructions, getData, accelerationDisplacement, and printOutput.
     
     *  printInstructions function  
        ^--- this function is designed to create a user prompt for the engineer
        who is using the program. It determins whether the user wants to continue
        or not. If the user chooses to quite, the program will terminate.
     *  getData function
        ^--- this function is designed to have the engineer/user enter the data required
        by a mathmatical formula. This data will then be piped into another function. 
        Hence, the use of pointers for all the variables.
     *  accelerationDisplacement fucntion 
        ^---- this function will do the math required
        for the engineer to uptain the solution of 
        distance traveled.
     *  printOutput function 
        ^---- this function prints out the data values in a
        nice and orderly fasion. The output wil be the
        distance traveled by the vehicle along with a 
        feild of entered values so the engineer/user
        can check their values.

 */



#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// funct declerations
  int printInstructions           (                                                   );
  void getData                    (float* time, float* velocity, float* acceleration  );
  double accelerationDisplacement (float vi, float t, float a                         );
  void printOutput                (double result, float time, float velocity, float acceleration);


int main(void) {
 // intitilization
  // print instructions variables 
    int quitMain = 0;
  // get data variables 
    float time = 0, velocity = 0, acceleration = 0;
  // math 
    double finalValue = 0;
 // clear screen
  system("clear");
 // call functions
  while (quitMain == 0) {
    // instructions
      quitMain = printInstructions();
      if (quitMain == 1) {
        break;
      }
    // prompt user and get data  
      getData(&time, &velocity, &acceleration);
    // math
      finalValue = accelerationDisplacement(velocity, time, acceleration);
    // print results 
      printOutput(finalValue, velocity, time, acceleration);
    // break out of loop
      break;
  }
 // end main 
  return 0;
}


// functions 
 // printInstructions function  
  /*    ^--- this function is designed to create a user prompt for the engineer
         who is using the program. It determins whether the user wants to continue
         or not. If the user chooses to quite, the program will terminate.
  
  */
  int printInstructions() {
  // intitilization
   int quit = 0;
   char enter, exitLower = 'q', exitUpper = 'Q';
  // print welcome
   printf("   --Welcome to the Russian Emporium's Weapons Deparment--\n\t\t Hours:\t8-5 US daily\n\n^^^I am Sergei and can help you with any of your weapon needs^^^\n\n\n");
  // print quite or continue prompt
   printf("I see you are interested in our ViperX designs, it is from our enhanced\nspy car line... It comes with the following blue prints:\n");

   printf(   "\n\t\t||  -Leather Interior         ||"   );
   printf(   "\n\t\t||  -Autonomous Driving       ||"   );
   printf(   "\n\t\t||  -1500 Horse Power         ||"   );
   printf(   "\n\t\t||  -Under Water Capabilities ||"   );
   printf(   "\n\t\t||  -35k Round Gatling Gun    ||"   );
   printf(   "\n\t\t||  -Nuclear Fission Core     ||"   );
   printf(   "\n\t\t||  -Self Destruct            ||"   ); 

   printf(   "\n\n\t\t     !!!SPECIAL FEATURE!!!"        );
   printf(   "\n\t\t     ---------------------"          );
   printf(   "\n\t\t||    ~Quantum Time Drive~    ||"    ); 

   printf("\n\nTake notice of our special feature item! This item will allow you to travel\nfarther in less time! We have created a program to help you calculate the\nperformance of this vehicle design. With these designs you can be top\nengineer at your firm. It is easy as relax, submit, and be promoted!");

   printf("\n\nIf you you are interested, enter a any character to continue,\nelse enter 'q' or 'Q' to quite transaction...");  scanf(" %c", &enter);
  // create number to return
   if ((enter == 'q') || (enter == 'Q')) {
     quit = 1;
   } else {
     quit = 0;
   }
  // end 
   return quit;
  }
 // getData function
  /*   ^--- this function is designed to have the engineer/user enter the data required
        by a mathmatical formula. This data will then be piped into another function. 
        Hence, the use of pointers for all the variables.

  */
  void getData(float* time, float* velocity, float* acceleration) {
   // promt user  
    system ("clear");
    printf ("\tPlease enter the following information:\n\n"      );
    printf ("\tDelta change in time:\t\t--> "                    );
      scanf(  "%f", time                                         );
    printf ("\tVelocity of ViperX:\t\t--> "                      );
      scanf(  "%f", velocity                                     );
    printf ("\tAcceleration of the car:\t--> "                   );
      scanf(  "%f", acceleration                                 );
  }
 // find final value of accelerationDisplacement fucntion 
  /*                            ^---- this function will do the math required
                                for the engineer to uptain the solution of 
                                distance traveled.

  */
    double accelerationDisplacement(float vi, float t, float a) {
    // intitilization
      double fValue = 0;
    // math 
      fValue = ((vi * t) + ((0.5 * a) * (t * t)));
    // end
      return fValue;
    }
 // print out results with printOutput function 
  /*                          ^---- this function prints out the data values in a
                              nice and orderly fasion. The output wil be the
                              distance traveled by the vehicle along with a 
                              feild of entered values so the engineer/user
                              can check their values.

  */
    void printOutput(double result, float time, float velocity, float acceleration) {
      system("clear");
      printf("\t --------------------------"   );
      printf("\n\t The distance travelled by"  );
      printf("\n\t the ViperX in meters is:"   );
      printf("\n\t       >>%7.2f<<", result    );
      printf("\n\t"                            );
      printf("\n\t vi: %6.2f\t\t\t", time      );
      printf("\n\t t:  %6.2f", velocity        );
      printf("\n\t a:  %6.2f", acceleration    );
      printf("\n\t --------------------------" );
      printf("\n"                              );
    }
