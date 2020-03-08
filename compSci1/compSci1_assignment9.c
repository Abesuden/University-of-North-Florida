#include <stdio.h>
#include <string.h>

int main(void) {


char input[100];
char word[20];
int letterCount = 0;
fgets(input, 100, stdin);
//puts(input);

for (int i = 0; i < strlen(input); i++) {
  if ((input[i] == ' ') || (input[i] == '.')) {
    word[letterCount] = '\0';
    //puts(word);
    if ((word[0] == 'a') || (word[0] == 'e') || (word[0] == 'i') || (word[0] == 'o') || (word[0] == 'u') || (word[0] == 'y') ) {
      strcat(word, "ay");
      puts(word);
    } else {
      char first = word[0];
      for (int i = 0; i < strlen(word)-1; i++) {
        word[i] = word[i + 1];
      }
      word[strlen(word) - 1] = first;
      strcat(word, "ay");
      puts(word);
    }
    letterCount = 0;
  } else {
    word[letterCount] = input[i];
    letterCount++;
  }
}




  return 0;
}