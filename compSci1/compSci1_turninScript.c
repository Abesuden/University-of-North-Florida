//  Born 5.31.18
/*
  The below code is written to work with the bash terminal similar to how .bat work in cmd.
  system(""); is the terminal output function
*/

/*

//#include <stdio.h> //This is a Preprocessor Directive
//#include <stdlib.h>  //preprocessor directive for system call


 int main(void)
  {
  system("clear");
  // char nameOut[] = "<Alexander Besuden>"; // the [] seems to be important in all char data type pointers
  // printf("Hello World!!\nMy name is : %s \n\n", &nameOut);

// initiations
  //char command[50];
// system call
  //strcpy( command, "ls -l" );
  //system(command);


   return 0;

  }//end main


*/


#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main () {
// initiation
  char projectName[20];
  char turninCommand[50];
// promt user
  system("clear");  //clear screen
  printf("\n\n\t--Turn In--\n\nWhat is the assignment code:\n\n--> ");
// scanf
  scanf(" %s", &projectName);
// edit command string
  strcpy( turninCommand, " %s");
// system call
  system(turninCommand);
  printf("");



//end
   return 0;
  }

