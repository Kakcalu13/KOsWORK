#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int Left_fist=12, Right_fist=11, Left_jab=10, Right_jab=9;
int Right_leg=8, Left_leg=7, middle=6, randomNumber;
int test=0;

void setup()
{
  pinMode(Left_fist, OUTPUT);
  pinMode(Right_fist, OUTPUT);
  pinMode(Left_jab, OUTPUT);
  pinMode(Right_jab, OUTPUT);
  pinMode(Right_leg, OUTPUT);
  pinMode(Left_leg, OUTPUT);
  pinMode(middle, OUTPUT);
  Serial.begin(9600);
  randomSeed(analogRead(0));
}

void loop()
{
  if (test == 0)
  {
    test=1;
    digitalWrite(Left_fist, HIGH);
    digitalWrite(Right_fist, HIGH);
    digitalWrite(Left_jab, HIGH);
    digitalWrite(Right_jab, HIGH);
    digitalWrite(Left_leg, HIGH);
    digitalWrite(Right_leg, HIGH);
    digitalWrite(middle, HIGH);
    delay(5000);
    digitalWrite(Left_fist, LOW);
    digitalWrite(Right_fist, LOW);
    digitalWrite(Left_jab, LOW);
    digitalWrite(Right_jab, LOW);
    digitalWrite(Left_leg, LOW);
    digitalWrite(Right_leg, LOW);
    digitalWrite(middle, LOW);
  }
    
  randomNumber= random(1,7);
  int speedlimit=200; //2 sec
  delay(500);
  switch (randomNumber){
      case 1: 
        digitalWrite(Left_fist, HIGH);
        Serial.println("Left fist!");
        printf("This");
        delay(speedlimit);
        digitalWrite(Left_fist, LOW);
        break;
      case 2:
        digitalWrite(Right_fist, HIGH);
        Serial.println("Right fist!");
        delay(speedlimit);
        digitalWrite(Right_fist, LOW);
        break;
      case 3:
        digitalWrite(Left_jab, HIGH);
        Serial.println("Left jab!");
        delay(speedlimit);
        digitalWrite(Left_jab, LOW);
        break;
      case 4:
        digitalWrite(Right_jab, HIGH);
        Serial.println("Right jab!");
        delay(speedlimit);
        digitalWrite(Right_jab, LOW);
        break;
      case 5:
        digitalWrite(Right_leg, HIGH);
        Serial.println("Right leg!");
        delay(speedlimit);
        digitalWrite(Right_leg, LOW);
        break;
      case 6:
        digitalWrite(Left_leg, HIGH);
        Serial.println("Left leg!");
        delay(speedlimit);
        digitalWrite(Left_leg, LOW);
        break;
      case 7:
         digitalWrite(middle, HIGH);
         Serial.println("Middle leg!");
         //delay(speedlimit);
         digitalWrite(middle, LOW);
         break;
  }
  
  
}
