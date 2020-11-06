#include <Servo.h> 
 
Servo servo;

int pos = 0;  
 
void setup() 
{ 
  servo.attach(10);
} 
 
 
void loop() 
{ 
  for(pos = 0; pos < 60; pos += 1)   
  {                                  
    servo.write(pos);              
    delay(100);                      
  } 
  for(pos =60; pos>=1; pos-=1)    
  {                                
    servo.write(pos);             
    delay(100);                      
  } 
} 
