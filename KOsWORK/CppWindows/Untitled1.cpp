//Treasure Chest Game
// Group assignment #1 Spring 2014
// Group:  ANNA FAST, KEVIN ARAUJO-MURILLO, DARRIUS TRUSTY

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
int main(int argc, char *argv[])
{
  int num = 0;  // Random Number 1, 2, or 3
   int total = 0;  // Total Chips
    int answer = 0;  // Chest Number input by user
   
    srand(time(NULL));
   
    printf("If you are done with this game, press 9 to stop\n");  // How to end the game
   
    while (answer != 9)
        {
            printf("Please input 1, 2 or 3 to choose a Treasure Chest and continue: \n");  // How to play the game
            scanf("%d", &answer);                                                          // Reads the number input by user
           
       
          if (answer == 9)
            {
                break;                       // Exits game by choice                                      
            }
           
          else if (answer <= 3&&answer >= 1)
            {
                num = rand()% 3 + 1 ;       // Generates random number 1, 2, or 3
               
                if (num == 1)
                    {
                        printf("Chest %d opened... You got 400 chips!\n",answer);
                        total += 400;
                    }
                else if (num == 2)
                   {
                        printf("Chest %d opened... You got 200 chips!\n",answer);
                        total += 200;
                    }
                else if (num == 3)
                    {
                        printf("Chest %d opened... You got 0 chips so that means YOU LOST! GAME OVER\n",answer);
                        total *= 0;
                        break;             // Exits lost game
                    }
       
                printf("Your total is %d chips!!!\n",total);   // Displays total number of chips won
               
            }
        }
  system("PAUSE");   
  return 0;
}

