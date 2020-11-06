#include <stdio.h>
//#include <Servo.h>

//Servo servo;

int feeling=A4, red=4, blue=5, green=6, lightPin = A2, ledPin=7;
int nightLight=10,darkness=0,distance=0, eye=A5, support=2;
const int PWM_A =3, DIR_A=12, BRAKE_A=9, PWM_B=11, DIR_B=13, BRAKE_B=8;

void setup()
{
  Serial.begin(9600);
  pinMode(red, OUTPUT);
  pinMode(blue, OUTPUT);
  pinMode(green, OUTPUT);
  pinMode(ledPin, OUTPUT);
  pinMode(DIR_A, OUTPUT);
  pinMode(DIR_B, OUTPUT);
  pinMode(BRAKE_A, OUTPUT);
  pinMode(BRAKE_B, OUTPUT);
//  servo.attach(2);//2 pin
}

void loop()
{
  int sensorValue = analogRead(feeling);
  
  float voltage = sensorValue * (5.0 / 1023.0);
  if (voltage > 4.50)
  {
    digitalWrite(green,LOW);
    digitalWrite(blue, LOW);
    digitalWrite(red, HIGH);//for people who pet this too hard or harsh.
    digitalWrite(support, LOW);
}
  else if (voltage < 4.50 && voltage > .50 )
  {
    digitalWrite(green, LOW);
    digitalWrite(red, LOW);
    digitalWrite(blue,HIGH); //it feels so pleasure.
    digitalWrite(support, HIGH);
    //udelay(1000);
  }
  else
  {
    digitalWrite(red, LOW);
    digitalWrite(blue, LOW);
    digitalWrite(support, LOW);
    digitalWrite(green, HIGH);//when no one pet this
  }
  Serial.print("int voltage: ");
  Serial.println(voltage);
  
//  Serial.print("photoresistor: ");
//  Serial.println(analogRead(lightPin));
  darkness=analogRead(lightPin);
  //analogWrite(ledPin, analogRead(lightPin)/4);
  if (darkness <= 540 )
    {
      digitalWrite(nightLight, HIGH);
      digitalWrite(ledPin, HIGH);
//      delay(1000);
    }
  else
  {
    digitalWrite(ledPin, LOW);
    digitalWrite(nightLight, LOW);//check this. This probably
    //cause some errors.
  }
   /*Serial.print("Wheels and Sensor now: ");
   Serial.println(analogRead(eye));*/  
   distance=analogRead(eye);
   if (distance > 150)
   {
    digitalWrite(BRAKE_A, HIGH); 
    digitalWrite(DIR_A, LOW); 
    analogWrite(PWM_A, 255);
    digitalWrite(BRAKE_B, HIGH);
    digitalWrite(DIR_B, LOW); 
    analogWrite(PWM_B, 255);
//    delay(1000);
    digitalWrite(BRAKE_A, LOW);
    analogWrite(PWM_A, 255); 
    digitalWrite(DIR_A, LOW);
//    delay(2000);
    digitalWrite(BRAKE_A, HIGH);
//    Serial.println(analogRead(eye));
    distance=analogRead(eye);
          if (distance > 150)
         {
             digitalWrite(BRAKE_B, LOW);
             analogWrite(PWM_A, 255); 
             digitalWrite(DIR_B, LOW);
//             delay(2000);
             digitalWrite(BRAKE_B, HIGH); 
         } 
  }
  analogWrite(PWM_A, 255);
  analogWrite(PWM_B, 255);
  digitalWrite(BRAKE_A, LOW); 
  digitalWrite(DIR_A, HIGH);
  digitalWrite(BRAKE_B, LOW); 
  digitalWrite(DIR_B, HIGH);
  
  delay(10);
}
