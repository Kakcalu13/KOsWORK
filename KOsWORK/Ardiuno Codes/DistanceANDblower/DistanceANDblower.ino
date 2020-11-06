#include <Servo.h> 

Servo servo;

int Eye=A5,pos = 0, blow=12;

void setup() 
  {                
  Serial.begin(9600);
  servo.attach(9);
  pinMode(blow, OUTPUT);  
  }

void loop()  
  {
 
      for(pos = 0; pos < 90; pos ++)   
        { 
          Serial.println(analogRead(Eye));
          int distance= (analogRead(Eye));
         
         if (distance > 200)
          {
            digitalWrite(blow,HIGH);
            delay(100);
         
          }    
        else
          {
            digitalWrite(blow,LOW);
            servo.write(pos);
            delay(20);
          }       
          
        } 
      for(pos =90; pos>=1; pos--)    
        { 
             Serial.println(analogRead(Eye));
              int distance= (analogRead(Eye));
         if (distance > 200)
          {
            digitalWrite(blow,HIGH);
            delay(100);
            
          }     
          else
          {
            digitalWrite(blow,LOW);
            servo.write(pos);
            delay(20);
          }                
        }
  }
